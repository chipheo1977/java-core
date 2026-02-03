package exception;

import constant.ErrorCode;

public class InvalidException extends AppException {
    public InvalidException() {
        super(ErrorCode.INVALID, "Invalid value");
    }
}
