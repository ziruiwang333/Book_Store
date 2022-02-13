package com.bookstore.service;

import com.bookstore.pojo.Book;
import com.bookstore.pojo.Page;

import java.util.List;

public interface BookService {
    public abstract void addBook(Book book);

    public abstract void deleteBookById(Integer id);

    public abstract void updateBook(Book book);

    public abstract Book queryBookById(Integer id);

    public abstract List<Book> queryBooks();

    public abstract Page<Book> page(int pageNo, int pageSize);

    public abstract Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
