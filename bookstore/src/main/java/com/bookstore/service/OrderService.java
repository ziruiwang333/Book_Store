package com.bookstore.service;

import com.bookstore.pojo.Cart;

public interface OrderService {
    public abstract String createOrder(Cart cart, Integer userId);
}
