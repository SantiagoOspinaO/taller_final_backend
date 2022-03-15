package com.bingo.service;

import com.bingo.domain.ValueCard;

import java.util.List;

/**
 * Se crea la interface IValueCard.
 *
 * @version 1.00.000 2022-03-14
 *
 * @author Santiago Ospina Osorio - santiago.m200@outlook.es
 *
 * @since 1.00.000 2022-03-14
 */
public interface IValueCard {

    /**
     * List list.
     *
     * @return the list
     */
    public List<ValueCard> list();

    /**
     * Save value card.
     *
     * @param valueCard the value card
     * @return the value card
     */
    public ValueCard save(ValueCard valueCard);

    /**
     * Delete.
     *
     * @param valueCard the value card
     */
    public void delete(ValueCard valueCard);
}
