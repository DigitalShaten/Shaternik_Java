package java_core_final_project.exception;

//невалидная сумма
public class InvalidAmountException extends RuntimeException {
    public InvalidAmountException(String message) {
        super(message);
    }
}
