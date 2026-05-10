package java_core_final_project.exception;

//не найден аккаунт
public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String message) {
        super(message);
    }
}
