package edu.usc.cgsa.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * @author Ronan
 * @email crnoogle@gmail.com
 * @date 2/8/20
 * @website
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class CGSAWebsiteBackendApplication {
  public static void main(String[] args) {
    SpringApplication.run(CGSAWebsiteBackendApplication.class, args);
  }
}
