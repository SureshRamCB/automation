package com.orangehrm.utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.orangehrm.testData.Data;

public class EventMethods {


	public static  WebElement waitForElement(By locater,int timeouts) {

		WebElement element;
		try {
			WebDriverWait wait=new WebDriverWait(Data.driver, timeouts);
			element=wait.until(ExpectedConditions.presenceOfElementLocated(locater));
			wait.pollingEvery(Duration.ofMillis(200));
		} catch (Exception e) {
			element=null;
			System.out.println("Element "+element+ "  element could not"
					+ " located with this locator "+locater+"even wait for "+timeouts);
		}
		return element;
	}

	public static WebElement waitforElement_to_enable(By locator, int timeOut) {
		WebElement element;
		try {
			WebDriverWait wait = new WebDriverWait(Data.driver, timeOut);
			element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			wait.pollingEvery(Duration.ofMillis(200));
		} catch (Exception e) {
			element = null;
			System.out.println("element could not be located with locator: '" + locator.toString()
			+ "' even after waiting for :" + timeOut + " seconds.");
		}

		return element;

	}

	public static boolean waitforElement_to_enable(WebElement element, int timeOut) {
		boolean isElementEnabled;
		try {
			WebDriverWait wait = new WebDriverWait(Data.driver, timeOut);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			wait.pollingEvery(Duration.ofMillis(200));
			isElementEnabled = true;
		} catch (Exception e) {
			isElementEnabled = false;
			System.out.println("element " + element.toString() + "' is not enabled even after waiting for :" + timeOut
					+ " seconds.");
		}

		return isElementEnabled;

	}

	public static boolean waitforElement_to_visible(WebElement element, int timeOut) {
		boolean isElementEnabled;
		try {
			WebDriverWait wait = new WebDriverWait(Data.driver, timeOut);
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.pollingEvery(Duration.ofMillis(200));
			isElementEnabled = true;
		} catch (Exception e) {
			isElementEnabled = false;
			System.out.println("element " + element.toString() + "' is not enabled even after waiting for :" + timeOut
					+ " seconds.");
		}

		return isElementEnabled;

	}

	public static WebElement waitforElement_to_visible(By by, int timeOut) {
		WebElement element;
		try {
			WebDriverWait wait = new WebDriverWait(Data.driver, timeOut);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			wait.pollingEvery(Duration.ofMillis(200));

		} catch (Exception e) {
			element = null;
			System.out.println(
					"element " + by.toString() + "' is not enabled even after waiting for :" + timeOut + " seconds.");
		}

		return element;

	}

	public static boolean check_element_exists(By by, int timeOut) {
		boolean isElementExists;
		if (waitForElement(by, timeOut) != null) {
			isElementExists = true;
		} else {
			isElementExists = false;
		}

		return isElementExists;
	}

	public static void enterValue(By by, String input) {
		Data.logger.info("Entering the value : " + input + " into the object : " + by.toString());
		WebElement element = waitForElement(by, 20);
		if (element == null) {
			Assert.assertFalse(true, "No element is found with locator:" + by.toString());
		} else {
			if (waitforElement_to_visible(element, 20)) {
				if (waitforElement_to_enable(element, 10)) {
					element.clear();
					element.sendKeys(input);
				} else {
					Assert.assertTrue(false,
							"Element : " + by.toString() + " is not enaled even after waiting for 20 secconds.");
				}
			} else {
				Assert.assertTrue(false,
						"Element : " + by.toString() + " is not visible even after waiting for 20 secconds.");
			}
		}
	}

	public static void appendValue_in_textField(By by, String input) {
		WebElement element = waitForElement(by, 20);
		if (element == null) {
			Assert.assertFalse(true, "No element is found with locator:" + by.toString());
		} else {
			if (waitforElement_to_visible(element, 20)) {
				if (waitforElement_to_enable(element, 10)) {
					element.sendKeys(input);
				} else {
					Assert.assertTrue(false,
							"Element : " + by.toString() + " is not enaled even after waiting for 20 secconds.");
				}
			} else {
				Assert.assertTrue(false,
						"Element : " + by.toString() + " is not visible even after waiting for 20 secconds.");
			}
		}
	}



