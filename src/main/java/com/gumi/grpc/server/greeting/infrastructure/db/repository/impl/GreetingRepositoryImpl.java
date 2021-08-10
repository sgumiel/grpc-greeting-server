package com.gumi.grpc.server.greeting.infrastructure.db.repository.impl;

import com.gumi.grpc.server.greeting.infrastructure.db.map.GreetingDbMapper;
import com.gumi.grpc.server.greeting.infrastructure.db.repository.jpa.GreetingJpaRepository;
import com.gumi.grpc.server.greeting.model.Greeting;
import com.gumi.grpc.server.greeting.model.repository.GreetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GreetingRepositoryImpl implements GreetingRepository {

    private final GreetingJpaRepository greetingJpaRepository;
    private final GreetingDbMapper greetingDbMapper;

    @Override
    public Greeting save(Greeting greeting) {

        final var greetingEntity = this.greetingDbMapper.toEntity(greeting);
        final var greetingEntitySaved = this.greetingJpaRepository.save(greetingEntity);
        final var greetingSaved = this.greetingDbMapper.toDomain(greetingEntitySaved);
        return greetingSaved;
    }
}
