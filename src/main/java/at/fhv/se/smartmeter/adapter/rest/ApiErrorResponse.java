package at.fhv.se.smartmeter.adapter.rest;

public class ApiErrorResponse {

    private int code;
    private String message;

    public ApiErrorResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}

