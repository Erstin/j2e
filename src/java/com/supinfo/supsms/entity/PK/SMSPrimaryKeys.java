package com.supinfo.supsms.entity.PK;

import com.supinfo.supsms.utils.Pair;
import java.io.Serializable;

/**
 *
 * @author ___Cid___
 */
public class SMSPrimaryKeys implements Serializable {

    private Long receiver;
    
    private Long sender;
    
    private Long id;

    public SMSPrimaryKeys() {
    }

    public SMSPrimaryKeys(Long receiver, Long sender, Long id) {
        this.receiver = receiver;
        this.sender = sender;
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        
        if(obj instanceof SMSPrimaryKeys) {
            SMSPrimaryKeys key = (SMSPrimaryKeys) obj;
            return key.getId().equals(id)
                    && key.getReceiver().equals(receiver)
                    && key.getSender().equals(sender);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 0;
        Pair<Long, Long> thisIs = new Pair<> (sender, receiver);
        hash += (thisIs != null ? thisIs.hashCode() : 0);
        hash += id.hashCode();
        return hash;
    }

    /**
     * @return the receiver
     */
    public Long getReceiver() {
        return receiver;
    }

    /**
     * @param receiver the receiver to set
     */
    public void setReceiver(Long receiver) {
        this.receiver = receiver;
    }

    /**
     * @return the sender
     */
    public Long getSender() {
        return sender;
    }

    /**
     * @param sender the sender to set
     */
    public void setSender(Long sender) {
        this.sender = sender;
    }

    /**
     * @return the dateSent
     */
    public Long getId() {
        return id;
    }

    /**
     * @param dateSent the dateSent to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    
}
