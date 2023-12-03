package io.github.seujorgenochurras.front.util;

//A special boolean designed that if by some reason it is set to false, it will hold false for ever
public class ValidatorBoolean {
    private boolean isValid = true;

    public boolean isValid() {
        return isValid;
    }

    public ValidatorBoolean setValid(boolean valid) {
        if(!isValid) return this;
        this.isValid = valid;
        return this;
    }
}
