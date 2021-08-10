package com.gumi.grpc.server.greeting.map;

import com.gumi.grpc.greeting.model.GreetingRequest;
import com.gumi.grpc.server.greeting.model.Greeting;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GreetingGrpcMapper {


    Greeting toDomain(GreetingRequest source);
}
