package com.demoqa.pageexc;

import com.demoqa.locators.LoginLocators;

public class PageExc extends LoginLocators{

	public static void firstName(String fname) {
	 sendKeys(new LoginLocators().getFname(), fname);
    }
	public static void lastName(String lname) {
		 sendKeys(new LoginLocators().getLname(), lname);
   }
	public static void email(String email) {
		 sendKeys(new LoginLocators().getEmail(), email);
	 }
	public static void radio() {
		clk(new LoginLocators().getRadio());	
	  }
	public static void phoneNumber(String phno) {
			 sendKeys(new LoginLocators().getPhno(), phno);
	   }
    public static void dob(String dob) {
			 sendKeys(new LoginLocators().getDob(), dob);
	 }
    public static void sub(String subj) {
		 sendKeys(new LoginLocators().getSubjects(), subj);
		 
	}
    public static void checkbox() {
		 clk(new LoginLocators().getCheckbox());
	}
    public static void address(String add) {
		 sendKeys(new LoginLocators().getAddress(),add);
	}
    
}
