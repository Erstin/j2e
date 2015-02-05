package com.supinfo.supsms.dao;

import com.supinfo.supsms.entity.SMS;
import com.supinfo.supsms.entity.SupUser;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author ___Cid___
 */
@Local
public interface SMSDao {

    public void addSMS(SMS sms);
    
    public void delSMS(SMS sms);
    
    public void delUserSMS(SupUser receiver, SupUser sender);
    
    public SMS getSMS(SupUser receiver, SupUser sender, Timestamp dateSent);
    
    public List<SMS> getUserSMS(SupUser receiver);
    
    public Map<SupUser, SMS> getConversations(SupUser receiver);
    
    public Number getNbSMS();
    
}
