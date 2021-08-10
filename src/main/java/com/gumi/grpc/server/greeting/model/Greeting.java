package com.gumi.grpc.server.greeting.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Greeting implements Serializable {

    private static final long serialVersionUID = -3221116002773356984L;

    private Integer id;
    private String name;
    private String city;
    private String message;
}
