package fr.yanissou.lespainsapi;

import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/messages")
@CrossOrigin(origins = "http://message.yanissou.ovh")
public class MessageController {

    @GetMapping
    public String getMessage() throws IOException {
        final String filePath = System.getenv().getOrDefault("FILE_PATH", "/app/messages.txt");
        final List<String> list = new ArrayList<>();
        final BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        String s;

        while ((s = bufferedReader.readLine()) != null) {
            s = s.trim();

            if (!s.isEmpty()) {
                list.add(s);
            }
        }

        bufferedReader.close();
        return list.get(new Random().nextInt(list.size()));
    }

    @PostMapping
    public void putMessage(@RequestParam String message) throws IOException {
        final String filePath = System.getenv().getOrDefault("FILE_PATH", "/app/messages.txt");
        final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));


        bufferedWriter.write(message);
        bufferedWriter.newLine();
        bufferedWriter.close();
    }

    @GetMapping("/list")
    public List<String> list() throws IOException {
        final String filePath = System.getenv().getOrDefault("FILE_PATH", "/app/messages.txt");
        final BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        final List<String> messageList = new ArrayList<>();
        String s;

        while ((s = bufferedReader.readLine()) != null) {
            messageList.add(s);
        }

        bufferedReader.close();
        return messageList;
    }
}
