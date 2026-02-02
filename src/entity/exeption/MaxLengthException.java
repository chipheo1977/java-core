package entity.exeption;
import constant.ErrorCode;

public class MaxLengthException extends AppException {

    public MaxLengthException(String field, int max) {
        super(ErrorCode.MAX_LENGTH, field + " must be <= " + max + " characters!");
    }
}
