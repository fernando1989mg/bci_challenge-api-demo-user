package cl.demo.user.domain.exception;

public class RegisterException extends RuntimeException {
    public RegisterException(String msg) {
        super(msg);
    }
}
