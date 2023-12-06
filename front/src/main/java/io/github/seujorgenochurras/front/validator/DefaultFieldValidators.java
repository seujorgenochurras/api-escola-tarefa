package io.github.seujorgenochurras.front.validator;

import com.jfoenix.controls.IFXTextInputControl;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.scene.control.TextInputControl;

public class DefaultFieldValidators {

    public static RequiredFieldValidator generateNotBlankValidator() {
        NotBlankFieldValidator requiredFieldValidator = new NotBlankFieldValidator();
        requiredFieldValidator.setMessage("Campo não pode estar em branco");
        return requiredFieldValidator;
    }

    public static RequiredFieldValidator generateStringToBeEqualsValidator(JFXPasswordField passwordField) {
        StringEqualToValidator requiredFieldValidator = new StringEqualToValidator(passwordField);
        requiredFieldValidator.setMessage("Campo inválido");
        return requiredFieldValidator;
    }

    public static RequiredFieldValidator generateEmailValidator() {
        EmailValidator emailValidator = new EmailValidator();
        emailValidator.setMessage("E-mail inválido");
        return emailValidator;
    }

    public static CpfFieldValidator generateCpfValidator() {
        CpfFieldValidator cpfValidator = new CpfFieldValidator();
        cpfValidator.setMessage("CPF inválido");
        return cpfValidator;
    }

    public static NumberValidator generateNumberValidator() {
        NumberValidator numberValidator = new NumberValidator();
        numberValidator.setMessage("Tem que ser um número");
        return numberValidator;
    }

    private static final class CpfFieldValidator extends RequiredFieldValidator {
        @Override
        protected void eval() {
            if (srcControl.get() instanceof IFXTextInputControl) {
                evalTextInputField();
            }
        }

        private void evalTextInputField() {
            TextInputControl textField = (TextInputControl) srcControl.get();
            hasErrors.set(!CpfValidator.isValid(textField.getText()));
        }
    }

    private static final class EmailValidator extends RequiredFieldValidator {
        @Override
        protected void eval() {
            if (srcControl.get() instanceof IFXTextInputControl) {
                evalTextInputField();
            }
        }

        private void evalTextInputField() {
            TextInputControl textField = (TextInputControl) srcControl.get();
            hasErrors.set(!textField.getText().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"));
        }
    }

    private static final class StringEqualToValidator extends RequiredFieldValidator {
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
            boolean editorHasNonEmptyText = comboField.isEditable() && comboField.getEditor().getText() != null && !comboField.getEditor().getText().isBlank();
            hasErrors.set(!hasValue && !editorHasNonEmptyText);
        }
    }
}
