package io.github.seujorgenochurras.front.config;

public enum Scenes {
    LOGIN("login-page.fxml"),

    FORGOT_PASSWORD("forgo-password-page.fxml"),

    REGISTER("register.fxml"),

    MANAGE_PRODUCT("manage-products.fxml"),

    REGISTER_INFO("register-info.fxml"),

    REGISTER_ENDERECO("register-endereco.fxml"),

    PRODUCT_PAGE("product-page.fxml");


    public final String sceneSource;

    Scenes(String sceneSource) {
        this.sceneSource = sceneSource;
    }
}
