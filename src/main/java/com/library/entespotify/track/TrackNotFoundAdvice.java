package com.library.entespotify.track;


import com.library.entespotify.track.TrackNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class TrackNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(TrackNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(TrackNotFoundException ex) {
        return ex.getMessage();
    }
}
