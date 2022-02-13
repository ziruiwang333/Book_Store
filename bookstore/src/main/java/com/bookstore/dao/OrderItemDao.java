package com.bookstore.dao;

import com.bookstore.pojo.OrderItem;

public interface OrderItemDao {

    public abstract int saveOrderItem(OrderItem orderItem);

}
