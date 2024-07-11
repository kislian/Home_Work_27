package sky.pro.Employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//расширяем класс RuntimeException так мы не хотим делать проверяемое исключение
//404  не найден
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNoFoundException extends RuntimeException{
    public EmployeeNoFoundException() {
    }

    public EmployeeNoFoundException(String message) {
        super(message);
    }

    public EmployeeNoFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeNoFoundException(Throwable cause) {
        super(cause);
    }

    public EmployeeNoFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
