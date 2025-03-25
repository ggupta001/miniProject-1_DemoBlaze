package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.SignUpPage;

public class TS001_SignUpTest extends ProjectSpecificMethod {
	
	public TS001_SignUpTest() throws IOException {
		super();
	}


	SignUpPage signup;
	String userName=configProperties.getProperty("userName");
	String password=configProperties.getProperty("password");
	

	@Test
	public void SignUpToDemoblaze() throws IOException, InterruptedException {
		Thread.sleep(2000);
		signup=new SignUpPage(driver);
		signup.signUp(userName, password);		
	}

}
