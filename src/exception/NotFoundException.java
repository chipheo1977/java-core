package exception;

import constant.ErrorCode;

public class NotFoundException extends AppException{
    public NotFoundException() {
        super(ErrorCode.NOT_FOUND, "System not found!");
    }
}
