
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
 *         &lt;element name="getDocumentDataInSessionReturn" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
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
    "getDocumentDataInSessionReturn"
})
@XmlRootElement(name = "getDocumentDataInSessionResponse")
public class GetDocumentDataInSessionResponse {

    @XmlElement(required = true)
    protected byte[] getDocumentDataInSessionReturn;

    /**
     * Gets the value of the getDocumentDataInSessionReturn property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getGetDocumentDataInSessionReturn() {
        return getDocumentDataInSessionReturn;
    }

    /**
     * Sets the value of the getDocumentDataInSessionReturn property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setGetDocumentDataInSessionReturn(byte[] value) {
        this.getDocumentDataInSessionReturn = value;
    }

}
