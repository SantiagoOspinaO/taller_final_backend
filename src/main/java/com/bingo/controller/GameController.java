package com.bingo.controller;

import com.bingo.domain.Game;
import com.bingo.service.GameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Se crea el Game Controller.
 *
 * @version 1.00.000 2022-03-14
 *
 * @author Santiago Ospina Osorio - santiago.m200@outlook.es
 *
 * @since 1.00.000 2022-03-14
 */
@Slf4j
@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    /**
     * Se crea el Get del index.
     *
     * @return dato de tipo Map con un String.
     *
     * @author Santiago Ospina Osorio - santiago.m200@outlook.es
     *
     * @since 1.00.000 2022-03-14
     */
    @GetMapping(path = "/")
    public Map<String, String> index() {
        var respuesta = new HashMap<String, String>();
        respuesta.put("message", "Hola Mundo");
        return respuesta;
    }

    /**
     * Se crea el Get del index.
     *
     * @return una lista con objetos de tipo Game.
     *
     * @author Santiago Ospina Osorio - santiago.m200@outlook.es
     *
     * @since 1.00.000 2022-03-14
     */
    @GetMapping(path = "/games")
    public List<Game> list() {
        var games = gameService.list();
        return games;
    }

}
