package com.supinfo.supsms.dao.jpa;

import com.supinfo.supsms.dao.SMSDao;
import com.supinfo.supsms.entity.SMS;
import com.supinfo.supsms.entity.SupUser;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author ___Cid___
 */
@Stateless
public class JpaSMSDao implements SMSDao {

    @PersistenceContext
    private EntityManager em;    

    @Override
    public void addSMS(SMS sms) {
        Timestamp time = new Timestamp(new Date().getTime());
        sms.setDateSent(time);
        
        em.persist(sms);
    }

    @Override
    public void delSMS(SMS sms) {
        em.remove(sms);
    }

    @Override
    public SMS getSMS(SupUser receiver, SupUser sender, Timestamp dateSent) {
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        
        CriteriaQuery<SMS> query = cb.createQuery(SMS.class);
        Root<SMS> sms = query.from(SMS.class);
        List<Predicate> predicates = new ArrayList();
        
        if (receiver != null) {
            predicates.add(cb.equal(sms.get("receiver"), receiver));
        }
        if (sender != null) {
            predicates.add(cb.equal(sms.get("sender"), sender));
        }
        if (dateSent != null) {
            predicates.add(cb.equal(sms.get("dateSent").as(Timestamp.class), dateSent));
        }
        
        query.where(predicates.toArray(new Predicate[predicates.size()]));
        
        return  em.createQuery(query).getSingleResult();
        
    }

    @Override
    public List<SMS> getUserSMS(SupUser receiver) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        
        CriteriaQuery<SMS> query = cb.createQuery(SMS.class);
        Root<SMS> sms = query.from(SMS.class);
        List<Predicate> predicates = new ArrayList();
        
        if (receiver != null) {
            predicates.add(cb.equal(sms.get("receiver"), receiver));
        }
        
        query.where(predicates.toArray(new Predicate[predicates.size()]));
        
        return  em.createQuery(query).getResultList();
    }

    @Override
    public Number getNbSMS() {

        Query q = em.createQuery ("SELECT count(x) FROM SMS x");
        return (Number) q.getSingleResult ();
    }
}
