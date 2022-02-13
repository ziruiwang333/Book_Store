package com.bookstore.test;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.impl.BookDaoImpl;
import com.bookstore.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookDaoTest {

    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "测试书", "cs", new BigDecimal(100), 100, 0, null));
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21, "测试书", "xiugai", new BigDecimal(100), 100, 0, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(20));
    }

    @Test
    public void queryBooks() {
        for(Book book: bookDao.queryBooks()){
            System.out.println(book);
        }
    }

    @Test
    public void deleteById() {
        bookDao.deleteById(21);
    }

    @Test
    public void queryForTotalItemCount(){
        System.out.println(bookDao.queryForTotalItemCount());
    }

    @Test
    public void queryForCurrentPageItems(){
        System.out.println(bookDao.queryForCurrentPageItems(4, 10));
    }

}