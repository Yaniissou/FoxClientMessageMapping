package fr.yanissou.lespainsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;

@SpringBootApplication
public class LespainsapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LespainsapiApplication.class, args);
    }
}
