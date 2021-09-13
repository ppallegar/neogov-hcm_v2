
package com.oracle.xmlns.oxp.service.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="purgeJobHistoryReturn" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "purgeJobHistoryReturn"
})
@XmlRootElement(name = "purgeJobHistoryResponse")
public class PurgeJobHistoryResponse {

    protected boolean purgeJobHistoryReturn;

    /**
     * Gets the value of the purgeJobHistoryReturn property.
     * 
     */
    public boolean isPurgeJobHistoryReturn() {
        return purgeJobHistoryReturn;
    }

    /**
     * Sets the value of the purgeJobHistoryReturn property.
     * 
     */
    public void setPurgeJobHistoryReturn(boolean value) {
        this.purgeJobHistoryReturn = value;
    }

}
