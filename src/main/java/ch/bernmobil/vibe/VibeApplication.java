package ch.bernmobil.vibe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;

@SpringBootApplication
public class VibeApplication extends AsyncConfigurerSupport {
    public static void main(String[] args) {
        SpringApplication.run(VibeApplication.class, args);
    }
}
