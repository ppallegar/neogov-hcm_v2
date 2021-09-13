
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
 *         &lt;element name="getScheduledReportDeliveryInfoReturn" type="{http://xmlns.oracle.com/oxp/service/v2}JobOutputDeliverysList"/>
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
    "getScheduledReportDeliveryInfoReturn"
})
@XmlRootElement(name = "getScheduledReportDeliveryInfoResponse")
public class GetScheduledReportDeliveryInfoResponse {

    @XmlElement(required = true)
    protected JobOutputDeliverysList getScheduledReportDeliveryInfoReturn;

    /**
     * Gets the value of the getScheduledReportDeliveryInfoReturn property.
     * 
     * @return
     *     possible object is
     *     {@link JobOutputDeliverysList }
     *     
     */
    public JobOutputDeliverysList getGetScheduledReportDeliveryInfoReturn() {
        return getScheduledReportDeliveryInfoReturn;
    }

    /**
     * Sets the value of the getScheduledReportDeliveryInfoReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link JobOutputDeliverysList }
     *     
     */
    public void setGetScheduledReportDeliveryInfoReturn(JobOutputDeliverysList value) {
        this.getScheduledReportDeliveryInfoReturn = value;
    }

}
