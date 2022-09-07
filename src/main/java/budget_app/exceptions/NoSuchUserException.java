package budget_app.exceptions;

public class NoSuchUserException extends Exception{

    public NoSuchUserException(String message) {
        super(message);
    }

    public NoSuchUserException() {

    }
}
