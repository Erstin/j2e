package com.supinfo.supsms.entity;

import javax.persistence.Embeddable;

/**
 *
 * @author ___Cid___
 */
@Embeddable
public class Street {
    
    private String streetName;
    private String cityName;
    private String zipCode;

    /**
     * @return the streetName
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * @param streetName the streetName to set
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * @return the cityName
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * @param cityName the cityName to set
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * @return the zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public int hashCode() {
        return (streetName + cityName+ zipCode).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Street)) {
            return  false;
        }
        
        Street other = (Street)obj;
        return streetName.equals(other.getStreetName()) 
                && cityName.equals(other.getCityName()) 
                && zipCode.equals(other.getZipCode());
    }
}
