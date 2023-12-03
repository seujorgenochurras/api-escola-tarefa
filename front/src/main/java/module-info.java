module io.github.seujorgenochurras.front {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;

    opens io.github.seujorgenochurras.front.controller to javafx.fxml;
    opens io.github.seujorgenochurras.front to javafx.fxml;
    exports io.github.seujorgenochurras.front;

}