package fr.yanissou.lespainsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class LespainsapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LespainsapiApplication.class, args);

        //Create file if it doesn't exist
        File file = new File(System.getenv().getOrDefault("FILE_PATH", "hahahahaa"));

        File parentDir = file.getParentFile();
        if (!parentDir.exists()) {
            parentDir.mkdirs();  // Créer les répertoires si nécessaire
        }

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
