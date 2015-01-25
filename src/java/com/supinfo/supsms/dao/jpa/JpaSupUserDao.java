package com.supinfo.supsms.dao.jpa;

import com.supinfo.supsms.dao.SupUserDao;
import com.supinfo.supsms.entity.SupUser;
import java.lang.reflect.Method;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ___Cid___
 */
@Stateless
public class JpaSupUserDao implements SupUserDao {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void addUser(SupUser supUser) {
        em.persist(supUser);
    }

    @Override
    public void delUser(SupUser supUser) {
        em.remove(supUser);
    }

    @Override
    public SupUser getSupUser(Long phoneNumber) {
        return em.find(SupUser.class, phoneNumber);
    }

    @Override
    public List<SupUser> getAllUser() {
        return em.createQuery("SELECT * FROM supuser").getResultList();
    }
    
}
