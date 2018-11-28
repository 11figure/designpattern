package com.leven.command;

import com.leven.util.HibernateUtil;
import org.hibernate.SessionFactory;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 1:33 2018/8/16
 * @Modified By:
 */
public class CommandServiceImpl implements ICommandService {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void authorCreated(String username, String name, String email) {

    }

    @Override
    public void bookAddedToAuthor(String title, double price, String username) {

    }

    @Override
    public void authorNameUpdated(String username, String name) {

    }

    @Override
    public void authorUsernameUpdated(String oldUsername, String newUsername) {

    }

    @Override
    public void authorEmailUpdated(String username, String email) {

    }

    @Override
    public void bookTitleUpdated(String oldTitle, String newTitle) {

    }

    @Override
    public void bookPriceUpdated(String title, double price) {

    }
}
