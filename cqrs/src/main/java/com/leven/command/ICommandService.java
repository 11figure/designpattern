package com.leven.command;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 1:32 2018/8/16
 * @Modified By:
 */
public interface ICommandService {
    void authorCreated(String username, String name, String email);

    void bookAddedToAuthor(String title, double price, String username);

    void authorNameUpdated(String username, String name);

    void authorUsernameUpdated(String oldUsername, String newUsername);

    void authorEmailUpdated(String username, String email);

    void bookTitleUpdated(String oldTitle, String newTitle);

    void bookPriceUpdated(String title, double price);

}
