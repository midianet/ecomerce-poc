package meta.ecometa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class EcometaApp {

    public static void main(String[] args) {
        SpringApplication.run(EcometaApp.class, args);
        log.info("Iniciando o Sistema de Ecometa...");
    }

}
