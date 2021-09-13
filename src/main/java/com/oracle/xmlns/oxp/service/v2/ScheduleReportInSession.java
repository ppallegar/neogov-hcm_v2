
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
 *         &lt;element name="scheduleRequest" type="{http://xmlns.oracle.com/oxp/service/v2}ScheduleRequest"/>
 *         &lt;element name="deliveryChannels" type="{http://xmlns.oracle.com/oxp/service/v2}DeliveryChannels"/>
 *         &lt;element name="bipSessionToken" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "scheduleRequest",
    "deliveryChannels",
    "bipSessionToken"
})
@XmlRootElement(name = "scheduleReportInSession")
public class ScheduleReportInSession {

    @XmlElement(required = true)
    protected ScheduleRequest scheduleRequest;
    @XmlElement(required = true)
    protected DeliveryChannels deliveryChannels;
    @XmlElement(required = true)
    protected String bipSessionToken;

    /**
     * Gets the value of the scheduleRequest property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleRequest }
     *     
     */
    public ScheduleRequest getScheduleRequest() {
        return scheduleRequest;
    }

    /**
     * Sets the value of the scheduleRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleRequest }
     *     
     */
    public void setScheduleRequest(ScheduleRequest value) {
        this.scheduleRequest = value;
    }

    /**
     * Gets the value of the deliveryChannels property.
     * 
     * @return
     *     possible object is
     *     {@link DeliveryChannels }
     *     
     */
    public DeliveryChannels getDeliveryChannels() {
        return deliveryChannels;
    }

    /**
     * Sets the value of the deliveryChannels property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeliveryChannels }
     *     
     */
    public void setDeliveryChannels(DeliveryChannels value) {
        this.deliveryChannels = value;
    }

    /**
     * Gets the value of the bipSessionToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBipSessionToken() {
        return bipSessionToken;
    }

    /**
     * Sets the value of the bipSessionToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBipSessionToken(String value) {
        this.bipSessionToken = value;
    }

}
