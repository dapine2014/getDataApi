package org.getdataapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class GetDataApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetDataApiApplication.class, args);
    }

}
