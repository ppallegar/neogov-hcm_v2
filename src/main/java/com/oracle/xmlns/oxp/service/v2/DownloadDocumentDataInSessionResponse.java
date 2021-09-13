
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
 *         &lt;element name="downloadDocumentDataInSessionReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "downloadDocumentDataInSessionReturn"
})
@XmlRootElement(name = "downloadDocumentDataInSessionResponse")
public class DownloadDocumentDataInSessionResponse {

    @XmlElement(required = true)
    protected String downloadDocumentDataInSessionReturn;

    /**
     * Gets the value of the downloadDocumentDataInSessionReturn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDownloadDocumentDataInSessionReturn() {
        return downloadDocumentDataInSessionReturn;
    }

    /**
     * Sets the value of the downloadDocumentDataInSessionReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDownloadDocumentDataInSessionReturn(String value) {
        this.downloadDocumentDataInSessionReturn = value;
    }

}
