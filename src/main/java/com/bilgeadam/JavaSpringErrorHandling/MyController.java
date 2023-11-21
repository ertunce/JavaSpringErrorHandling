package com.bilgeadam.JavaSpringErrorHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.NotActiveException;

@RestController
public class MyController {

    @ExceptionHandler(NotActiveException.class)
    public ResponseEntity<String> handleYourCustomException(NotActiveException e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Controller Error: " + e.getMessage());
    }

    @GetMapping("/trigger-controller-error")
    public ResponseEntity<String> triggerControllerError() throws NotActiveException {
        throw new NotActiveException("This is a custom error");
    }

    @GetMapping("/trigger-global-error")
    public ResponseEntity<String> triggerGlobalError() throws NoSuchMethodException {
        throw new NoSuchMethodException("This is a custom error");
    }


}
