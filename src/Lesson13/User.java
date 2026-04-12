package Lesson13;

public class User {
    private String login;
    private String password;
    private String confirmPassword;

    public static boolean checkUser (String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        try {
            if (login.length() >= 20 || login.contains(" ")) {
                throw new WrongLoginException("Неверный логин");
            }
            if (password.length() >= 20 || password.contains(" ") || !password.matches(".*\\d.*")) {
                throw new WrongPasswordException("Неверный пароль");
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароли не совпадают");
            }
            return true;
        } catch (RuntimeException runtimeExceptionE) {
            return false;
        }
    }
}
