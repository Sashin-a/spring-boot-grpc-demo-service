package com.epam.demo.service;

import com.epam.proto.stubs.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase{

    @Override
    public void getUserDetails(UserRequest request, StreamObserver<UserResponse> responseObserver) {

        UserResponse userResponse = UserResponse.newBuilder().setGender(Gender.MALE)
                .setId(1)
                .setName("Sashin Agrawal")
                .setUsername("sashin_agrawal")
//                .setLocation(0, Location.newBuilder().setLocationId(123)
//                        .setLocationName("Hyderabad").setPhoneNum("9907").build())
                        .build();

        responseObserver.onNext(userResponse);
        responseObserver.onCompleted();
    }
}
