package com.bingo.controller;

import com.bingo.domain.User;
import com.bingo.service.UserService;
import com.bingo.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Se crea el User Controller.
 *
 * @version 1.00.000 2022-03-14
 *
 * @author Santiago Ospina Osorio - santiago.m200@outlook.es
 *
 * @since 1.00.000 2022-03-14
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private Response response;

    /**
     * Se crea el Get de los users.
     *
     * @return una lista con objetos de tipo User.
     *
     * @author Santiago Ospina Osorio - santiago.m200@outlook.es
     *
     * @since 1.00.000 2022-03-14
     */
    @GetMapping(path = "/users")
    public List<User> list() {
        var users = userService.list();
        return users;
    }

    /**
     * Se crea el Create del user.
     *
     * @param user the user
     * @return the response entity
     *
     * @author Santiago Ospina Osorio - santiago.m200@outlook.es
     *
     * @since 1.00.000 2022-03-14
     */
    @PostMapping(path = "/user")
    public ResponseEntity<Response> create(User user) {
        response.data = user;
        try {
            log.info("Usuario a crear: {}", user);
            userService.save(user);
            return new ResponseEntity<Response>(response, HttpStatus.CREATED);
        } catch (Exception exc) {
            response.status = exc.getCause().toString();
            response.error = true;
            return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Se crea el Delete de un user por medio de su id.
     *
     * @param user the user
     * @return the response entity
     *
     * @author Santiago Ospina Osorio - santiago.m200@outlook.es
     *
     * @since 1.00.000 2022-03-14
     */
    @DeleteMapping(path = "/user/{id}")
    public ResponseEntity<User> delete(User user) {
        log.info("Contacto a borrar: {}", user);
        userService.delete(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * Se crea el Update del user por medio de su id.
     *
     * @param user the user
     * @param id   the id
     * @return the response entity
     *
     * @author Santiago Ospina Osorio - santiago.m200@outlook.es
     *
     * @since 1.00.000 2022-03-14
     */
    @PutMapping(path = "/user/{id}")
    public ResponseEntity<User> update(User user, @PathVariable("id") Long id) {
        log.info("Usuario a modificar: {}", user);
        userService.update(id, user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * Se crea el Update Usermame del user por medio de su id.
     *
     * @param user the user
     * @param id   the id
     * @return the response entity
     *
     * @author Santiago Ospina Osorio - santiago.m200@outlook.es
     *
     * @since 1.00.000 2022-03-14
     */
    @PatchMapping(path = "/user/username/{id}")
    public ResponseEntity<User> updateUsermame(User user, @PathVariable("id") Long id) {
        log.info("Usuario a modificar nombre: {}", user);
        userService.updateUsername(id, user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
