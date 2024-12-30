package hello.externalread2;

import hello.externalread2.config.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Import;

@Import(MyDataSourceConfigV3.class)
@SpringBootApplication(scanBasePackages = {"hello.externalread2.datasource", "hello.externalread2.pay"})
public class ExternalRead2Application {

	public static void main(String[] args) {
		SpringApplication.run(ExternalRead2Application.class, args);
	}

}
