package com.fundify.fundify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class FundifyApplication {

    public static final Logger log = LoggerFactory.getLogger(FundifyApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(FundifyApplication.class, args);
    }

}
