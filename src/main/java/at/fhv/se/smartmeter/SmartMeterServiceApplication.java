package at.fhv.se.smartmeter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class SmartMeterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartMeterServiceApplication.class, args);
	}

}
