package java_core_final_project.exception;

//недостаточно средств
public class InvalidAmountException extends RuntimeException {
    public InvalidAmountException(String message) {
        super(message);
    }
}
