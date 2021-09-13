
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
 *         &lt;element name="getAllScheduledReportHistoryInSessionReturn" type="{http://xmlns.oracle.com/oxp/service/v2}JobInfosList"/>
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
    "getAllScheduledReportHistoryInSessionReturn"
})
@XmlRootElement(name = "getAllScheduledReportHistoryInSessionResponse")
public class GetAllScheduledReportHistoryInSessionResponse {

    @XmlElement(required = true)
    protected JobInfosList getAllScheduledReportHistoryInSessionReturn;

    /**
     * Gets the value of the getAllScheduledReportHistoryInSessionReturn property.
     * 
     * @return
     *     possible object is
     *     {@link JobInfosList }
     *     
     */
    public JobInfosList getGetAllScheduledReportHistoryInSessionReturn() {
        return getAllScheduledReportHistoryInSessionReturn;
    }

    /**
     * Sets the value of the getAllScheduledReportHistoryInSessionReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link JobInfosList }
     *     
     */
    public void setGetAllScheduledReportHistoryInSessionReturn(JobInfosList value) {
        this.getAllScheduledReportHistoryInSessionReturn = value;
    }

}
