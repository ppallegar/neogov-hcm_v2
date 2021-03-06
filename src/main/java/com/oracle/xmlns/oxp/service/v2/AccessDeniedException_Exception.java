
package com.oracle.xmlns.oxp.service.v2;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "fault", targetNamespace = "http://xmlns.oracle.com/oxp/service/v2")
public class AccessDeniedException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private AccessDeniedException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public AccessDeniedException_Exception(String message, AccessDeniedException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public AccessDeniedException_Exception(String message, AccessDeniedException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.oracle.xmlns.oxp.service.v2.AccessDeniedException
     */
    public AccessDeniedException getFaultInfo() {
        return faultInfo;
    }

}
