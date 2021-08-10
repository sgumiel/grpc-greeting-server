package com.gumi.grpc.server.greeting.infrastructure.db.map;

import com.gumi.grpc.server.greeting.infrastructure.db.model.GreetingEntity;
import com.gumi.grpc.server.greeting.model.Greeting;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GreetingDbMapper {

    GreetingEntity toEntity(Greeting source);
    Greeting toDomain(GreetingEntity source);

}
