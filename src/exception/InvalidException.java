package exception;

import constant.ErrorCode;

public class InvalidException extends AppException {
    public InvalidException(String field) {
        super(ErrorCode.INVALID, field + " enter invalid type");
    }
}
