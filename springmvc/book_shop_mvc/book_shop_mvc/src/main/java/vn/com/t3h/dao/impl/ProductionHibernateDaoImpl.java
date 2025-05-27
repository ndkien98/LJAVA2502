package vn.com.t3h.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import vn.com.t3h.dao.ProductionDao;
import vn.com.t3h.entity.ProductionEntity;
import vn.com.t3h.model.ProductionModel;

import java.util.ArrayList;
import java.util.List;

@Repository("productionHibernateDaoImpl")
public class ProductionHibernateDaoImpl implements ProductionDao {

    private final SessionFactory sessionFactory;

    public ProductionHibernateDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public Long countProduction(String title,String author,Integer publicYear,String categoryName) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "select count(p) from ProductionEntity p left join p.category c where 1 = 1";
            if (StringUtils.hasLength(title)) {
                hql += " and p.title like '%" + title + "%'";
            }
            if (StringUtils.hasLength(author)) {
                hql += " and p.author like '%" + author + "%'";
            }
            if (StringUtils.hasLength(categoryName)) {
                hql += " and c.categoryName like '%" + categoryName + "%'";
            }
            if (publicYear != null) {
                hql += " and p.publicYear = " + publicYear;
            }
            Query query = session.createQuery(hql);
            return (Long) query.uniqueResult();
        }
    }

    public List<ProductionEntity> findProductionPaging(Long limit, Long offset,
                                                       String title,String author,Integer publicYear,String categoryName) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "Select p from ProductionEntity p left join p.category c where 1 = 1";
            if (StringUtils.hasLength(title)) {
                hql += " and p.title like '%" + title + "%'";
            }
            if (StringUtils.hasLength(author)) {
                hql += " and p.author like '%" + author + "%'";
            }
            if (StringUtils.hasLength(categoryName)) {
                hql += " and c.categoryName like '%" + categoryName + "%'";
            }
            if (publicYear != null) {
                hql += " and p.publicYear = " + publicYear;
            }
            Query query = session.createQuery(hql,ProductionEntity.class);
            query.setFirstResult(Integer.parseInt(String.valueOf(offset)));
            query.setMaxResults(Integer.parseInt(String.valueOf(limit)));
            return query.getResultList();
        }
    }

    @Override
    public List<ProductionEntity> getProduction() {
        List<ProductionEntity> productionEntities = new ArrayList<ProductionEntity>();
        try(Session session = sessionFactory.openSession()) {
            String hql = "from ProductionEntity";
            Query query = session.createQuery(hql, ProductionEntity.class);
            productionEntities = query.getResultList();
        }
        return productionEntities;
    }

    @Override
    public ProductionEntity findById(Integer id) {
        ProductionEntity productionEntity = null;
        try(Session session = sessionFactory.openSession()) {
            String hql = "from ProductionEntity where id = :id";
            Query query = session.createQuery(hql,ProductionEntity.class);
            query.setParameter("id", id);
            productionEntity = (ProductionEntity) query.uniqueResult();
        }
        return productionEntity;
    }
}
