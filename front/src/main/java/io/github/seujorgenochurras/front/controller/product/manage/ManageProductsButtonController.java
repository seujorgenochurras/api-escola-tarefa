package io.github.seujorgenochurras.front.controller.product.manage;

import io.github.seujorgenochurras.front.domain.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ManageProductsButtonController {

    @FXML
    private Button manageProductsButton;


    public void onManageProductsAction(){
        User.gotoMangeProductsPage();
    }
}
