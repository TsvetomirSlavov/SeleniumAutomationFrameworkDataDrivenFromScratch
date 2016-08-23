package TestNGListeners;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import Factories.ReporterFactory;

public class SuiteListener implements ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		try {
			ReporterFactory.getReporter().startSuite(suite.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onFinish(ISuite suite) {
		try {
			ReporterFactory.getReporter().stopSuite(suite.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
}
