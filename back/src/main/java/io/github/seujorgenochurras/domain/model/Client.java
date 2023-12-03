package io.github.seujorgenochurras.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    private String name;
    @NotNull
    @Embedded
    private Address address;
    @NotNull
    private int age;
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;


    public String getId() {
        return id;
    }

    public Client setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Client setName(String name) {
        this.name = name;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Client setAddress(Address address) {
        this.address = address;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Client setAge(int age) {
        this.age = age;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public Client setGender(Gender gender) {
        this.gender = gender;
        return this;
    }
}
