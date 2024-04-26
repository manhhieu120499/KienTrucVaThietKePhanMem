package iuh.store_event_driven.service;

import com.google.gson.Gson;
import iuh.store_event_driven.entity.Product;
import jakarta.jms.*;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.FileReader;
import java.util.Properties;

public class MessageSender {
    public static void main(String[] args) throws NamingException, JMSException {
        Properties props = new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
        Context ctx = new InitialContext(props);
        ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup("ConnectionFactory");
        Connection con = connectionFactory.createConnection("admin", "admin");

        con.start();
        Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageProducer producer = session.createProducer((Topic) ctx.lookup("dynamicTopics/inventory01"));
        TextMessage message = session.createTextMessage(readFileJson("src/main/java/iuh/store_event_driven/data/detailProduct.json"));
        producer.send(message);
        System.out.println("Message sent successfully");
        con.close();


    }

    public static String readFileJson(String path){
        try(
                JsonReader reader = Json.createReader(new FileReader(path));
                ){
            JsonObject jsonObject = reader.readObject();
            JsonObject amazonProduct = jsonObject.getJsonObject("amazonProduct");
            Product product = new Gson().fromJson(amazonProduct.toString(), Product.class);
            return amazonProduct.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

}
