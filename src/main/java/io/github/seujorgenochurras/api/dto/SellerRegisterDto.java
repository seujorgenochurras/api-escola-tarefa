package io.github.seujorgenochurras.api.dto;

import io.github.seujorgenochurras.domain.model.Address;
import jakarta.validation.constraints.NotNull;

public class SellerRegisterDto {
    @NotNull
    private String name;

    @NotNull
    private Address address;
}
