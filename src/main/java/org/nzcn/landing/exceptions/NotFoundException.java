package org.nzcn.landing.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Created by kinlin on 8/27/16.
 */
public class NotFoundException extends RestException {
    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(), message);
    }
}
