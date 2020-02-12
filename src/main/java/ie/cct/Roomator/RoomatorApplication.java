package ie.cct.Roomator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ie.cct.*")
public class RoomatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomatorApplication.class, args);
	}

}
