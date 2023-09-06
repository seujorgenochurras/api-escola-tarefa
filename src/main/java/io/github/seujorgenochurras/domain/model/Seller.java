package io.github.seujorgenochurras.domain.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

public class Seller {
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
    private Gender gender;

    public String getId() {
        return id;
    }

    public Seller setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Seller setName(String name) {
        this.name = name;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Seller setAddress(Address address) {
        this.address = address;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Seller setAge(int age) {
        this.age = age;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public Seller setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
