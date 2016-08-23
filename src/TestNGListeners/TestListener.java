package TestNGListeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Factories.ReporterFactory;

public class TestListener implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		try {
			ReporterFactory.getReporter().startTest(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		try {
			ReporterFactory.getReporter().error("Following test passed");
			ReporterFactory.getReporter().stopTest(result.getTestName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			ReporterFactory.getReporter().error("This test failed");
			ReporterFactory.getReporter().stopTest(result.getTestName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	
	
}
