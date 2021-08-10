package com.gumi.grpc.server.greeting.infrastructure;

import com.gumi.grpc.greeting.model.GreetingRequest;
import com.gumi.grpc.greeting.model.GreetingResponse;
import com.gumi.grpc.greeting.service.GreetingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreetingGrpcService extends GreetingServiceGrpc.GreetingServiceImplBase {

    private final String GREETING_PATTERN = "Hello %s! My favourite city is %s";

    @Override
    public void greeting(GreetingRequest greetingRequest, StreamObserver<GreetingResponse> streamObserver) {

        final var name = greetingRequest.getName();
        final var city = greetingRequest.getCity();
        final var greeting = String.format(GREETING_PATTERN, name, city);

        final var response = GreetingResponse.newBuilder()
                .setGreeting(greeting)
                .build();

        streamObserver.onNext(response);
        streamObserver.onCompleted();
    }
}
