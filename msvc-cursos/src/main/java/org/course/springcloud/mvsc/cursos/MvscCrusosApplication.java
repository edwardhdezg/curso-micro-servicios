package org.course.springcloud.mvsc.cursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MvscCrusosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvscCrusosApplication.class, args);
	}

}
