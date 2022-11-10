package totvs;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class TotvsApp {

    public static void main(String[] args) {
        SpringApplication.run(TotvsApp.class, args);
    }

}