	public static void selectValueFromList(By by, String valueToSelect) {
		WebElement listBox = waitForElement(by, 20);
		if (listBox != null) {
			if (waitforElement_to_visible(listBox, 20)) {
				if (waitforElement_to_enable(listBox, 20)) {

					List<WebElement> allOptions = listBox.findElements(By.tagName("Option"));
					boolean isOptionFound = false;
					for (WebElement opt : allOptions) {
						if (opt.getText().equalsIgnoreCase(valueToSelect)) {
							opt.click();
							isOptionFound = true;
							break;
						}
					}

					if (!isOptionFound) {
						System.out.println(
								"Value : " + valueToSelect + " could not be found in the list " + by.toString());
						Assert.assertTrue(false,
								"Value : " + valueToSelect + " could not be found in the list " + by.toString());
					}

				} else {
					System.out.println("Lisbox : " + by.toString() + " is disabled..Hence, the value : " + valueToSelect
							+ " could not be selected.");
					Assert.assertTrue(false,
							"value : " + valueToSelect + " could not be selected as listbox is disabled.");
				}

			} else {
				System.out.println("Lisbox : " + by.toString() + " is not visible.Hence, the value : " + valueToSelect
						+ " could not be selected.");
				Assert.assertTrue(false,
						"value : " + valueToSelect + " could not be selected as listbox is not visible.");
			}

		} else {
			System.out.println("Lisbox : " + by.toString() + " could not be found.Hence, the value : " + valueToSelect
					+ " could not be selected.");
			Assert.assertTrue(false, "value : " + valueToSelect + " could not be selected as listbox is not found.");
		}
	}

	public static void selectValueFromList(WebElement listBox, String valueToSelect) {

		if (waitforElement_to_visible(listBox, 20)) {
			if (waitforElement_to_enable(listBox, 20)) {
				List<WebElement> allOptions = listBox.findElements(By.tagName("Option"));
				boolean isOptionFound = false;
				for (WebElement opt : allOptions) {
					if (opt.getText().equalsIgnoreCase(valueToSelect)) {
						opt.click();
						isOptionFound = true;
						break;
					}
				}

				if (!isOptionFound) {
					System.out.println(
							"Value : " + valueToSelect + " could not be found in the list " + listBox.toString());
					Assert.assertTrue(false,
							"Value : " + valueToSelect + " could not be found in the list " + listBox.toString());
				}

			} else {
				System.out.println("Lisbox : " + listBox.toString() + " is disabled..Hence, the value : "
						+ valueToSelect + " could not be selected.");
				Assert.assertTrue(false, "value : " + valueToSelect + " could not be selected as listbox is disabled.");
			}

		} else {
			System.out.println("Lisbox : " + listBox.toString() + " is not visible.Hence, the value : " + valueToSelect
					+ " could not be selected.");
			Assert.assertTrue(false, "value : " + valueToSelect + " could not be selected as listbox is not visible.");
		}
	}

	public static void clickButton(By by) {
		WebElement element = waitForElement(by, 20);
		if (element == null) {
			Assert.assertFalse(true, "No element is found with locator:" + by.toString());
		} else {
			if (waitforElement_to_visible(element, 20)) {
				if (waitforElement_to_enable(element, 10)) {
					element.click();
				} else {
					Assert.assertTrue(false,
							"Element : " + by.toString() + " is not enaled even after waiting for 20 secconds.");
				}
			} else {
				Assert.assertTrue(false,
						"Element : " + by.toString() + " is not visible even after waiting for 20 secconds.");
			}
		}
	}

	public static void clickLink(By by) {
		WebElement element = waitForElement(by, 20);
		if (element == null) {
			Assert.assertFalse(true, "No element is found with locator:" + by.toString());
		} else {
			if (waitforElement_to_visible(element, 20)) {
				element.click();
			} else {
				Assert.assertTrue(false,
						"Element : " + by.toString() + " is not visible even after waiting for 20 secconds.");
			}
		}
	}


}
