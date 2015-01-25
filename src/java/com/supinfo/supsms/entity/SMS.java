/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.entity;

import com.supinfo.supsms.utils.Pair;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.metamodel.domain.Superclass;

/**
 *
 * @author ___Cid___
 */
@Entity
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
    @ManyToOne
    private SupUser receiver;
    
    @Id
    @ManyToOne
    private SupUser sender;
    
    @Id
    private Timestamp dateSent;
    
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SMS)) {
            return false;
        }
        
        SMS other = (SMS) object;
        Pair<SupUser, SupUser> thisId = new Pair<SupUser, SupUser> (sender, receiver);
        Pair<SupUser, SupUser> otherId = new Pair<SupUser, SupUser> (other.getSender(), other.getReceiver());
        
        return thisId.equals(otherId) && dateSent.equals(other.getDateSent());
    }

    @Override
    public String toString() {
        Pair<SupUser, SupUser> thisId = new Pair<SupUser, SupUser> (sender, receiver);
        return "com.supinfo.supsms.entity.SMS[ id=" + thisId.toString() + ", at=" + getDateSent() + " ]";
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
    public Timestamp getDateSent() {
        return dateSent;
    }

    /**
     * @param dateSent the dateSent to set
     */
    public void setDateSent(Timestamp dateSent) {
        this.dateSent = dateSent;
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
