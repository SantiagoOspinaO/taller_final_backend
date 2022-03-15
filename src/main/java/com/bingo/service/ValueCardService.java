package com.bingo.service;

import com.bingo.dao.ValueCardDao;
import com.bingo.domain.ValueCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Se crea el servicio ValueCardService que implementa IValueCard.
 *
 * @version 1.00.000 2022-03-14
 *
 * @author Santiago Ospina Osorio - santiago.m200@outlook.es
 *
 * @since 1.00.000 2022-03-14
 */
@Service
public class ValueCardService implements IValueCard {

    @Autowired
    private ValueCardDao valueCardDao;

    @Override
    public List<ValueCard> list() {
        return null;
    }

    @Override
    @Transactional
    public ValueCard save(ValueCard valueCard) {
        return null;
    }

    @Override
    public void delete(ValueCard valueCard) {
        valueCardDao.delete(valueCard);
    }

}
