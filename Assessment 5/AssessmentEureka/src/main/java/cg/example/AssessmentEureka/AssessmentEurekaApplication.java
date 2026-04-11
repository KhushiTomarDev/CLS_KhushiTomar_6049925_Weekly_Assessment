package cg.example.AssessmentEureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class AssessmentEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssessmentEurekaApplication.class, args);
	}

}
