package org.springframework;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.config.SpringApplication;
import org.springframework.web.annotation.ServletLoadOnStartUp;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ServletLoadOnStartUp(loadOnStartUp = 1)
public class Application {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(Application.class,args);
    }
}