package com.bingo.dao;

import com.bingo.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Se crea la interface UserDao que extiende de CrudRepository.
 *
 * @version 1.00.000 2022-03-14
 *
 * @author Santiago Ospina Osorio - santiago.m200@outlook.es
 *
 * @since 1.00.000 2022-03-14
 */
public interface UserDao extends CrudRepository<User, Long> {

    /**
     * Update username.
     *
     * @param id   the id
     * @param name the name
     *
     * @author Santiago Ospina Osorio - santiago.m200@outlook.es
     *
     * @since 1.00.000 2022-03-14
     */
    @Modifying
    @Query("update User use set use.username = :username where use.id = :id")
    public void updateUsername(
            @Param(value = "id") Long id,
            @Param(value = "username") String name
    );

}
