package at.fhv.se.smartmeter.application.exceptions;

public class OperationalPropertyNotFoundException extends Exception {
    public OperationalPropertyNotFoundException(String invalidPropname) {
        super("No operational property found for: " + invalidPropname);
    }
}
