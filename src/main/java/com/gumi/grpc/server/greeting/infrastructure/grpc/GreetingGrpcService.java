package com.gumi.grpc.server.greeting.infrastructure.grpc;

import com.gumi.grpc.greeting.model.GreetingRequest;
import com.gumi.grpc.greeting.model.GreetingResponse;
import com.gumi.grpc.greeting.service.GreetingServiceGrpc;
import com.gumi.grpc.server.greeting.model.Greeting;
import com.gumi.grpc.server.greeting.model.repository.GreetingRepository;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Value;

@GrpcService
@RequiredArgsConstructor
public class GreetingGrpcService extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Value("${greeting.pattern:%s%s}")
    private String GREETING_PATTERN;

    private final GreetingRepository greetingRepository;

    @Override
    public void greeting(GreetingRequest greetingRequest, StreamObserver<GreetingResponse> streamObserver) {

        final var name = greetingRequest.getName();
        final var city = greetingRequest.getCity();
        final var message = String.format(GREETING_PATTERN, name, city);

        final var greeting = Greeting.builder()
                .name(name)
                .city(city)
                .message(message).build();

        final var greetingSaved = this.greetingRepository.save(greeting);

        final var greetingResponse = GreetingResponse.newBuilder()
                .setId(greetingSaved.getId())
                .setGreeting(greetingSaved.getMessage())
                .build();

        streamObserver.onNext(greetingResponse);
        streamObserver.onCompleted();
    }
}
