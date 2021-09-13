
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
 *         &lt;element name="downloadDocumentDataReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "downloadDocumentDataReturn"
})
@XmlRootElement(name = "downloadDocumentDataResponse")
public class DownloadDocumentDataResponse {

    @XmlElement(required = true)
    protected String downloadDocumentDataReturn;

    /**
     * Gets the value of the downloadDocumentDataReturn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDownloadDocumentDataReturn() {
        return downloadDocumentDataReturn;
    }

    /**
     * Sets the value of the downloadDocumentDataReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDownloadDocumentDataReturn(String value) {
        this.downloadDocumentDataReturn = value;
    }

}
