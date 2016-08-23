package Reporter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;//an error occured because it automatically imported it from .sql package

/**
 * This reporter logs information in a text file
 * @author ceko
 *
 */
public class TextReporter {

	private BufferedWriter buffWriter = null;
	private FileWriter fileWriter = null;
	private File logFile = null;
	
	//best way to get unique id is to get a time stamp
	public TextReporter() throws IOException{
		String fileName = (new Date()).toString().replace(" ", "").replace("/", "_").replace("-", "_").replace(":", "_") + ".txt";
		
		logFile = new File(fileName);
		logFile.createNewFile();
		fileWriter = new FileWriter(logFile);
		buffWriter = new BufferedWriter(fileWriter);
	}
	
	public void log(String logDescription) throws IOException{
		buffWriter.write(logDescription + "\n");
	}
	
	public void debug(String debugInfo) throws IOException{
		buffWriter.write(debugInfo + "\n");
	}
	
	public void warn(String warnInfo) throws IOException{
		buffWriter.write(warnInfo + "\n");
	}
	
	public void error(String errorMessage) throws IOException{
		buffWriter.write(errorMessage);
	}
	
	public void startTest(String testCaseName) throws IOException{
		buffWriter.write("++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
		buffWriter.write("+++++ Starting test " + testCaseName + "++++++++" + "\n");
		buffWriter.write("++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
	}
	
	public void stopTest(String testCaseName) throws IOException{
		buffWriter.write("++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
		buffWriter.write("+++++ Stopping test " + testCaseName + "++++++++" + "\n");
		buffWriter.write("++++++++++++++++++++++++++++++++++++++++++++++++" + "\n\n\n");
	}
	
	public void startSuite(String testSuiteName) throws IOException{
		buffWriter.write("================================================" + "\n");
		buffWriter.write("==== Starting test " + testSuiteName + "========" + "\n");
		buffWriter.write("================================================" + "\n");
	}
	
	public void stopSuite(String testSuiteName) throws IOException{
		buffWriter.write("================================================" + "\n");
		buffWriter.write("===== Stopping test " + testSuiteName + "=======" + "\n");
		buffWriter.write("================================================" + "\n\n\n");
	}
	
	public void stopLogging() throws IOException{
		buffWriter.flush();
		buffWriter.close();
		//the buffWriter also flushes and closes the fileWriter
		//fileWriter.flush();
		//fileWriter.close();		
	}
	
	
	
	
	
}
