package entity.exeption;

import constant.ErrorCode;

public class EmptyException extends AppException {

    public EmptyException(String field) {
        super(ErrorCode.EMPTY_VALUE, field + " must not be empty");
    }
}
