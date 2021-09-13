
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
 *         &lt;element name="resendScheduledReportInSessionReturn" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "resendScheduledReportInSessionReturn"
})
@XmlRootElement(name = "resendScheduledReportInSessionResponse")
public class ResendScheduledReportInSessionResponse {

    protected boolean resendScheduledReportInSessionReturn;

    /**
     * Gets the value of the resendScheduledReportInSessionReturn property.
     * 
     */
    public boolean isResendScheduledReportInSessionReturn() {
        return resendScheduledReportInSessionReturn;
    }

    /**
     * Sets the value of the resendScheduledReportInSessionReturn property.
     * 
     */
    public void setResendScheduledReportInSessionReturn(boolean value) {
        this.resendScheduledReportInSessionReturn = value;
    }

}
