package com.leven.queries;

import com.leven.domain.model.Author;
import com.leven.domain.model.Book;
import java.math.BigInteger;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import com.leven.util.HibernateUtil;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 1:42 2018/8/16
 * @Modified By:
 */
public class QueryServiceImpl implements IqueryService {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public Author getAuthorByUserName(String username) {
        Author author = null;
        try (Session session = sessionFactory.openSession()) {
            SQLQuery sqlQuery = session
                .createSQLQuery("SELECT a.username as \"username\", a.name as \"name\", a.email as \"email\""
                    + "FROM Author a where a.username=:username");
            Query query = sqlQuery.setParameter("username", username);
            author = (Author) query.uniqueResult();
        }
        if (author == null) {
            HibernateUtil.getSessionFactory().close();
            throw new NullPointerException("Author" + username + " doesn't exist");
        }
        return author;
    }

    @Override
    public Book getBook(String title) {
        Book book = null;
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery(title);
            query.setParameter("title", title);
            book = (Book) query.uniqueResult();
        }

        return book;
    }

    @Override
    public List<Book> getAuthorBooks(String userName) {
        List<Book> bookList = null;
        try (Session session = sessionFactory.openSession()) {
            SQLQuery sqlQuery = session
                .createSQLQuery("SELECT b.title as \"title\",b.price as \"price\""
                    + " FROM Author a, Book b where b.author_id = a.id and a.username=:username");
            bookList = sqlQuery.setResultTransformer(Transformers.aliasToBean(Book.class)).list();
        }
        return bookList;
    }

    @Override
    public BigInteger getAuthorBooksCount(String username) {
        BigInteger bookAccount = null;
        try (Session session = sessionFactory.openSession()) {
            Query query = session
                .createSQLQuery("SELECT count(b.title)" + " FROM  Book b, Author a where b.author_id = a.id and a.username=:username");

            query.setParameter("username", username);
            bookAccount = (BigInteger) query.uniqueResult();
        }
        return bookAccount;
    }

    @Override
    public BigInteger getAuthorsCount() {
        BigInteger authorcount = null;
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createSQLQuery(
                "select count(author) from author"
            );
            authorcount = (BigInteger) query.uniqueResult();
        }
        return authorcount;
    }
}
