package com.leven.queries;

import com.leven.domain.model.Author;
import com.leven.domain.model.Book;
import java.math.BigInteger;
import java.util.List;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 1:29 2018/8/16
 * @Modified By:
 */
public interface IqueryService {

    Author getAuthorByUserName(String userName);

    Book getBook(String title);

    List<Book> getAuthorBooks(String userName);

    BigInteger getAuthorBooksCount(String username);

    BigInteger getAuthorsCount();

}
