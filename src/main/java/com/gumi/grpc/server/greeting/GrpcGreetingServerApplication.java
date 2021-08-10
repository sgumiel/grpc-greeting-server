package com.gumi.grpc.server.greeting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GrpcGreetingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrpcGreetingServerApplication.class, args);
	}

}
