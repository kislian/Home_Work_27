package sky.pro.Employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
//раставляем статус
//выбрасывается когда пользователь пытается добавить существующего сотрудника
@ResponseStatus(HttpStatus.BAD_REQUEST)

//расширяем класс RuntimeException так мы не хотим делать проверяемое исключение
public class EmployeeAllreadyAddException extends RuntimeException{
    public EmployeeAllreadyAddException() {
    }

    public EmployeeAllreadyAddException(String message) {
        super(message);
    }

    public EmployeeAllreadyAddException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeAllreadyAddException(Throwable cause) {
        super(cause);
    }

    public EmployeeAllreadyAddException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
