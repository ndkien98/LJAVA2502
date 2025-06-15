package vn.com.claim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "vn.com.claim")
public class ClaimApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClaimApplication.class, args);
	}

}
