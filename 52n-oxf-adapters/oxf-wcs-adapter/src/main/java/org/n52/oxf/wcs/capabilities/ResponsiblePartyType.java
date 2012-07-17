/**
 * ﻿Copyright (C) 2012
 * by 52 North Initiative for Geospatial Open Source Software GmbH
 *
 * Contact: Andreas Wytzisk
 * 52 North Initiative for Geospatial Open Source Software GmbH
 * Martin-Luther-King-Weg 24
 * 48155 Muenster, Germany
 * info@52north.org
 *
 * This program is free software; you can redistribute and/or modify it under
 * the terms of the GNU General Public License version 2 as published by the
 * Free Software Foundation.
 *
 * This program is distributed WITHOUT ANY WARRANTY; even without the implied
 * WARRANTY OF MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program (see gnu-gpl v2.txt). If not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA or
 * visit the Free Software Foundation web page, http://www.fsf.org.
 */
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b11-EA 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2005.06.25 at 02:38:11 CEST 
//


package org.n52.oxf.wcs.capabilities;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlType(name = "ResponsiblePartyType", namespace = "http://www.opengis.net/wcs")
public class ResponsiblePartyType {

    @XmlElementRefs(value = {
        @XmlElementRef(name = "contactInfo", namespace = "http://www.opengis.net/wcs", type = JAXBElement.class),
        @XmlElementRef(name = "individualName", namespace = "http://www.opengis.net/wcs", type = JAXBElement.class),
        @XmlElementRef(name = "positionName", namespace = "http://www.opengis.net/wcs", type = JAXBElement.class),
        @XmlElementRef(name = "organisationName", namespace = "http://www.opengis.net/wcs", type = JAXBElement.class)
    })
    protected List<JAXBElement> content;

    protected List<JAXBElement> _getContent() {
        if (content == null) {
            content = new ArrayList<JAXBElement>();
        }
        return content;
    }

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "OrganisationName" is used by two different parts of a schema. See: 
     * line 151 of file:/D:/Eigene%20Dateien/_Job/oxf_wcsAdapter/xml/wcs_schema_1.0.0/wcsCapabilities.xsd
     * line 149 of file:/D:/Eigene%20Dateien/_Job/oxf_wcsAdapter/xml/wcs_schema_1.0.0/wcsCapabilities.xsd
     * <p>
     * To get rid of this property, apply a property customization to one 
     * of both of the following declarations to change their names: 
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link javax.xml.bind.JAXBElement<java.lang.String>}
     * {@link javax.xml.bind.JAXBElement<org.n52.oxf.wcsModel.version100.wcsCapabilities.ContactType>}
     * {@link javax.xml.bind.JAXBElement<java.lang.String>}
     * {@link javax.xml.bind.JAXBElement<java.lang.String>}
     * 
     */
    public List<JAXBElement> getContent() {
        return this._getContent();
    }

}