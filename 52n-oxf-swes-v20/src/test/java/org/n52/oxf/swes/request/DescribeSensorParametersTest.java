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
package org.n52.oxf.swes.request;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.n52.oxf.swes.request.DescribeSensorParameters.*;

import org.junit.Before;
import org.junit.Test;

public class DescribeSensorParametersTest {

	private static final String SENSOR_ID = "sensorId";
	private DescribeSensorParameters parameterAssembly;

	@Before
	public void setUp() {
		parameterAssembly = new DescribeSensorParameters(SENSOR_ID, OUTPUT_FORMAT_SENSORML);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidConstructorParameters() {
		new DescribeSensorParameters(null, null);
		new DescribeSensorParameters("", null);
		new DescribeSensorParameters(null, "");
        new DescribeSensorParameters("", "");
        new DescribeSensorParameters("", "sdf");
        new DescribeSensorParameters("sdf", "");
	}

	@Test public void
	shouldApplyMandatoryParametersWithAllConstructors()
	{
		String procedure = parameterAssembly.getSingleValue(PROCEDURE_PARAMETER);
		String outputFormat = parameterAssembly.getSingleValue(OUTPUT_FORMAT_PARAMETER);

		assertEquals(SENSOR_ID, procedure);
		assertEquals(OUTPUT_FORMAT_SENSORML, outputFormat);
		assertThat(parameterAssembly.isValid(),is(true));
		
		parameterAssembly = new DescribeSensorParameters(SENSOR_ID);
		
		procedure = parameterAssembly.getSingleValue(PROCEDURE_PARAMETER);
		outputFormat = parameterAssembly.getSingleValue(OUTPUT_FORMAT_PARAMETER);
		
		assertEquals(SENSOR_ID, procedure);
		assertEquals(OUTPUT_FORMAT_SENSORML, outputFormat);
		assertThat(parameterAssembly.isValid(),is(true));
	}

}
