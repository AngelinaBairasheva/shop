package ru.dz.labs.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.api.domain.Cart;
import ru.dz.labs.api.repository.CartRepository;

@Service
public class CartsService {
    @Autowired
    private CartRepository cartRepository;

    @Transactional
    public void addCart(Cart cart) {
        cartRepository.addCart(cart);
    }
}
