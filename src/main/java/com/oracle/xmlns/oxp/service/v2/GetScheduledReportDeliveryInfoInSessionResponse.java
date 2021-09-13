
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
 *         &lt;element name="getScheduledReportDeliveryInfoInSessionReturn" type="{http://xmlns.oracle.com/oxp/service/v2}JobOutputDeliverysList"/>
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
    "getScheduledReportDeliveryInfoInSessionReturn"
})
@XmlRootElement(name = "getScheduledReportDeliveryInfoInSessionResponse")
public class GetScheduledReportDeliveryInfoInSessionResponse {

    @XmlElement(required = true)
    protected JobOutputDeliverysList getScheduledReportDeliveryInfoInSessionReturn;

    /**
     * Gets the value of the getScheduledReportDeliveryInfoInSessionReturn property.
     * 
     * @return
     *     possible object is
     *     {@link JobOutputDeliverysList }
     *     
     */
    public JobOutputDeliverysList getGetScheduledReportDeliveryInfoInSessionReturn() {
        return getScheduledReportDeliveryInfoInSessionReturn;
    }

    /**
     * Sets the value of the getScheduledReportDeliveryInfoInSessionReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link JobOutputDeliverysList }
     *     
     */
    public void setGetScheduledReportDeliveryInfoInSessionReturn(JobOutputDeliverysList value) {
        this.getScheduledReportDeliveryInfoInSessionReturn = value;
    }

}
