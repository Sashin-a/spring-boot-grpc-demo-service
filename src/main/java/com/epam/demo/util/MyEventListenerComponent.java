//package com.epam.demo.util;
//
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MyEventListenerComponent {
//
//    @EventListener
//    public void onServerStarted(GrpcServerStartedEvent event) {
//        System.out.println("gRPC Server started, listening on address: " + event.getAddress() + ", port: " + event.getPort());
//    }
//
//}