package com.demoqa.pageexc;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MinExe extends PageExc {
	public static void main(String[] args) throws InterruptedException, AWTException {
    launchBrowser();
	driver.get("https://www.bobcat.com/in/en/equipment/loaders/compact-track-loaders");
	windowsMax();
	waitIMP(20);
	driver.findElement(By.id("onetrust-accept-btn-handler")).click();
	JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("window.scrollBy(0,1000)");
	waitIMP(20);
    WebElement el = driver.findElement(By.xpath("(//div[@class=\"text-right small\"])[1]"));
    excelWriteValues("bobcat", 0, 0, el.getText());
    WebElement ele = driver.findElement(By.xpath("(//div[@class=\"text-right small\"])[2]"));
    excelWriteValues("bobcat", 1,0, ele.getText());
   	
  
//	
	
	
	
	
	
	
	
	
	
	
//	firstName("mohammed");
//	lastName("ammaar");
//	email("ammaar052@gmail.com");
//	waitIMP(20);
//	radio();
//	phoneNumber("8870421235");
//	JavascriptExecutor js = (JavascriptExecutor)driver;
//    js.executeScript("window.scrollBy(0,2000)");
////	Thread.sleep(2000);	
//	WebElement sub=  driver.findElement(By.id("subjectsInput"));
////	sub.click();
////	JavascriptExecutor executor = (JavascriptExecutor)driver;
////	executor.executeScript("arguments[0].click();", sub);
////	sub.click();
//	sub.sendKeys("computer science");
//	Thread.sleep(2000);
//	sub.sendKeys(Keys.ARROW_DOWN);
//	Thread.sleep(2000);
//	sub.sendKeys(Keys.ENTER);
//	Thread.sleep(2000);
//	WebElement su=  driver.findElement(By.xpath("//*[text()='Sports']"));
//	su.click();
//	su.sendKeys(Keys.ARROW_DOWN);
//	Thread.sleep(2000);
//	su.sendKeys(Keys.ENTER);
//	
//	address("no 45 ,chennai");
//	Thread.sleep(2000);	
//	WebElement s=driver.findElement(By.xpath("//*[text()='Select State']"));
//	Actions act =new Actions(driver);
//	act.contextClick(s);
//    act.perform();
//	Robot r = new Robot();
//	r.keyPress(KeyEvent.VK_DOWN);
//	r.keyRelease(KeyEvent.VK_DOWN);
//	r.keyPress(KeyEvent.VK_ENTER);
//	r.keyRelease(KeyEvent.VK_ENTER);
	
//	sub("computer science");
//	checkbox();
//	address("no 45 ,chennai");//iframe[@id="google_esf"]
	
	
}
}
