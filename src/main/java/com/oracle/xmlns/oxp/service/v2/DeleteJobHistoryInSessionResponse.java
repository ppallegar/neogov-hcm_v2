
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
 *         &lt;element name="deleteJobHistoryInSessionReturn" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "deleteJobHistoryInSessionReturn"
})
@XmlRootElement(name = "deleteJobHistoryInSessionResponse")
public class DeleteJobHistoryInSessionResponse {

    protected boolean deleteJobHistoryInSessionReturn;

    /**
     * Gets the value of the deleteJobHistoryInSessionReturn property.
     * 
     */
    public boolean isDeleteJobHistoryInSessionReturn() {
        return deleteJobHistoryInSessionReturn;
    }

    /**
     * Sets the value of the deleteJobHistoryInSessionReturn property.
     * 
     */
    public void setDeleteJobHistoryInSessionReturn(boolean value) {
        this.deleteJobHistoryInSessionReturn = value;
    }

}