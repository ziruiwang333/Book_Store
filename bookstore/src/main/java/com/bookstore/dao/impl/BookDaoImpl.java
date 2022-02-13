package com.bookstore.dao.impl;

import com.bookstore.dao.BookDao;
import com.bookstore.pojo.Book;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {


    @Override
    public int addBook(Book book) {
        String sql = "INSERT INTO t_book(`name`,price,author,sales,stock,img_path) VALUES (?,?,?,?,?,?)";
        return update(sql, book.getName(), book.getPrice(), book.getAuthor(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public int deleteById(Integer id) {
        String sql = "DELETE FROM t_book WHERE id=?";
        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "UPDATE t_book SET `name`=?,price=?,author=?,sales=?,stock=?,img_path=? WHERE id=?";
        return update(sql, book.getName(), book.getPrice(), book.getAuthor(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "SELECT id, `name`,price,author,sales,stock,img_path FROM t_book WHERE id=?";
        return queryForOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "SELECT id, `name`,price,author,sales,stock,img_path FROM t_book";
        return queryForList(Book.class, sql);
    }

    @Override
    public Integer queryForTotalItemCount() {
        String sql = "SELECT COUNT(*) FROM t_book";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Book> queryForCurrentPageItems(Integer begin, Integer pageSize) {
        String sql = "SELECT id,`name`,author,price,sales,stock,img_path imgPath from t_book limit ?, ?";
        return queryForList(Book.class, sql, begin, pageSize);
    }

    @Override
    public Integer queryForTotalItemCountByPrice(int min, int max) {
        String sql = "SELECT COUNT(*) FROM t_book WHERE price BETWEEN ? AND ?";
        return ((Number) queryForSingleValue(sql, min, max)).intValue();
    }

    @Override
    public List<Book> queryForCurrentPageItems(Integer begin, Integer pageSize, int min, int max) {
        String sql = "SELECT id,`name`,price,author,sales,stock,img_path FROM t_book WHERE price BETWEEN ? AND ? LIMIT ?, ?";
        return queryForList(Book.class, sql, min, max, begin, pageSize);
    }
}
