package com.city.connectivity.utility;

import com.city.connectivity.model.CityConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Sanjay Singh
 * @apiNote This class deals with all csv supporting apis
 *  
 */
public class CSVReaderWriterUtil {
	
	private final static Logger logger = LoggerFactory.getLogger(CSVReaderWriterUtil.class);
	
	public static List<CityConnection> readCsv(String csvPath) throws IOException {
        ICsvBeanReader beanReader = null;
        List<CityConnection> cityConnections = new ArrayList<>();
        try {
        	
            beanReader = new CsvBeanReader(new FileReader(csvPath), CsvPreference.STANDARD_PREFERENCE);

            // the header elements are used to map the values to the bean (names must match)
            final String[] header = new String[] { "origin", "destination"};
            final CellProcessor[] processors = getProcessors();

            CityConnection cityConnection;
            while ((cityConnection = beanReader.read(CityConnection.class, header, processors)) != null) {
            	cityConnections.add(cityConnection);
            }
        } finally {
            if (beanReader != null) {
                beanReader.close();
            }
        }
        
        logger.info(">>> cityConnections = {}",cityConnections);
        return cityConnections;
    }
	
 
    private static CellProcessor[] getProcessors() {
        final CellProcessor[] processors = new CellProcessor[] {
                new NotNull(), // origin
                new NotNull() // destination
        };
        return processors;
    }

}
