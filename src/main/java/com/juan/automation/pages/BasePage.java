package com.juan.automation.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.juan.automation.utils.Utils;

import net.serenitybdd.core.pages.PageObject;

public class BasePage extends PageObject {

	public void navegateToUrl(String url) {
		getDriver().navigate().to(url);
	}

	public void writeEditText(By editText, String strEditText) {
		clickInObject(editText);
		WebElement tempWebElement = getDriver().findElement(editText);
		tempWebElement.sendKeys(strEditText);
	}

	public void clickInObject(By objectToClick) {
		clickInObject(getDriver().findElement(objectToClick));
	}

	public void clickInObject(WebElement objectToClick) {
		WebDriverWait waitElem = new WebDriverWait(getDriver(), 5);
		waitElem.until(ExpectedConditions.elementToBeClickable(objectToClick));
		objectToClick.click();
	}

	public String getTextFrom(By locator) {
		return getDriver().findElement(locator).getText();
	}

	public WebElement findElement(By locator) {
		return getDriver().findElement(locator);
	}

	public List<WebElement> findElements(By locator) {
		return getDriver().findElements(locator);
	}

	public void scrollDown(WebDriver myBrowser) {
		JavascriptExecutor js = (JavascriptExecutor) myBrowser;
		float delta = 1F;
		for (float i = delta; i <= 100; i += delta) {
			js.executeScript("window.scrollTo(" + (i - delta) / 100.0 + "*document.body.scrollHeight, " + i / 100.0
					+ "*document.body.scrollHeight);");
		}
	}

	public void waitForElementVisibility(By objectWait, Integer seconds) {
		WebDriverWait waitElem = new WebDriverWait(getDriver(), seconds);
		waitElem.until(ExpectedConditions.visibilityOfElementLocated(objectWait));
	}

	public void waitForElementInvisivility(By objectWait, Integer seconds) {
		WebDriverWait waitElem = new WebDriverWait(getDriver(), seconds);
		waitElem.until(ExpectedConditions.invisibilityOf(findElement(objectWait)));
	}

	public void waitForAllElement(WebDriver driver, List<WebElement> listElements, Integer seconds) {
		WebDriverWait waitElem = new WebDriverWait(driver, seconds);
		waitElem.until(ExpectedConditions.visibilityOfAllElements(listElements));
	}

	public void confirmAlert(WebDriver myBrowser) {
		WebDriverWait wait = new WebDriverWait(myBrowser, 10);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
	}

	public Integer toInt(String txtNum, String separator) {
		return Integer.parseInt(txtNum.replaceAll(separator, ""));
	}

	public void waitForPageToLoad() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		wait.until(webDriver -> js.executeScript("return document.readyState").equals("complete"));
	}

	public Integer sumList(ArrayList<Integer> listNums) {
		Integer sum = 0;
		for (Integer elem : listNums)
			sum += elem;
		return sum;
	}

	public void selectRandomItem(WebDriver driver, By itemsClass) {
		try {
			// I don-t want to use Thread.sleep
			Thread.sleep(1000);
			List<WebElement> listItems = findElements(itemsClass);
			Integer randomIndex = Utils.getRandomNumber(listItems.size());
			clickInObject(listItems.get(randomIndex));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void selectDropdown(By selectLocator, By optionLocator, Integer value) {
		clickInObject(selectLocator);
		WebElement option = findElement(optionLocator);
		clickInObject(option);
	}

	public Boolean editTextIsEmpty(WebDriver driver, By editText) {
		String strText = findElement(editText).getAttribute("value");
		return strText.isEmpty();
	}

}
