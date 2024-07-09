package com.juan.automation.stepdefinitions;

import static org.junit.Assert.assertEquals;

import com.juan.automation.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InitTestStepDefinitions {

	HomePage homePage;

	@Given("I want to open a calculator page")
	public void iWantToOpenACalculatorPage() {
		homePage.navigateTo();
	}

	@When("The build is {int} adding numbers {int} and {int}")
	public void theBuildIsAddingNumbersAnd(Integer buildType, Integer number1, Integer number2) {
		homePage.selectBuild(buildType);
		homePage.writeFirstNumber(number1);
		homePage.writeSecondNumber(number2);
		homePage.selectAddOperation();
		homePage.calculateOperation();
	}

	@Then("Check a response is {int}")
	public void checkAResponseIs(Integer int1) {
		assertEquals("Excpected value is different to value calculated", homePage.getResult().toString(),
				homePage.getResultPage());
	}

}
  