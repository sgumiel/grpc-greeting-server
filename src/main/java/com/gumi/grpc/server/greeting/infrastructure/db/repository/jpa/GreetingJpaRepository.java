package com.gumi.grpc.server.greeting.infrastructure.db.repository.jpa;

import com.gumi.grpc.server.greeting.infrastructure.db.model.GreetingEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingJpaRepository extends CrudRepository<GreetingEntity, Integer> {
}
