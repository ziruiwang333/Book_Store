package com.bookstore.service.impl;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.impl.BookDaoImpl;
import com.bookstore.pojo.Book;
import com.bookstore.pojo.Page;
import com.bookstore.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();

        Integer totalItemCount = bookDao.queryForTotalItemCount();
        page.setTotalItemCount(totalItemCount);

        Integer pageTotal = totalItemCount%pageSize>0?(totalItemCount/pageSize)+1:(totalItemCount/pageSize);
        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo<1?1:(pageNo>pageTotal?pageTotal:pageNo));
        page.setPageSize(pageSize);

        List<Book> items = bookDao.queryForCurrentPageItems((page.getPageNo()-1)*page.getPageSize(),page.getPageSize());
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();

        page.setPageSize(pageSize);
        page.setTotalItemCount(bookDao.queryForTotalItemCountByPrice(min, max));
        page.setPageTotal(page.getTotalItemCount()%page.getPageSize()>0?page.getTotalItemCount()/page.getPageSize()+1:page.getTotalItemCount()/page.getPageSize());

        page.setPageNo(pageNo<1?1:(pageNo>page.getPageTotal()?page.getPageTotal():pageNo));

        List<Book> list = bookDao.queryForCurrentPageItems((page.getPageNo()-1)*page.getPageSize(), page.getPageSize(), min, max);
        page.setItems(list);

        return page;
    }
}
