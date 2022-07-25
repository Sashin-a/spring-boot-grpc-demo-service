package com.epam.demo.service;

import com.epam.demo.entity.UserEntity;
import com.epam.proto.stubs.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@GrpcService
public class GrpcUserServiceImpl extends GrpcUserServiceImplGrpc.GrpcUserServiceImplImplBase{

    @PostConstruct
    public void execute()
    {
        System.out.println("**********************************Created******************");
    }
    @Autowired
    private UserService userService;

    @Override
    public void getUserDetails(UserRequest request, StreamObserver<UserResponse> responseObserver) {

        UserEntity entity = userService.getUserById(request.getId());
        UserResponse userResponse = UserResponse.newBuilder().setGender(Gender.valueOf(entity.getGender()))
                .setId(entity.getId())
                .setName(entity.getName())
                .setUsername(entity.getUsername())
                .build();

        responseObserver.onNext(userResponse);
        responseObserver.onCompleted();
    }



    @Override
    public void saveUserDetails(UserRequestForSave request, StreamObserver<UserResponse> responseObserver) {

        UserEntity userEntity  = new UserEntity();
        userEntity.setGender(request.getGender().name());
        userEntity.setName(request.getName());
        userEntity.setUsername(request.getUsername());

        UserEntity userEntityResp = userService.save(userEntity);
        UserResponse userResponse = UserResponse.newBuilder().setGender(Gender.valueOf(userEntityResp.getGender()))
                .setName(userEntityResp.getName())
                .setId(userEntity.getId())
                .setUsername(userEntity.getUsername()).build();
        responseObserver.onNext(userResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void getUserDetailsServerStream(UserRequest request, StreamObserver<UserResponse> responseObserver) {
        UserEntity entity = userService.getUserById(request.getId());
        UserResponse userResponse = UserResponse.newBuilder().setGender(Gender.valueOf(entity.getGender()))
                .setId(entity.getId())
                .setName(entity.getName())
                .setUsername(entity.getUsername())
                .build();

        for (int i=0; i<5; i++)
        {
            try {
                TimeUnit.SECONDS.sleep(1);
                responseObserver.onNext(userResponse);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        responseObserver.onCompleted();
    }
}
