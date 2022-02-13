package com.bookstore.dao.impl;

import com.bookstore.dao.OrderDao;
import com.bookstore.pojo.Order;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "INSERT INTO t_order(order_id,create_time,price,status,user_id) VALUES(?,?,?,?,?)";
        return update(sql, order.getOrderId(), order.getCreateDate(), order.getPrice(), order.getStatus(), order.getUserId());
    }
}
