package com.city.connectivity.utility;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.city.connectivity.model.CityConnection;

/**
 * 
 * @author Sanjay Singh
 * @apiNote This class deals with test cases for class - CSVReaderWriterUtil
 *
 */

public class CSVReaderWriterUtilTests {
	
	private String fileName;

	@Before
	public void setUp() throws Exception {
		// Assumption that the file is stored at below location
		fileName = "src/test/resources/city.csv"; 
	}
	
	@Test
    public void testReadCsv() throws Exception {
		System.out.println(">>> testing ReadCsv.");
		List<CityConnection> cityConnections = CSVReaderWriterUtil.readCsv(fileName);
		assertThat(cityConnections).isNotEmpty().hasSize(4);
		assertEquals("Boston", cityConnections.get(0).getOrigin());
		assertEquals("New York", cityConnections.get(0).getDestination());
    }

}
