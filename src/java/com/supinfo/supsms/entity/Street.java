/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private String ZIPCode;

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
     * @return the ZIPCode
     */
    public String getZIPCode() {
        return ZIPCode;
    }

    /**
     * @param ZIPCode the ZIPCode to set
     */
    public void setZIPCode(String ZIPCode) {
        this.ZIPCode = ZIPCode;
    }

    @Override
    public int hashCode() {
        return (streetName + cityName+ ZIPCode).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Street)) {
            return  false;
        }
        
        Street other = (Street)obj;
        return streetName.equals(other.getStreetName()) 
                && cityName.equals(other.getCityName()) 
                && ZIPCode.equals(other.getZIPCode());
    }
}
