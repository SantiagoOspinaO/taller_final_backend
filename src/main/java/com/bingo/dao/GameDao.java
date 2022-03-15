package com.bingo.dao;

import com.bingo.domain.Game;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Se crea la interface GameDao que extiende de CrudRepository.
 *
 * @version 1.00.000 2022-03-14
 *
 * @author Santiago Ospina Osorio - santiago.m200@outlook.es
 *
 * @since 1.00.000 2022-03-14
 */
public interface GameDao extends CrudRepository<Game, Long> {

    /**
     * Update name.
     *
     * @param id   the id
     * @param name the name
     *
     * @author Santiago Ospina Osorio - santiago.m200@outlook.es
     *
     * @since 1.00.000 2022-03-14
     */
    @Modifying
    @Query("update Game gam set gam.name = :name where gam.id = :id")
    public void updateName (
            @Param(value = "id") Long id,
            @Param(value = "name") String name
    );
}
