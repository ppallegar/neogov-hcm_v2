
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
 *         &lt;element name="deleteScheduleInSessionReturn" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "deleteScheduleInSessionReturn"
})
@XmlRootElement(name = "deleteScheduleInSessionResponse")
public class DeleteScheduleInSessionResponse {

    protected boolean deleteScheduleInSessionReturn;

    /**
     * Gets the value of the deleteScheduleInSessionReturn property.
     * 
     */
    public boolean isDeleteScheduleInSessionReturn() {
        return deleteScheduleInSessionReturn;
    }

    /**
     * Sets the value of the deleteScheduleInSessionReturn property.
     * 
     */
    public void setDeleteScheduleInSessionReturn(boolean value) {
        this.deleteScheduleInSessionReturn = value;
    }

}
