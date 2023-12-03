package io.github.seujorgenochurras.front.validator;

import com.jfoenix.controls.IFXTextInputControl;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.beans.Observable;
import javafx.scene.control.TextInputControl;

import java.util.Observer;
import java.util.function.Consumer;

public class DefaultValidators {

    public static RequiredFieldValidator generateNotBlankValidator() {
        NotBlankFieldValidator requiredFieldValidator = new NotBlankFieldValidator();
        requiredFieldValidator.setMessage("Campo não pode estar em branco");
        return requiredFieldValidator;
    }

    public static RequiredFieldValidator generateStringToBeEqualsValidator(JFXPasswordField stringConsumer) {
        StringEqualToValidator requiredFieldValidator = new StringEqualToValidator(stringConsumer);
        requiredFieldValidator.setMessage("Campo inválido");
        return requiredFieldValidator;
    }

    private static final class StringEqualToValidator extends RequiredFieldValidator{
        private final JFXPasswordField strToBeEquals;
        public StringEqualToValidator(JFXPasswordField strToBeEquals) {
            this.strToBeEquals = strToBeEquals;
        }


        @Override
        protected void eval() {
            if (srcControl.get() instanceof IFXTextInputControl) {
                evalTextInputField();
            }
        }
        private void evalTextInputField() {
            TextInputControl textField = (TextInputControl) srcControl.get();

            hasErrors.set(!textField.getText().equals(strToBeEquals.getText()));
        }

    }

    //At this point I won't even bother
    private static final class NotBlankFieldValidator extends RequiredFieldValidator {

        @Override
        protected void eval() {
            if (srcControl.get() instanceof TextInputControl) {
                evalTextInputField();
            }
            if (srcControl.get() instanceof JFXComboBox<?>) {
                evalComboBoxField();
            }
        }
        private void evalTextInputField() {
            TextInputControl textField = (TextInputControl) srcControl.get();
            hasErrors.set(textField.getText() == null || textField.getText().isBlank());
        }

        private void evalComboBoxField() {
            JFXComboBox<?> comboField = (JFXComboBox<?>) srcControl.get();
            boolean hasValue = comboField.getValue() != null;
            boolean editorHasNonEmptyText = comboField.isEditable() && comboField.getEditor()
                    .getText() != null && !comboField.getEditor()
                    .getText()
                    .isBlank();
            hasErrors.set(!hasValue && !editorHasNonEmptyText);
        }
    }
}
