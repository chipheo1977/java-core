package exception;

import constant.ErrorCode;

public class MaxNumberException extends AppException {
    public MaxNumberException(String field, int max) {
        super(ErrorCode.MAX_NUMBER_EXCEEDED, field + " must be <= " + max);
    }
}
