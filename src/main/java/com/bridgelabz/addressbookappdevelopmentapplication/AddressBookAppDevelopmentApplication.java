package com.bridgelabz.addressbookappdevelopment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication

public class AddressBookAppDevelopmentApplication {

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book App");
        ApplicationContext context = SpringApplication.run(AddressBookAppDevelopmentApplication.class, args);
        log.info("Address Book App Started in {} Environment",
                context.getEnvironment().getProperty("environment"));
        log.info("Address Book App DB User is {}",
                context.getEnvironment().getProperty("spring.datasource.username"));
    }

}
