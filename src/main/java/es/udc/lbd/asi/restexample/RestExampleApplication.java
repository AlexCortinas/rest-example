package es.udc.lbd.asi.restexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class RestExampleApplication {

  public static void main(String[] args) {
    SpringApplication.run(RestExampleApplication.class, args);
  }

}
