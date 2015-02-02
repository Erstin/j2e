package com.supinfo.supsms.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ___Cid___
 */
@Entity
public class SupUser implements Serializable {

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
    private Long phoneNumber;
    
    @Column
    private String username;
    
    @Column
    @NotNull
    private String lastName;
    
    @Column
    @NotNull
    private String firstName;
    
    @Column
    @NotNull
    private String password;
    
    @Column
    private String email;
    
    @Column
    private String credCard;
    
    @ManyToOne
    private Addr address;
    
    @ManyToMany
    private List<SupUser> contacts;
    
    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getPhoneNumber() != null ? getPhoneNumber().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof SupUser)) {
            return false;
        }
        SupUser other = (SupUser) object;
        if ((this.getPhoneNumber() == null && other.getPhoneNumber() != null) || (this.getPhoneNumber() != null && !this.phoneNumber.equals(other.phoneNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.supinfo.supsms.entity.User[ id=" + getPhoneNumber() + " ]";
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the credCard
     */
    public String getCredCard() {
        return credCard;
    }

    /**
     * @param credCard the credCard to set
     */
    public void setCredCard(String credCard) {
        this.credCard = credCard;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the contacts
     */
    public List<SupUser> getContacts() {
        return contacts;
    }

    /**
     * @param contacts the contacts to set
     */
    public void setContacts(List<SupUser> contacts) {
        this.contacts = contacts;
    }

    /**
     * @return the address
     */
    public Addr getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(Addr address) {
        this.address = address;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
}
