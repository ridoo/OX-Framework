/**
 * ﻿Copyright (C) 2012-2014 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License version 2 as publishedby the Free
 * Software Foundation.
 *
 * If the program is linked with libraries which are licensed under one of the
 * following licenses, the combination of the program with the linked library is
 * not considered a "derivative work" of the program:
 *
 *     - Apache License, version 2.0
 *     - Apache Software License, version 1.0
 *     - GNU Lesser General Public License, version 3
 *     - Mozilla Public License, versions 1.0, 1.1 and 2.0
 *     - Common Development and Distribution License (CDDL), version 1.0
 *
 * Therefore the distribution of the program linked with libraries licensed under
 * the aforementioned licenses, is permitted by the copyright holders if the
 * distribution is compliant with both the GNU General Public License version 2
 * and the aforementioned licenses.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details.
 */
package org.n52.oxf.ows;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

/**
 * Represents an Exception occuring while service side execution.
 * <br/>
 * use either one of the provided exception codes or define your own ones.
 * 
 * @author <a href="mailto:foerster@52north.org">Theodor Foerster</a>
 * @author <a href="mailto:broering@52north.org">Arne Broering</a>
 */
public class OWSException extends Exception {
	
    public static final String OPERATION_NOT_SUPPORTED = "OperationNotSupported";
    public static final String MISSING_PARAMETER_VALUE = "MissingParameterValue";
    public static final String INVALID_PARAMTER_VALUE = "InvalidParameterValue";
    public static final String VERSION_NEGOTIATION_FOUND = "VersionNegotiationFound";
    public static final String INVALID_UPDATE_SEQUENCE = "InvalidUpdateSequence";
    public static final String NO_APPLICABLE_CODE = "NoApplicableCode";
    
    private String[] exceptionTexts;
    private String sentRequest;
    private String exceptionCode;
    private String locator;

    /**
     * 
     * @param exceptionTexts
     * @param exceptionCode
     * @param sentRequest
     */
	public OWSException(String[] exceptionTexts, String exceptionCode, String sentRequest) {
        super(exceptionCode);
		this.exceptionCode = exceptionCode;
		this.exceptionTexts = exceptionTexts;
        this.sentRequest = sentRequest;
	}
    
    /**
     * 
     * @param exceptionTexts
     * @param exceptionCode
     * @param sentRequest
     * @param locator
     */
    public OWSException(String[] exceptionTexts, String exceptionCode, String sentRequest, String locator) {
        super(exceptionCode);
        this.exceptionCode = exceptionCode;
        this.exceptionTexts = exceptionTexts;
        this.sentRequest = sentRequest;
        this.locator = locator;
    }
    
    /**
     * 
     */
    @Override
    public void printStackTrace(PrintStream s) {
        s.println("");
        s.println("Exception: " + exceptionCode);
        s.println("Locator: " + locator);
        
        for(String excTxt : exceptionTexts) {
            s.println("Exception text: " + excTxt);
        }
        
        s.println("Sent request was:");
        s.println(sentRequest);
        
        super.printStackTrace(s);
    }
    
    /**
     * @return a HTML representation of this OWSException
     */
    public String toHtmlString() {
        String res = "";
        res += "<b>Exception:</b> " + exceptionCode + "<br>";
        res += "<b>Locator:</b> " + locator + "<br>";
        
        for(String excTxt : exceptionTexts) {
            res += "<b>Exception text:</b> " + excTxt + "<br>";
        }
        
        res += "<b>Sendt request was:</b>" + "<br>";
        res += "<code>" + replaceTagBrackets(sentRequest) + "</code>";
        
        return res;
    }
    
    /**
     * replaces the '<' and '>' characters in a String through '&lt;' and '&gt;'.
     */
    private String replaceTagBrackets (String xmlString) {
        String res = xmlString.replaceAll("<", "&lt;");
        res = res.replaceAll(">", "&gt;");
        
        return res;
    }
    
	/**
	 * @return Returns the exceptionCode.
	 */
	public String getExceptionCode() {
		return exceptionCode;
	}

	/**
	 * @return Returns the exceptionTexts.
	 */
	public String[] getExceptionTexts() {
		return exceptionTexts;
	}

	public String getSentRequest() {
        return sentRequest;
    }

    /**
	 * indicates in which part the exception occured. This is optional!
	 * @return Returns the locator.
	 */
	public String getLocator() {
		return locator;
	}

	/**
	 * indicates in which part the exception occured. This is optional!
	 * @param locator The locator to set.
	 */
	public void setLocator(String locator) {
		this.locator = locator;
	}
}