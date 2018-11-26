package com.mvnProject.util;

import java.io.IOException;
import java.util.Date;
import java.util.EventListener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.mvnProject.base.baseClass;

public class testListener extends baseClass implements ITestListener {

	TestUtil testUtil = new TestUtil();
	
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		String failerCaption = arg0.getName();
		//arg0.getName()
		Date dd = new Date();
		long now = dd.getTime();
		String strNow = String.valueOf(now);
		try {
			testUtil.takeScreenshot(failerCaption + strNow +  ".png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("================================================");
		System.out.println(arg0.getName());
		System.out.println("================================================");
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
}
