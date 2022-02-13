package com.bookstore.dao.impl;

import com.bookstore.dao.OrderItemDao;
import com.bookstore.pojo.OrderItem;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "INSERT INTO t_order_item(id,`name`,count,price,total_price,order_id) VALUES(?,?,?,?,?,?)";
        return update(sql, orderItem.getId(), orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotal_price(), orderItem.getOrder_id());
    }
}
