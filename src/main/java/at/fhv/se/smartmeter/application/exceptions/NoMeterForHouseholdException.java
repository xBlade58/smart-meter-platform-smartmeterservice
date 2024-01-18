package at.fhv.se.smartmeter.application.exceptions;

public class NoMeterForHouseholdException extends Exception {
    public NoMeterForHouseholdException(String householdId) {
        super("No meter found for household with id = " + householdId);
    }
}
