package com.gumi.grpc.server.greeting.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Greeting implements Serializable {

    private static final long serialVersionUID = -3221116002773356984L;

    private Integer id;
    private String name;
    private String city;
    private String message;
}
