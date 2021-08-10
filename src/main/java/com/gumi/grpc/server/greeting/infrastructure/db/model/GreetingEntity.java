package com.gumi.grpc.server.greeting.infrastructure.db.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "saludo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GreetingEntity implements Serializable {

    private static final long serialVersionUID = 4484933337745465675L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ciudad")
    private String city;

    @Column(name = "nombre")
    private String name;

    @Column(name = "mensaje")
    private String message;
}
