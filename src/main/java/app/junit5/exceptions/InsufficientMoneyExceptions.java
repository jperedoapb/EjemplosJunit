package app.junit5.exceptions;

public class InsufficientMoneyExceptions extends RuntimeException {
    public InsufficientMoneyExceptions(String message){
        super(message);
    }
}
