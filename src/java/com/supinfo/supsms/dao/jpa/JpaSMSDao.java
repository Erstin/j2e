package com.supinfo.supsms.dao.jpa;

import com.supinfo.supsms.dao.SMSDao;
import com.supinfo.supsms.entity.SMS;
import com.supinfo.supsms.entity.SMS_;
import com.supinfo.supsms.entity.SupUser;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
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
        Calendar time = new GregorianCalendar();
        sms.setId(time);

        em.persist(sms);
    }

    @Override
    public void delSMS(SMS sms) {
        em.remove(sms);
    }

    @Override
    public void delUserSMS(SupUser receiver, SupUser sender) {
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaDelete<SMS> delete = cb.createCriteriaDelete(SMS.class);
        Root e = delete.from(SMS.class);

        delete.where(cb.equal(e.get(SMS_.receiver), receiver));
        delete.where(cb.equal(e.get(SMS_.sender), sender));

        this.em.createQuery(delete).executeUpdate();
    }

    @Override
    public SMS getSMS(SupUser receiver, SupUser sender, Timestamp dateSent) {

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<SMS> query = cb.createQuery(SMS.class);
        Root<SMS> sms = query.from(SMS.class);
        List<Predicate> predicates = new ArrayList();

        if (receiver != null) {
            predicates.add(cb.equal(sms.get(SMS_.receiver), receiver));
        }
        if (sender != null) {
            predicates.add(cb.equal(sms.get(SMS_.sender), sender));
        }
        if (dateSent != null) {
            predicates.add(cb.equal(sms.get(SMS_.id), dateSent));
        }

        query.where(predicates.toArray(new Predicate[predicates.size()]));

        return em.createQuery(query).getSingleResult();

    }

    @Override
    public List<SMS> getUserSMS(SupUser receiver) {
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<SMS> query = cb.createQuery(SMS.class);
        Root<SMS> sms = query.from(SMS.class);
        query.select(sms);
//        List<Predicate> predicates = new ArrayList();
//
//        if (receiver != null) {
//            predicates.add(cb.equal(sms.get(SMS_.receiver), receiver));
//        }
//
//        query.where(predicates.toArray(new Predicate[predicates.size()]));

        return em.createQuery(query).getResultList();
    }

    @Override
    public Map<SupUser, SMS> getConversations(SupUser receiver) {

        Map<SupUser, SMS> res = new HashMap<>();

        for (SMS sms : getUserSMS(receiver)) {
            SMS exist = res.get(sms.getSender());
            if (exist == null || exist.getId() < sms.getId()) {
                res.put(sms.getSender(), sms);
            }
        }

        return res;

    }

    @Override
    public Number getNbSMS() {

        Query q = em.createQuery("SELECT count(x) FROM SMS x");
        return (Number) q.getSingleResult();
    }
}
