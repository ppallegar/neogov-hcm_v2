
package com.oracle.xmlns.oxp.service.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JobOutputsList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JobOutputsList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="jobOutputList" type="{http://xmlns.oracle.com/oxp/service/v2}ArrayOfJobOutput"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JobOutputsList", propOrder = {
    "jobOutputList"
})
public class JobOutputsList {

    @XmlElement(required = true, nillable = true)
    protected ArrayOfJobOutput jobOutputList;

    /**
     * Gets the value of the jobOutputList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJobOutput }
     *     
     */
    public ArrayOfJobOutput getJobOutputList() {
        return jobOutputList;
    }

    /**
     * Sets the value of the jobOutputList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJobOutput }
     *     
     */
    public void setJobOutputList(ArrayOfJobOutput value) {
        this.jobOutputList = value;
    }

}
