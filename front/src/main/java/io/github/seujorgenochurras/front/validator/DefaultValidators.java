package io.github.seujorgenochurras.front.validator;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.scene.control.TextInputControl;

public class DefaultValidators {

    public static RequiredFieldValidator generateNotBlankValidator() {
        NotBlankFieldValidator requiredFieldValidator = new NotBlankFieldValidator();
        requiredFieldValidator.setMessage("Campo não pode estar em branco");
        return requiredFieldValidator;
    }

    //At this point I won't even bother
    public static final class NotBlankFieldValidator extends RequiredFieldValidator {

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
