/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.entity;

import com.supinfo.supsms.entity.PK.SMSPrimaryKeys;
import com.supinfo.supsms.utils.Pair;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import sun.util.calendar.Gregorian;

/**
 *
 * @author ___Cid___
 */
@Entity
@IdClass(SMSPrimaryKeys.class)
public class SMS implements Serializable {
    
    private static long serialVersionUID = 1L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    
    @Id
    private Long id;
    
    @Id
    @ManyToOne
    @JoinColumn
    private SupUser receiver;
    
    @Id
    @ManyToOne
    @JoinColumn
    private SupUser sender;
    
    @Column
    private String message;

    @Override
    public int hashCode() {
        int hash = 0;
        Pair<SupUser, SupUser> id = new Pair<SupUser, SupUser> (sender, receiver);
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof SMS)) {
            return false;
        }
        
        SMS other = (SMS) object;
        Pair<SupUser, SupUser> thisId = new Pair<SupUser, SupUser> (sender, receiver);
        Pair<SupUser, SupUser> otherId = new Pair<SupUser, SupUser> (other.getSender(), other.getReceiver());
        
        return thisId.equals(otherId) && id.equals(other.getId());
    }

    @Override
    public String toString() {
        Calendar time =  new GregorianCalendar();
        time.setTime(new Date(id));
        Pair<SupUser, SupUser> thisId = new Pair<SupUser, SupUser> (sender, receiver);
        return "com.supinfo.supsms.entity.SMS[ id=" + thisId.toString() + ", at="
                + time + " ]";
    }

    /**
     * @return the receiver
     */
    public SupUser getReceiver() {
        return receiver;
    }

    /**
     * @param receiver the receiver to set
     */
    public void setReceiver(SupUser receiver) {
        this.receiver = receiver;
    }

    /**
     * @return the sender
     */
    public SupUser getSender() {
        return sender;
    }

    /**
     * @param sender the sender to set
     */
    public void setSender(SupUser sender) {
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
    public void setId(Calendar dateSent) {
        this.id = dateSent.getTimeInMillis();
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
}
