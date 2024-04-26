package iuh.store_event_driven.service;

import com.google.gson.Gson;
import iuh.store_event_driven.entity.Product;
import jakarta.jms.*;
import org.springframework.stereotype.Service;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

@Service
public class InventoryService {
    private Context ctx;
    public Connection connectActiveMQ() throws NamingException, JMSException {
        Properties props = new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
        ctx = new InitialContext(props);
        ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup("ConnectionFactory");
        return connectionFactory.createConnection("admin", "admin");
    }

    public void receiveMessage() throws NamingException, JMSException {
        Connection con = connectActiveMQ();
        con.start();

        Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = (Topic) ctx.lookup("dynamicTopics/inventory01");
        MessageConsumer consumer = session.createConsumer(topic);
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                if(message instanceof TextMessage) {
                    try {
                        String mes = ((TextMessage) message).getText();
                        Product product = new Gson().fromJson(mes, Product.class);
                        System.out.println("Received:*******-> " + product.toString());
                    } catch (JMSException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }
}
