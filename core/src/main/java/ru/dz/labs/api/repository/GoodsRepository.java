package ru.dz.labs.api.repository;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dz.labs.api.domain.Categories;
import ru.dz.labs.api.domain.Goods;

import java.util.List;
@Repository
public class GoodsRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Goods> getAllGoods() {
        return sessionFactory.getCurrentSession().createCriteria(Goods.class).list();
    }

    public void addGood(Goods goods) {
        sessionFactory.getCurrentSession().save(goods);
    }

    public void updateGood(Goods goods) {
        sessionFactory.getCurrentSession().update(goods);
    }
    public void deleteGood(Goods goods) {
        sessionFactory.getCurrentSession().delete(goods);
    }
    public List<Goods> getGoodsByCategorysName(String name) {
        List<Goods> result;
        Categories categories;
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Categories.class);
        crit.add(Restrictions.like("name", name));
        categories=(Categories) crit.uniqueResult();
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        crit2.add(Restrictions.like("category", categories));
        result=crit2.list();
        System.out.println("result="+result);
        return result;
    }
    public Goods getGoodsById(Long id) {
        Goods result;
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        crit.add(Restrictions.like("id", id));
        result=(Goods) crit.uniqueResult();
        return result;
    }
}
