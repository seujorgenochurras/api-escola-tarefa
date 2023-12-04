module io.github.seujorgenochurras.front {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.net.http;
    requires java.logging;
    requires com.google.gson;

    opens io.github.seujorgenochurras.front to javafx.fxml, com.google.gson;
    opens io.github.seujorgenochurras.front.api.dto to javafx.fxml, com.google.gson;
    exports io.github.seujorgenochurras.front;
    opens io.github.seujorgenochurras.front.controller.register to javafx.fxml, com.jfoenix;
    opens io.github.seujorgenochurras.front.controller.login to javafx.fxml;
    opens io.github.seujorgenochurras.front.controller.product to javafx.fxml;
    opens io.github.seujorgenochurras.front.controller.product.manage to javafx.fxml;

}