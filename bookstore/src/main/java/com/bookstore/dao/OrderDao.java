package com.bookstore.dao;

import com.bookstore.pojo.Order;

public interface OrderDao {

    public abstract int saveOrder(Order order);

}
