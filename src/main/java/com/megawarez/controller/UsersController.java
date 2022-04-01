package com.megawarez.controller;

import com.megawarez.service.UserService;
import com.megawarez.util.LoginData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.megawarez.util.Response;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;


@Slf4j
@RestController

public class UsersController {

    private UserService userService;

    private Response response = new Response();

    private HttpStatus httpStatus = HttpStatus.OK;

    @GetMapping(path = "/")
    public ResponseEntity<Response> homeIndex1(HttpServletResponse httpResponse) {
        return getResponseHome(httpResponse);
    }

    private ResponseEntity<Response> getResponseHome(HttpServletResponse httpResponse) {
        return getResponseHome(httpResponse);
    }

    @PostMapping(path = "/api/v1/login")
    public ResponseEntity<Response> login(@RequestBody LoginData loginData) {
        response.restart();
        try {
            response.message = "Todo OK";
            response.data = loginData.getToken();
            httpStatus = HttpStatus.OK;
            // realizo consulta para saber si el usuario y contraseña coinciden
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity(response, httpStatus);
    }

    @GetMapping(path = "/api/v1/ejemplo-token")
    public ResponseEntity<Response> getToken(@RequestHeader("Authorization") String authorization) {
        response.restart();
        try {
            response.message = "Todo OK - TOKEN";
            response.data = authorization.replace("Bearer ", "");
            httpStatus = HttpStatus.OK;
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity(response, httpStatus);
    }


}
