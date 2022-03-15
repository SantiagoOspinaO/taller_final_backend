package com.bingo.service;

import com.bingo.dao.UserDao;
import com.bingo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Se crea el servicio UserService que implementa IUserService.
 *
 * @version 1.00.000 2022-03-14
 *
 * @author Santiago Ospina Osorio - santiago.m200@outlook.es
 *
 * @since 1.00.000 2022-03-14
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public List<User> list() {
        List<User> users = null;
        try {
            users = (List<User>) userDao.findAll();
        } catch (Exception exc) {
            throw exc;
        }
        return users;
    }

    @Override
    @Transactional
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    @Transactional
    public User update(Long id, User user) {
        user.setId(id);
        return userDao.save(user);
    }

    /**
     * Update username.
     *
     * @param id   the id
     * @param user the user
     *
     * @author Santiago Ospina Osorio - santiago.m200@outlook.es
     *
     * @since 1.00.000 2022-03-14
     */
    @Transactional
    public void updateUsername(Long id, User user) {
        userDao.updateUsername(id, user.getUsername());
    }

    @Override
    @Transactional
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findUser(User user) {
        return userDao.findById(user.getId());
    }

}
