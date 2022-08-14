package com.library.entespotify.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    @Autowired
    private final CustomErrorService customErrorService;

    public CustomErrorController(CustomErrorService customErrorService) {
        this.customErrorService = customErrorService;
    }

    @GetMapping("/error")
    public String handleError(HttpServletRequest request) {
        return customErrorService.handleError(request);
    }
}
