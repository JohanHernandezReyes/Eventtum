package Eventtum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("Eventtum.Modelo")
public class EventtumApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventtumApplication.class, args);
	}

}
