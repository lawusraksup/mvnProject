package com.mvnProject.testdata;

import org.testng.annotations.DataProvider;

import com.mvnProject.base.baseClass;
import com.mvnProject.util.ExcelUtils;
import com.mvnProject.util.TestUtil;

public class NewContactTestData extends baseClass {

	static TestUtil testUtil = new TestUtil();
	
	//@DataProvider(name = "credentials")
	/*
	public static Object[][] dataprovidermethod(){
		return new Object[][]{
			{"abc","123"},
			{"def","456"},
			{"xyz","789"}
		};
		
		
	}*/
	
	@DataProvider(name = "credentials")
	public Object[][] Authentication() throws Exception{

	     Object[][] testObjArray = ExcelUtils.getTableArray(testUtil.TESTDATA_SHEET_PATH,"contact");

	     return (testObjArray);

		}
	
	
}
