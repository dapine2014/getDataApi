package org.getdataapi.config;

import feign.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import java.security.NoSuchAlgorithmException;


@Configuration
public class FeignConfig {

    @Bean
    public Client feignClient() throws NoSuchAlgorithmException {
        System.setProperty("jdk.tls.maxHandshakeMessageSize", "65536");
        return new Client.Default(getSSLSocketFactory(), null);
    }

    private SSLSocketFactory getSSLSocketFactory() throws NoSuchAlgorithmException {
        return SSLContext.getDefault().getSocketFactory();
    }

}
