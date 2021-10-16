//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.06.12 at 08:31:11 AM IST 
//


package org.example.customersalesorder;

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
 *         &lt;element name="sapSalesOrder" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sapSalesOrderCreationDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerSapCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sapLineItem" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sapMaterial" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sapOrderQuantity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sapOrderUnit" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "sapSalesOrder",
    "sapSalesOrderCreationDate",
    "customerSapCode",
    "customerName",
    "customerAddress",
    "sapLineItem",
    "sapMaterial",
    "sapOrderQuantity",
    "sapOrderUnit"
})
@XmlRootElement(name = "CustomerRequest")
public class CustomerRequest {

    @XmlElement(required = true)
    protected String sapSalesOrder;
    @XmlElement(required = true)
    protected String sapSalesOrderCreationDate;
    @XmlElement(required = true)
    protected String customerSapCode;
    @XmlElement(required = true)
    protected String customerName;
    @XmlElement(required = true)
    protected String customerAddress;
    @XmlElement(required = true)
    protected String sapLineItem;
    @XmlElement(required = true)
    protected String sapMaterial;
    @XmlElement(required = true)
    protected String sapOrderQuantity;
    @XmlElement(required = true)
    protected String sapOrderUnit;

    /**
     * Gets the value of the sapSalesOrder property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSapSalesOrder() {
        return sapSalesOrder;
    }

    /**
     * Sets the value of the sapSalesOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSapSalesOrder(String value) {
        this.sapSalesOrder = value;
    }

    /**
     * Gets the value of the sapSalesOrderCreationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSapSalesOrderCreationDate() {
        return sapSalesOrderCreationDate;
    }

    /**
     * Sets the value of the sapSalesOrderCreationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSapSalesOrderCreationDate(String value) {
        this.sapSalesOrderCreationDate = value;
    }

    /**
     * Gets the value of the customerSapCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerSapCode() {
        return customerSapCode;
    }

    /**
     * Sets the value of the customerSapCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerSapCode(String value) {
        this.customerSapCode = value;
    }

    /**
     * Gets the value of the customerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets the value of the customerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerName(String value) {
        this.customerName = value;
    }

    /**
     * Gets the value of the customerAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerAddress() {
        return customerAddress;
    }

    /**
     * Sets the value of the customerAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerAddress(String value) {
        this.customerAddress = value;
    }

    /**
     * Gets the value of the sapLineItem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSapLineItem() {
        return sapLineItem;
    }

    /**
     * Sets the value of the sapLineItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSapLineItem(String value) {
        this.sapLineItem = value;
    }

    /**
     * Gets the value of the sapMaterial property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSapMaterial() {
        return sapMaterial;
    }

    /**
     * Sets the value of the sapMaterial property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSapMaterial(String value) {
        this.sapMaterial = value;
    }

    /**
     * Gets the value of the sapOrderQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSapOrderQuantity() {
        return sapOrderQuantity;
    }

    /**
     * Sets the value of the sapOrderQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSapOrderQuantity(String value) {
        this.sapOrderQuantity = value;
    }

    /**
     * Gets the value of the sapOrderUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSapOrderUnit() {
        return sapOrderUnit;
    }

    /**
     * Sets the value of the sapOrderUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSapOrderUnit(String value) {
        this.sapOrderUnit = value;
    }

}
