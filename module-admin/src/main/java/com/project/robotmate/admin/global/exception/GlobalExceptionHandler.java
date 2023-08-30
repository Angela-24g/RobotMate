package com.project.robotmate.admin.global.exception;

import com.project.robotmate.admin.global.dto.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static com.project.robotmate.admin.global.util.CommonUtil.isAjax;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public Object illegalArgumentException(Exception ex, HttpServletRequest request){
        if (isAjax(request)) {
            return getErrorResponseEntity(ex, HttpStatus.BAD_REQUEST);
        }
        return getModelAndView("error/400");
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Object AuthenticationException(Exception ex , HttpServletRequest request){
        if (isAjax(request)) {
            return getErrorResponseEntity(ex, HttpStatus.UNAUTHORIZED);
        }
        return getModelAndView("login");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Object basicException(Exception ex, HttpServletRequest request){
        if (isAjax(request)) {
            return getErrorResponseEntity(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return getModelAndView("error/500");
    }

    private static ResponseEntity<ErrorResponse> getErrorResponseEntity(Exception ex, HttpStatus status) {
        ErrorResponse response = ErrorResponse.error(status.value(), ex.getMessage());
        return new ResponseEntity<>(response, status);
    }


    private static ModelAndView getModelAndView(String viewName) {
        ModelAndView model = new ModelAndView();
        model.setViewName(viewName);
        return model;
    }
}
