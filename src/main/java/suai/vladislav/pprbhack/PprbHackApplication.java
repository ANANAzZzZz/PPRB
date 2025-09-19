package suai.vladislav.pprbhack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PprbHackApplication {

    public static void main(String[] args) {
        SpringApplication.run(PprbHackApplication.class, args);
    }

}
