package com.gumi.grpc.server.greeting.common;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringBootTest
@SpringJUnitConfig(classes = { GrpcServerMockITConfig.class })
@ContextConfiguration(initializers = { DefaultPostgresContainer.Initializer.class })
@ActiveProfiles("it")
public class CommonIT {
}
