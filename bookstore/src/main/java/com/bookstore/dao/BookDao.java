package com.bookstore.dao;

import com.bookstore.pojo.Book;

import java.util.List;

public interface BookDao {

    public abstract int addBook(Book book);

    public abstract int deleteById(Integer id);

    public abstract int updateBook(Book book);

    public abstract Book queryBookById(Integer id);

    public abstract List<Book> queryBooks();

    public abstract Integer queryForTotalItemCount();

    public abstract List<Book> queryForCurrentPageItems(Integer begin, Integer pageSize);

    public abstract  Integer queryForTotalItemCountByPrice(int min, int max);

    public abstract List<Book> queryForCurrentPageItems(Integer begin, Integer pageSize, int min, int max);
}
