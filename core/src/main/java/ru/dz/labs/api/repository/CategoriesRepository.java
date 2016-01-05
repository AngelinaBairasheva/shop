package ru.dz.labs.api.repository;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dz.labs.api.domain.Categories;

import java.util.List;

@Repository
public class CategoriesRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Categories> getAllCategories() {
        return sessionFactory.getCurrentSession().createCriteria(Categories.class).list();
    }

    public void addCategory(Categories category) {
        sessionFactory.getCurrentSession().save(category);
    }

    public void updateCategory(Categories category) {
        sessionFactory.getCurrentSession().update(category);
    }

    public Categories getCategoryById(Long id) {
        return (Categories) sessionFactory.getCurrentSession().load(Categories.class, id);
    }

    public void deleteCategory(Categories category) {
        sessionFactory.getCurrentSession().delete(category);
    }

    public List<Categories> getRootCategories() {
        List<Categories> categories;
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Categories.class);
        crit.add(Restrictions.isNull("parent"));
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        categories = /*crit.setProjection(Projections.projectionList()
                .add(Projections.distinct(Projections.property("name"))) //distinct
        )*/crit.list();
        return categories;
    }
}
