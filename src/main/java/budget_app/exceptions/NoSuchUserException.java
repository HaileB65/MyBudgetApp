package budget_app.exceptions;

public class NoSuchUserException extends RuntimeException{

    public NoSuchUserException(String message) {
        super(message);
    }

    public NoSuchUserException() {

    }
}
