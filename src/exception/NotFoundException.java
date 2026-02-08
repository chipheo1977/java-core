package exception;

import constant.ErrorCode;

public class NotFoundException extends AppException{
    public NotFoundException(String field) {
        super(ErrorCode.NOT_FOUND, field + " not found!");
    }
}
