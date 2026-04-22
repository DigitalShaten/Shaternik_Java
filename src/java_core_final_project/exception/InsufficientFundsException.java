package java_core_final_project.exception;

//недостаточно средств
public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
