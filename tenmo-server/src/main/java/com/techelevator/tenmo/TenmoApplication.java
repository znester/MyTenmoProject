package com.techelevator.tenmo;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TenmoApplication {

    public static void main(String[] args) throws NoSuchBeanDefinitionException {
        SpringApplication.run(TenmoApplication.class, args);
    }

}
