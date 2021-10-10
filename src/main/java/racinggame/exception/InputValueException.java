package racinggame.exception;

import racinggame.commons.Constant;

public class InputValueException extends RuntimeException {
    public InputValueException(String msg) {
        super(msg);
    }

    @Override
    public String getMessage() {
        return String.format(Constant.ERROR_PRINT_FORMAT, super.getMessage());
    }
}
