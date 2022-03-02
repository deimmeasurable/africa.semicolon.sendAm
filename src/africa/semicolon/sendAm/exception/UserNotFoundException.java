package africa.semicolon.sendAm.exception;

public class UserNotFoundException extends SendAmAppException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
