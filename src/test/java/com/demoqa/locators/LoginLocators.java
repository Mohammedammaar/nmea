package com.demoqa.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoqa.baseclass.BaseClass;

public class LoginLocators extends BaseClass{
	public LoginLocators()
	{
		 PageFactory.initElements(driver, this);
	}
	@FindBy(id="firstName")
	private WebElement fname;
	@FindBy(id="lastName")
	private WebElement lname;
	@FindBy(id="userEmail")
	private WebElement email;
	@FindBy(xpath="//*[text()='Male']")
	private WebElement radio;
	@FindBy(id="userNumber")
	private WebElement phno;
	@FindBy(id="dateOfBirthInput")
	private WebElement dob;
	@FindBy(xpath="//div[@id=\"subjectsContainer\"]")
	private WebElement subjects;
	@FindBy(id="hobbies-checkbox-1")
	private WebElement checkbox;
	@FindBy(id="currentAddress")
	private WebElement address;
	
	public WebElement getFname() {
		return fname;
	}
	public WebElement getLname() {
		return lname;
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getRadio() {
		return radio;
	}
	public WebElement getPhno() {
		return phno;
	}
	public WebElement getDob() {
		return dob;
	}
	public WebElement getSubjects() {
		return subjects;
	}
	public WebElement getCheckbox() {
		return checkbox;
	}
	public WebElement getAddress() {
		return address;
	}
	
	
	
}
