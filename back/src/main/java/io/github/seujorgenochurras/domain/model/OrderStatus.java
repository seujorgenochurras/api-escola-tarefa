package io.github.seujorgenochurras.domain.model;

public enum OrderStatus {
    ARRIVED("Entregue"),
    PENDING("A caminho"),
    CANCELED("Cancelado");

    public final String statusName;

    OrderStatus(String statusName) {
        this.statusName = statusName;
    }

}
