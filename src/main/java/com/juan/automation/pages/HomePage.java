package com.juan.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	protected final String PRINCIPAL_URL = "https://testsheepnz.github.io/BasicCalculator.html";
	private final By buildSelect = By.xpath("//select[@id='selectBuild']");
	private final String buildValue = "//select[@id='selectBuild']//option[@value=%s]";
	private final By editTextNumber1 = By.xpath("//input[@id='number1Field']");
	private final By editTextNumber2 = By.xpath("//input[@id='number2Field']");
	private final By selectOperation = By.xpath("//select[@id='selectOperationDropdown']");
	private final String operationValue = "//select[@id='selectOperationDropdown']//option[@value=%s]";
	private final By buttonCalculate = By.id("calculateButton");
	private final By textResult = By.id("numberAnswerField");
	private final By formCalculateResult = By.id("calculatingForm");
	// Data Page:
	private Integer number1;
	private Integer number2;
	private Integer result;

	public Integer getNumber1() {
		return number1;
	}

	public void setNumber1(Integer number1) {
		this.number1 = number1;
	}

	public Integer getNumber2() {
		return number2;
	}

	public void setNumber2(Integer number2) {
		this.number2 = number2;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	// Interact methods of Page

	public void navigateTo() {
		navegateToUrl(PRINCIPAL_URL);
		waitForPageToLoad();
	}

	public void selectBuild(Integer buildType) {
		selectDropdown(buildSelect, By.xpath(String.format(buildValue, buildType.toString())), buildType);
	}

	public void selectAddOperation() {
		selectOperation(0);
		setResult(getNumber1() + getNumber2());
	}

	public void selectSubtractOperation() {
		selectOperation(1);
		setResult(getNumber1() - getNumber2());
	}

	public void selectMultiplyOperation() {
		selectOperation(2);
		setResult(getNumber1() * getNumber2());
	}

	public void selectDivideOperation() {
		selectOperation(3);
		try {
			setResult(getNumber1() / getNumber2());
		} catch (ArithmeticException e) {
			setResult(-1);
			System.out.println("Number 2 is Cero!");
		}
	}

	public void selectConcatenateOperation() {
		selectOperation(4);
		String tempResult = getNumber1().toString() + getNumber2().toString();
		setResult(Integer.valueOf(tempResult));
	}

	public void calculateOperation() {
		Boolean condition = !editTextIsEmpty(getDriver(), editTextNumber1)
				&& !editTextIsEmpty(getDriver(), editTextNumber2);

		WebElement formCalculated = findElement(formCalculateResult);

		if (condition && !formCalculated.isDisplayed()) {
			clickInObject(buttonCalculate);
			waitForElementVisibility(textResult, 10);
		}

	}

	public void writeFirstNumber(Integer number) {
		writeNumber(editTextNumber1, number.toString());
		setNumber1(number);
	}

	public void writeSecondNumber(Integer number) {
		writeNumber(editTextNumber2, number.toString());
		setNumber2(number);
	}

	public String getResultPage() {
		// This a method for input texts
		return findElement(textResult).getAttribute("value");
	}

	private void selectOperation(Integer operationType) {
		selectDropdown(selectOperation, By.xpath(String.format(operationValue, operationType.toString())),
				operationType);
	}

	private void writeNumber(By editTexNumber, String value) {
		writeEditText(editTexNumber, value);
	}

}
