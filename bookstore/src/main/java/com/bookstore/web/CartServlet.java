package com.bookstore.web;

import com.bookstore.pojo.Book;
import com.bookstore.pojo.Cart;
import com.bookstore.pojo.CartItem;
import com.bookstore.service.BookService;
import com.bookstore.service.impl.BookServiceImpl;
import com.bookstore.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

//    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int id = WebUtils.parseInt(req.getParameter("id"), 0);
//        Book book = bookService.queryBookById(id);
//        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
//        Cart cart = (Cart) req.getSession().getAttribute("cart");
//        if (cart == null) {
//            cart = new Cart();
//            req.getSession().setAttribute("cart", cart);
//        }
//        cart.addItem(cartItem);
//        // 最后一个添加的商品名称
//        req.getSession().setAttribute("lastAddName", cartItem.getName());
//        resp.sendRedirect(req.getHeader("Referer"));
//    }

    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
        // 最后一个添加的商品名称
        req.getSession().setAttribute("lastAddName", cartItem.getName());
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("totalCount", cart.getTotalCount());
        resultMap.put("lastName", cartItem.getName());
        Gson gson = new Gson();
        String json = gson.toJson(resultMap);
        resp.getWriter().write(json);
    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.deleteItem(id);

        }
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.clear();
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        int count = WebUtils.parseInt(req.getParameter("count"), 1);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart!=null){
            cart.updateCount(id, count);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    }
