package org.nzcn.landing.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Created by kinlin on 8/27/16.
 */
public class RestException extends RuntimeException {

    HttpStatus status;
    Integer errorCode;
    String message;

    public RestException(HttpStatus status, Integer errorCode, String message) {
        this.status = status;
        this.errorCode = errorCode;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
