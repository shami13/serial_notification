package ua.com.shami.serialnotification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class SerialNotificationApplication {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(SerialNotificationApplication.class, args);
    }
}

