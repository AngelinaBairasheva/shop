package ru.dz.labs.api.repository;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dz.labs.api.domain.Cart;

import java.util.List;

@Repository
public class CartRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Cart> getAllCarts() {
        return sessionFactory.getCurrentSession().createCriteria(Cart.class).list();
    }

    public void addCart(Cart cart) {
        sessionFactory.getCurrentSession().save(cart);
    }

    public void updateCart(Cart cart) {
        sessionFactory.getCurrentSession().update(cart);
    }

    public Cart getCartById(Long id) {
        return (Cart) sessionFactory.getCurrentSession().load(Cart.class, id);
    }

    public void deleteCart(Cart cart) {
        sessionFactory.getCurrentSession().delete(cart);
    }
}
