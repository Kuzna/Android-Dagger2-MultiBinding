package cz.kuzna.core.rest;

/**
 * @author Radek Kuznik
 */

public class RestException extends RuntimeException {

    private int errorCode;

    public RestException(final String message) {
        super(message);
    }

    public RestException(final String message, final int errorCode) {
        this(message,  errorCode, null);
    }

    public RestException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public RestException(final String message, final int errorCode, final Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}