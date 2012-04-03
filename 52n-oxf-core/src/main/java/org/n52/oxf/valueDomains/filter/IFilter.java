/**********************************************************************************
 Copyright (C) 2009
 by 52 North Initiative for Geospatial Open Source Software GmbH

 Contact: Andreas Wytzisk 
 52 North Initiative for Geospatial Open Source Software GmbH
 Martin-Luther-King-Weg 24
 48155 Muenster, Germany
 info@52north.org

 This program is free software; you can redistribute and/or modify it under the
 terms of the GNU General Public License version 2 as published by the Free
 Software Foundation.

 This program is distributed WITHOUT ANY WARRANTY; even without the implied
 WARRANTY OF MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 General Public License for more details.

 You should have received a copy of the GNU General Public License along with this 
 program (see gnu-gplv2.txt). If not, write to the Free Software Foundation, Inc., 
 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA or visit the Free Software
 Foundation web page, http://www.fsf.org.
 
 Created on: 21.06.2005
 *********************************************************************************/

package org.n52.oxf.valueDomains.filter;

/**
 * This interface encapsulates the behaviour of an Filter which is conform to the OGC Filter Encoding
 * Specification 1.1.0
 * 
 * @author <a href="mailto:staschc@52north.org">Christoph Stasch</a>
 * 
 */
public interface IFilter {

    // LogicFilters
    public static final String AND = "And";
    public static final String OR = "Or";
    public static final String NOT = "Not";

    /**
     * enum represents the possible logical comparison operators as defined in OGC Filter Schema
     * 
     * @author Christoph Stasch
     * 
     * @version 0.1
     */
    public enum ComparisonOperators {
        PropertyIsEqualTo, PropertyIsNotEqualTo, PropertyIsLessThan, PropertyIsGreaterThan, PropertyIsLessThanOrEqualTo, PropertyIsGreaterThanOrEqualTo, PropertyIsLike, PropertyIsNull, PropertyIsBetween
    }

    /**
     * returns the type of filter (e.g. PROPERTY_IS_EQUAL_TO)
     * 
     * @return
     */
    public String getFilterType();

    /**
     * creates a string representation of the filter in xml-format
     * 
     * @return filter as xml-string
     */
    public String toXML();

}