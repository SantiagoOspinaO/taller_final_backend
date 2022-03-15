package com.bingo.service;

import com.bingo.domain.Game;

import java.util.List;
import java.util.Optional;

/**
 * Se crea la interface IGameService.
 *
 * @version 1.00.000 2022-03-14
 *
 * @author Santiago Ospina Osorio - santiago.m200@outlook.es
 *
 * @since 1.00.000 2022-03-14
 */
public interface IGameService {

    /**
     * List list.
     *
     * @return the list
     */
    public List<Game> list();

    /**
     * Save game.
     *
     * @param game the game
     * @return the game
     */
    public Game save(Game game);

    /**
     * Delete.
     *
     * @param game the game
     */
    public void delete(Game game);

    /**
     * Find game optional.
     *
     * @param game the game
     * @return the optional
     */
    public Optional<Game> findGame(Game game);
}
