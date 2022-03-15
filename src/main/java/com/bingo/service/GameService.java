package com.bingo.service;

import com.bingo.dao.GameDao;
import com.bingo.domain.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Se crea el servicio GameService que implementa IGameService.
 *
 * @version 1.00.000 2022-03-14
 *
 * @author Santiago Ospina Osorio - santiago.m200@outlook.es
 *
 * @since 1.00.000 2022-03-14
 */
@Service
public class GameService implements IGameService {

    @Autowired
    private GameDao gameDao;

    @Override
    @Transactional(readOnly = true)
    public List<Game> list() {
        List<Game> games;
        try {
            games = (List<Game>) gameDao.findAll();
        } catch (Exception exc) {
            throw exc;
        }
        return games;
    }

    @Override
    public Game save(Game game) {
        return gameDao.save(game);
    }

    @Override
    public void delete(Game game) {
        gameDao.delete(game);
    }

    @Override
    public Optional<Game> findGame(Game game) {
        return gameDao.findById(game.getId());
    }

}
