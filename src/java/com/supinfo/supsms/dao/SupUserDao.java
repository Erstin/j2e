package com.supinfo.supsms.dao;

import com.supinfo.supsms.entity.SupUser;
import java.lang.reflect.Method;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ___Cid___
 */
@Local
public interface SupUserDao {

    public void addUser(SupUser supUser);
    
    public void delUser(SupUser supUser);
    
    public SupUser getSupUser(Long phoneNumber);
    
    public List<SupUser> getAllUser();
    
}
