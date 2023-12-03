module io.github.seujorgenochurras.front {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.net.http;
    requires java.logging;
    requires com.google.gson;

    opens io.github.seujorgenochurras.front.controller to javafx.fxml;

    opens io.github.seujorgenochurras.front to javafx.fxml;
    exports io.github.seujorgenochurras.front;

}