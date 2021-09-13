
package com.oracle.xmlns.oxp.service.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="getScheduledJobInfoReturn" type="{http://xmlns.oracle.com/oxp/service/v2}JobDetail"/>
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
    "getScheduledJobInfoReturn"
})
@XmlRootElement(name = "getScheduledJobInfoResponse")
public class GetScheduledJobInfoResponse {

    @XmlElement(required = true)
    protected JobDetail getScheduledJobInfoReturn;

    /**
     * Gets the value of the getScheduledJobInfoReturn property.
     * 
     * @return
     *     possible object is
     *     {@link JobDetail }
     *     
     */
    public JobDetail getGetScheduledJobInfoReturn() {
        return getScheduledJobInfoReturn;
    }

    /**
     * Sets the value of the getScheduledJobInfoReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link JobDetail }
     *     
     */
    public void setGetScheduledJobInfoReturn(JobDetail value) {
        this.getScheduledJobInfoReturn = value;
    }

}
