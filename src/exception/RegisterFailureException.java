package exception;

public class RegisterFailureException extends SendAmAppException {
    public RegisterFailureException(String  message) {
        super(message);
    }
}
