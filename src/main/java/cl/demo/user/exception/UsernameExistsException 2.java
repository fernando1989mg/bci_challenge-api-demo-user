package cl.demo.user.exception;

public class UsernameExistsException extends RuntimeException {
    public UsernameExistsException(String msg) {
        super(msg);
    }
}
