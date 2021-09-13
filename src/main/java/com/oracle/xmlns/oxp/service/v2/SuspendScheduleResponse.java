
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
 *         &lt;element name="suspendScheduleReturn" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "suspendScheduleReturn"
})
@XmlRootElement(name = "suspendScheduleResponse")
public class SuspendScheduleResponse {

    protected boolean suspendScheduleReturn;

    /**
     * Gets the value of the suspendScheduleReturn property.
     * 
     */
    public boolean isSuspendScheduleReturn() {
        return suspendScheduleReturn;
    }

    /**
     * Sets the value of the suspendScheduleReturn property.
     * 
     */
    public void setSuspendScheduleReturn(boolean value) {
        this.suspendScheduleReturn = value;
    }

}
