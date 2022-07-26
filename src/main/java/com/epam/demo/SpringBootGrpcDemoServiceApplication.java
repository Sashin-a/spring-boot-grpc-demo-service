package com.epam.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;

@SpringBootApplication
public class SpringBootGrpcDemoServiceApplication {


	public static void main(String[] args) throws IOException, InterruptedException {
//		SpringBootGrpcDemoServiceApplication springBootGrpcDemoServiceApplication = new SpringBootGrpcDemoServiceApplication();
//		springBootGrpcDemoServiceApplication.startServer();
//		springBootGrpcDemoServiceApplication.blockUnitlShutdown();
		SpringApplication.run(SpringBootGrpcDemoServiceApplication.class, args);
	}

//	private Server server;
//
//	public void startServer() throws IOException {
//		Integer port =9999;
//		server = ServerBuilder.forPort(port).addService(new GrpcUserServiceImpl()).build().start();
//	}
//	public void blockUnitlShutdown() throws InterruptedException {
//		if(server!=null)
//		{
//			server.awaitTermination();
//		}
//	}
}
