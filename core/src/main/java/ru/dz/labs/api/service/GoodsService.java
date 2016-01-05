package ru.dz.labs.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.api.domain.Goods;
import ru.dz.labs.api.repository.GoodsRepository;

import java.util.List;

@Service
public class GoodsService {
    @Autowired
    private GoodsRepository goodsRepository;

    @Transactional
    public void addGood(Goods goods) {
        goodsRepository.addGood(goods);
    }

    @Transactional
    public List<Goods> getAllGoods() {
        return goodsRepository.getAllGoods();
    }

    @Transactional
    public void updateGood(Goods goods) {
        goodsRepository.updateGood(goods);
    }

    @Transactional
    public void deleteGood(Goods goods) {
        goodsRepository.deleteGood(goods);
    }
}
