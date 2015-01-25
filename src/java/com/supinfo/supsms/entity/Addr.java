package com.supinfo.supsms.entity;

import javax.persistence.Embeddable;

/**
 *
 * @author ___Cid___
 */
@Embeddable
public class Addr {
    
    private Short streetNumber;
    
    private Street street;

    /**
     * @return the streetNumber
     */
    public Short getStreetNumber() {
        return streetNumber;
    }

    /**
     * @param StreetNumber the streetNumber to set
     */
    public void setStreetNumber(Short StreetNumber) {
        this.streetNumber = StreetNumber;
    }

    /**
     * @return the street
     */
    public Street getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(Street street) {
        this.street = street;
    }

    @Override
    public int hashCode() {
        return streetNumber.hashCode() + street.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Addr)) {
            return false;
        }
        
        Addr other = (Addr)obj;
        return streetNumber.equals(other.getStreetNumber()) && street.equals(other.getStreet());
    }
}
