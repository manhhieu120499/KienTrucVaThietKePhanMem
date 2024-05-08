package org.example.product_jms_exerciselearn;

import org.antlr.v4.runtime.misc.LogManager;
import org.example.product_jms_exerciselearn.entity.Product;
import org.example.product_jms_exerciselearn.repository.ProductRepository;
import org.example.product_jms_exerciselearn.services.ProductImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductJmsExerciseLearnApplication {

    public static void main(String[] args) {

        SpringApplication.run(ProductJmsExerciseLearnApplication.class, args);
    }

}
