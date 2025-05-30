package vn.com.t3h.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import vn.com.t3h.dao.UserDao;
import vn.com.t3h.entity.UserEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Long countAllUser(String username, Boolean active, LocalDate createdDate) {
        try(Session session = sessionFactory.openSession()) {
            StringBuffer hql = new StringBuffer("select count(*) from UserEntity user " +
                    "where 1 = 1");
            if (StringUtils.hasLength(username)) {
                hql.append(" and user.username like '").append(username).append("'");
            }
            if (active != null) {
                hql.append(" and user.active = ").append(active);
            }
            if (createdDate != null) {
                hql.append(" and user.createdDate = ").append(createdDate);
            }
            Query query = session.createQuery(hql.toString());
            return (Long) query.uniqueResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0L;
    }

    @Override
    public List<UserEntity> getAll(Long offset, Long pageSize, String username, Boolean active, LocalDate createdDate) {
        try(Session session = sessionFactory.openSession()) {
            StringBuffer hql = new StringBuffer("select user from UserEntity user " +
                    "where 1 = 1");
            if (StringUtils.hasLength(username)) {
                hql.append(" and user.username like '").append(username).append("'");
            }
            if (active != null) {
                hql.append(" and user.active = ").append(active);
            }
            if (createdDate != null) {
                hql.append(" and user.created = ").append(createdDate);
            }
            Query query = session.createQuery(hql.toString(), UserEntity.class);
            query.setFirstResult(Integer.parseInt(String.valueOf(offset)));
            query.setMaxResults(Integer.parseInt(String.valueOf(pageSize)));
            return query.getResultList();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
