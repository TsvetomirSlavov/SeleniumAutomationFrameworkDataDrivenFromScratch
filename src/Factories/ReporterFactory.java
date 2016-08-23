package Factories;

import java.io.IOException;

import Reporter.TextReporter;

public class ReporterFactory {
	
	private static TextReporter reporter = null;
	
	public static TextReporter getReporter() throws IOException{
		if(reporter ==null){			
				reporter = new TextReporter();			
		}		
		return reporter;
	}
	
	
	
	
	
	
	
	

}
