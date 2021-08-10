package com.gumi.grpc.server.greeting.model.repository;

import com.gumi.grpc.server.greeting.model.Greeting;

public interface GreetingRepository {

    Greeting save(Greeting greeting);
}
