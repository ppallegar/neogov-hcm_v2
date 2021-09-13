
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
 *         &lt;element name="getAllScheduledReportReturn" type="{http://xmlns.oracle.com/oxp/service/v2}JobInfosList"/>
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
    "getAllScheduledReportReturn"
})
@XmlRootElement(name = "getAllScheduledReportResponse")
public class GetAllScheduledReportResponse {

    @XmlElement(required = true)
    protected JobInfosList getAllScheduledReportReturn;

    /**
     * Gets the value of the getAllScheduledReportReturn property.
     * 
     * @return
     *     possible object is
     *     {@link JobInfosList }
     *     
     */
    public JobInfosList getGetAllScheduledReportReturn() {
        return getAllScheduledReportReturn;
    }

    /**
     * Sets the value of the getAllScheduledReportReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link JobInfosList }
     *     
     */
    public void setGetAllScheduledReportReturn(JobInfosList value) {
        this.getAllScheduledReportReturn = value;
    }

}
