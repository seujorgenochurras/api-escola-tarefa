package io.github.seujorgenochurras.front.api;

public enum DefaultMappings {
    CLIENT_ACCOUNT_INFO("client/account"),

    LOGIN_CLIENT("login/client"),

    ORDER_PRODUCT("client/buy"),

    REGISTER_CLIENT("/register/client");



    private final String mapping;

    DefaultMappings(String mapping) {
        this.mapping = mapping;
    }

    public String getMapping() {
        return mapping;
    }
}
