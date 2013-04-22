
package com.fengjing.framework.webservice.jaxws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dept complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dept">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="deptid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="deptname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dept", propOrder = {
    "deptid",
    "deptname"
})
public class Dept {

    protected int deptid;
    protected String deptname;

    /**
     * Gets the value of the deptid property.
     * 
     */
    public int getDeptid() {
        return deptid;
    }

    /**
     * Sets the value of the deptid property.
     * 
     */
    public void setDeptid(int value) {
        this.deptid = value;
    }

    /**
     * Gets the value of the deptname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeptname() {
        return deptname;
    }

    /**
     * Sets the value of the deptname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeptname(String value) {
        this.deptname = value;
    }

}
