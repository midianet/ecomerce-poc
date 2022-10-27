package vtex;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class VtexApp {

    public static void main(String[] args) {
        SpringApplication.run(VtexApp.class, args);
    }

}