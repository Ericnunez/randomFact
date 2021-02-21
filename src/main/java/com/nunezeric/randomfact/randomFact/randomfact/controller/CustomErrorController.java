package com.nunezeric.randomfact.randomFact.randomfact.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Eric Nunez
 */
@Controller
@RequestMapping("/error")
public class CustomErrorController implements ErrorController {

    @RequestMapping(method = RequestMethod.GET,produces = "text/html")
    public String handleError(HttpServletRequest request){
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if(status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            if(statusCode == HttpStatus.NOT_FOUND.value())
                return "error";
        }
        return "error";
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
