package ru.dz.labs.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.api.domain.Orders;
import ru.dz.labs.api.repository.OrdersRepository;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;

    @Transactional
    public void addOrder(Orders orders) {
        ordersRepository.addOrder(orders);
    }
    @Transactional
     public void deleteOrder(Orders orders) {
        ordersRepository.deleteOrder(orders);
    }
}
