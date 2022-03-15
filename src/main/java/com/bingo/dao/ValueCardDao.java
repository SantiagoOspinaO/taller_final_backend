package com.bingo.dao;

import com.bingo.domain.User;
import com.bingo.domain.ValueCard;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Se crea la interface ValueCardDao que extiende de CrudRepository.
 *
 * @version 1.00.000 2022-03-14
 *
 * @author Santiago Ospina Osorio - santiago.m200@outlook.es
 *
 * @since 1.00.000 2022-03-14
 */
public interface ValueCardDao extends CrudRepository<User, Long> {

    /**
     * Save.
     *
     * @param id    the id
     * @param value the value
     *
     * @author Santiago Ospina Osorio - santiago.m200@outlook.es
     *
     * @since 1.00.000 2022-03-14
     */
    @Modifying
    @Query("update ValueCard valcar set valcar.value = :value where valcar.id = :id")
    public void save(
            @Param(value = "id") Long id,
            @Param(value = "value") String value
    );

    /**
     * Delete.
     *
     * @param valueCard the value card
     *
     * @author Santiago Ospina Osorio - santiago.m200@outlook.es
     *
     * @since 1.00.000 2022-03-14
     */
    void delete(ValueCard valueCard);
}
