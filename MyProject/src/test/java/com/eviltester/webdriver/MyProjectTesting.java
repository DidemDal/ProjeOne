package com.eviltester.webdriver;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class MyProjectTesting {

	
	 private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  /** 
	     * site is  opened and opening of homepage is confirmed.
	     */
	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://www.n11.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testValidtest2() throws Exception {
	    driver.get(baseUrl + "/");
	    try {
	      assertEquals("n11.com - Alýþveriþin Uðurlu Adresi", driver.getTitle());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    
	    /** 
	     *The login page is opened and confirmed by clicking on the link that placed in the upper right corner of the screen. 
       User logined with e-mail and password and it is confirmed.
	     */    
	    driver.findElement(By.linkText("Giriþ Yap")).click();
	    try {
	      assertEquals("Giriþ Yap - n11.com", driver.getTitle());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("didem1614@hotmail.com");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("123456789d");
	    driver.findElement(By.id("loginButton")).click();
	    
	    /** 
	     *In the search field at the top of the screen, word "Samsung" is written and search button is clicked.
         Showing "samsung" search results by following page is confirmed.
	     */   
	    driver.findElement(By.id("searchData")).click();
	    driver.findElement(By.id("searchData")).clear();
	    driver.findElement(By.id("searchData")).sendKeys("samsung");
	    driver.findElement(By.cssSelector("span.icon.iconSearch")).click();
	    try {
	      assertEquals("Samsung - n11.com", driver.getTitle());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    
	    /** 
	     * Page 2 of the result pages is clicked on and page 2 is displayed and confirmed.
	     */
	    driver.findElement(By.linkText("2")).click();
	    try {
	      assertEquals("2", driver.findElement(By.name("currentPage")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    
	    /** 
	     * Add to Favorites" button in the 3rd product from top is clicked.
	     */
	        driver.findElement(By.cssSelector("#p-41069399 > div.pro > a.plink > img.lazy")).click();
		driver.findElement(By.id("addToFavourites")).click();
		
		/** 
	     * Account link is clicked  on the top right of the screen and opening of the account screen is confirmed.
	     */
	    driver.findElement(By.linkText("Hesabým")).click();
	    try {
	      assertEquals("Hesabým - n11.com", driver.getTitle());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    
	    /** 
	     * Ýt is confirmed that favourites page is opened after clicking favourites button which is placed at left side of screen.
         In following page,existing of product which is added in previous page is confirmed.
	     */
	    driver.findElement(By.xpath("(//a[contains(text(),'Favorilerim')])[2]")).click();
	    try {
	      assertEquals("Favorilerim - n11.com", driver.getTitle());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }

	    /** 
	     * By clicking remove button,favourite product is removed from favourites list and it is confirmed.
	     */
	    driver.findElement(By.linkText("Kaldýr")).click();
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	}


