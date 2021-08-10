package com.gumi.grpc.server.greeting.it;

import com.gumi.grpc.greeting.model.GreetingRequest;
import com.gumi.grpc.greeting.service.GreetingServiceGrpc;
import com.gumi.grpc.server.greeting.common.CommonIT;
import com.gumi.grpc.server.greeting.infrastructure.db.repository.jpa.GreetingJpaRepository;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class GreetingITest extends CommonIT {

    @GrpcClient("greetingService")
    private GreetingServiceGrpc.GreetingServiceBlockingStub greetingService;

    @Value("${greeting.pattern}")
    private String pattern;

    @Autowired
    private GreetingJpaRepository greetingJpaRepository;

    @Test
    public void integrationTestGrpcGreetingService(){

        final var name = "Sergio";
        final var city = "Madrid";
        final var greetingRequest = GreetingRequest.newBuilder()
                .setName(name)
                .setCity(city)
                .build();

        final var greetingResponse = this.greetingService.greeting(greetingRequest);

        final var expected = String.format(pattern, name, city);
        Assert.assertEquals(expected, greetingResponse.getGreeting());

        final var greetingOp = this.greetingJpaRepository.findById((int)greetingResponse.getId());
        Assert.assertTrue(greetingOp.isPresent());
        Assert.assertEquals(expected, greetingOp.get().getMessage());

    }
}
