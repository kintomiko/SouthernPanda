package org.nzcn.landing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by kinlin on 8/26/16.
 */

@SpringBootApplication
@EnableTransactionManagement
@ComponentScan
@EnableAutoConfiguration
public class LandingApplication {

    public static void main(String args[]){
        SpringApplication.run(LandingApplication.class, args);
    }
}
