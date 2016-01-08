package ru.dz.labs.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.api.domain.Goods;
import ru.dz.labs.api.repository.GoodsRepository;

import java.math.BigDecimal;
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
    public List<String> getTypesOfChocolate() {
        return goodsRepository.getTypesOfChocolate();
    }

    @Transactional
    public List<Goods> getAllGoods() {
        return goodsRepository.getAllGoods();
    }
    @Transactional
    public int getPagesCount(List<Goods> goodses) {
        return goodsRepository.getPagesCount(goodses);
    }

    @Transactional
    public void updateGood(Goods goods) {
        goodsRepository.updateGood(goods);
    }

    @Transactional
    public void deleteGood(Goods goods) {
        goodsRepository.deleteGood(goods);
    }
    @Transactional
     public List<Goods> getGoodsByCategorysName(String name) {
        return goodsRepository.getGoodsByCategorysName(name);
    }
    @Transactional
    public List<Goods> getGoodsByPage(List<Goods> goods, int page) {
        return goodsRepository.getGoodsByPage(goods,page);
    }
    @Transactional
    public Goods getGoodsById(Long id) {
        return goodsRepository.getGoodsById(id);
    }
    @Transactional
    public List<Goods> getNewGoods() {
        return goodsRepository.getNewGoods();
    }
    @Transactional
    public List<Goods> getGoodsByInterval(double start,double end, String catalogName) {
        return goodsRepository.getGoodsByInterval(start, end, catalogName);
    }
    @Transactional
    public BigDecimal getMaxPrice() {
        return goodsRepository.getMaxPrice();
    }
    @Transactional
    public BigDecimal getMinPrice() {
        return goodsRepository.getMinPrice();
    }

    @Transactional
    public List<Goods> getChocolatesByKind(String kind) {
        return goodsRepository.getChocolatesByKind(kind);
    }
}
