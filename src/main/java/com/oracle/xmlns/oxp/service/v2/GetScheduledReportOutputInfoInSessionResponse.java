
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
 *         &lt;element name="getScheduledReportOutputInfoInSessionReturn" type="{http://xmlns.oracle.com/oxp/service/v2}JobOutputsList"/>
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
    "getScheduledReportOutputInfoInSessionReturn"
})
@XmlRootElement(name = "getScheduledReportOutputInfoInSessionResponse")
public class GetScheduledReportOutputInfoInSessionResponse {

    @XmlElement(required = true)
    protected JobOutputsList getScheduledReportOutputInfoInSessionReturn;

    /**
     * Gets the value of the getScheduledReportOutputInfoInSessionReturn property.
     * 
     * @return
     *     possible object is
     *     {@link JobOutputsList }
     *     
     */
    public JobOutputsList getGetScheduledReportOutputInfoInSessionReturn() {
        return getScheduledReportOutputInfoInSessionReturn;
    }

    /**
     * Sets the value of the getScheduledReportOutputInfoInSessionReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link JobOutputsList }
     *     
     */
    public void setGetScheduledReportOutputInfoInSessionReturn(JobOutputsList value) {
        this.getScheduledReportOutputInfoInSessionReturn = value;
    }

}
