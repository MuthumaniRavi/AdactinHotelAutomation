package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Muthumani
 * @Description to maintain all the reusable methods
 * @created Date 06/29/2022
 *
 */

public class BaseLib {
	public static WebDriver driver;
	public static Workbook workbook;

	/**
	 * 
	 * @param browser
	 * @param url
	 * @Description Load the particular browser and pass the URL Link
	 * @created Date 06/29/2022
	 */
	public static void browse(String browser, String url) {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(url);
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(url);
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(url);
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			driver.get(url);
			break;
//		case "opera":
//			WebDriverManager.operadriver().setup();
//			driver = new OperaDriver();
//			driver.get(url);
//			break;
		case "safari":
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			driver.get(url);
			break;

		default:
			System.out.println("enter valid browser and url");
			break;
		}
	}

	/**
	 * 
	 * @param element
	 * @Description To clear the data present on WebElement
	 * @created Date 06/29/2022
	 */
	public void clear(WebElement element) {
		element.clear();
	}

	/**
	 * 
	 * @param key
	 * @return String
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @Description To read the datas from the property file
	 * @created Date 06/29/2022
	 */

	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(System.getProperty("user.dir") + "//config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;
	}

	/**
	 * 
	 * @return String
	 * @Description To get the title from the webpage
	 * @created Date 06/29/2022
	 */
	public static String webTitle() {
		String title = driver.getTitle();
		System.out.println(title);
		return title;
	}

	/**
	 * @return String
	 * @Description To get the current URL from the webpage
	 * @created Date 06/29/2022
	 */

	public static String webUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(driver.getCurrentUrl());
		return currentUrl;
	}

	/**
	 * 
	 * @param id
	 * @return WebElement
	 * @Description To find the web element by using Id
	 * @created Date 06/29/2022
	 * 
	 */
	public static WebElement findElementById(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;
	}

	/**
	 * 
	 * @param id
	 * @return WebElement
	 * @Description To find the web element by using name
	 * @created Date 06/29/2022
	 * 
	 */
	public static WebElement findElementByName(String name) {
		WebElement element = driver.findElement(By.id(name));
		return element;
	}

	/**
	 * 
	 * @param id
	 * @return WebElement
	 * @Description To find the web element by using classname
	 * @created Date 06/29/2022
	 * 
	 */

	public static WebElement findElementByClass(String className) {
		WebElement element = driver.findElement(By.className(className));
		return element;
	}

	/**
	 * 
	 * @param id
	 * @return WebElement
	 * @Description To find the web element by using xpath
	 * @created Date 06/29/2022
	 * 
	 */

	public static WebElement findElementByXpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}

	/**
	 * 
	 * @param element
	 * @param data
	 * @Description To send the data to the web elements
	 * @created Date 06/29/2022
	 */

	public static void sendData(WebElement element, String data) {
		element.sendKeys(data);
	}

	/**
	 * 
	 * @param element
	 * @Description To click the web element
	 * @created Date 06/29/2022
	 * 
	 */

	public static void click(WebElement element) {
		element.click();
	}

	/**
	 * 
	 * @param element
	 * @return String
	 * @Description To get the text from the web element
	 * @created Date 06/29/2022
	 */

	public static String getText(WebElement element) {
		String text = element.getText();
		System.out.println(text);
		return text;
	}

	/**
	 * 
	 * @param element
	 * @return String
	 * @Description To get attribute from the web element
	 * @created Date 06/29/2022
	 */

	public static String getAttribute(WebElement element) {
		String text = element.getAttribute("value");
		System.out.println(text);
		return text;
	}

	/**
	 * 
	 * @param element
	 * @param value
	 * @return String
	 * @Description To get the particular attribute value form the webelement
	 * @created Date 06/29/2022
	 */
	public static String getAttribute(WebElement element, String value) {
		String text = element.getAttribute(value);
		System.out.println(text);
		return text;
	}

	/**
	 * 
	 * @param element
	 * @Description To perform the mouse hover action on the web element
	 * @created Date 06/29/2022
	 */
	public static void mouseOverAction(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	/**
	 * 
	 * @param element
	 * @Description perform right click action on the web element
	 * @created Date 06/29/2022
	 */
	public static void rightClickPage(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	/**
	 * 
	 * @param element
	 * @param data
	 * @Description To send the data for the web element by using Actions class
	 * @created Date 06/29/2022
	 */

	public static void sendDataByActions(WebElement element, String data) {
		Actions actions = new Actions(driver);
		actions.sendKeys(data);
	}

	/**
	 * @Description To accept the alert on webpage
	 * @created Date 06/29/2022
	 */
	public static void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	/**
	 * @Description To dismiss accept the alert on webpage
	 * @created Date 06/29/2022
	 */
	public static void dismissAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	/**
	 * 
	 * @param data
	 * @Description To send the data to the alert on webpage
	 * @created Date 06/29/2022
	 */
	public static void typeAlert(String data) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(data);
	}

	/**
	 * 
	 * @param element
	 * @param data
	 * @Description To pass the data by using JS on webpage
	 * @created Date 06/29/2022
	 */

	public static void typeByJs(WebElement element, String data) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].setAttribute('value','" + data + "')", element);
	}

	/**
	 * 
	 * @param element
	 * @return
	 * @Description To get the attribute value of webelement by using JS
	 * @created Date 06/29/2022
	 */

	public static String getAttributeByJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Object value = executor.executeScript("argument[0].getAttribute('value')", element);
		return (String) value;
	}

	/**
	 * 
	 * @param element
	 * @Description to perform click event by using JS
	 * @created Date 06/29/2022
	 */
	public static void clickByJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].click()", element);
	}

	/**
	 * 
	 * @param element
	 * @Description To perofrm scrroll up event on WebPage by using Js
	 * @created Date 06/29/2022
	 */
	public static void scrollUp(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].scrollIntoView(true)", element);
	}

	/**
	 * 
	 * @param element
	 * @Description To perform scrroll down event on WebPage by using Js
	 * @created Date 06/29/2022
	 */
	public static void scrollDown(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].scrollIntoView(false)", element);
	}

	/**
	 * 
	 * @param element
	 * @param i
	 * @Description To select the options from the dropdown by using index
	 * @created Date 06/29/2022
	 */
	// To select the value form the dropdown on webpage based on Index
	public static void selectByIndex(WebElement element, int i) {
		Select select = new Select(element);
		select.selectByIndex(i);
	}

	/**
	 * 
	 * @param element
	 * @param value
	 * @Description To select the options from the dropdown by using value
	 * @created Date 06/29/2022
	 */
	public static void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * 
	 * @param element
	 * @param text
	 * @Description To select the options from the dropdown by using visible text
	 * @created Date 06/29/2022
	 */
	public static void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/**
	 * 
	 * @param element
	 * @param i
	 * @Description Deselect the selected option from the options by using index
	 * @created Date 06/29/2022
	 */
	public static void deselectByIndex(WebElement element, int i) {
		Select select = new Select(element);
		select.deselectByIndex(i);
	}

	/**
	 * 
	 * @param element
	 * @return List<WebElement>
	 * @Description To get the all options present in the dropdown
	 * @created Date 06/29/2022
	 */
	public static List<WebElement> getOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		return options;
	}

	/**
	 * 
	 * @param element
	 * @return
	 * @Description To get the total options present in the dropdown
	 * @created Date 06/29/2022
	 */
	public static int optionsCount(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		int size = options.size();
		return size;
	}

	/**
	 * 
	 * @param element
	 * @return List<WebElement>
	 * @Description To get the all selected option from the dropdown
	 * @created Date 06/29/2022
	 */
	public static List<WebElement> getAllSelectedOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		return allSelectedOptions;
	}

	/**
	 * 
	 * @param element
	 * @return
	 * @Description To get the first selected option in the dropdown
	 * @created Date 06/29/2022
	 */
	public static WebElement gettFirstSelectedOption(WebElement element) {
		Select select = new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		return firstSelectedOption;
	}

	/**
	 * 
	 * @param element
	 * @return boolean
	 * @Description To check the its multi selector
	 * @created Date 06/29/2022
	 */
	public static boolean isMultiSelector(WebElement element) {
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}

	/**
	 * 
	 * @param element
	 * @Description To deselect the selected element
	 * @created Date 06/29/2022
	 */
	public static void deselectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}

	/**
	 * 
	 * @param i
	 * @Description To switch to frame by using index
	 * @created Date 06/29/2022
	 */
	public static void switchToFrameByIndex(int i) {
		driver.switchTo().frame(i);
	}

	/**
	 * 
	 * @param nameOrId
	 * @Description To switch the frame by Id
	 * @created Date 06/29/2022
	 */
	public static void switchToFrameById(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	/**
	 * 
	 * @param frameElement
	 * @Description To switch the parent window
	 * @created Date 06/29/2022
	 */
	public static void switchToFrameByElement(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	/**
	 * @Description to switch to the parent window
	 * @created Date 06/29/2022
	 */
	public static void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}

	/**
	 * @Description to switch the default page(Home page)
	 * @created Date 06/29/2022
	 */
	public static void switchToDefaultPage() {
		driver.switchTo().defaultContent();
	}

	/**
	 * 
	 * @return File
	 * @throws IOException
	 * @Description to take the screenshot for the particular element
	 * @created Date 06/29/2022
	 */
	public static File takesScreenshot() throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		return screenshotAs;
	}

	/**
	 * 
	 * @param path
	 * @throws IOException
	 * @Description to relocate the screenshot taken by the driver
	 * @created Date 06/29/2022
	 */
	public static void takesScreenshot(String path) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		File file = new File(path);
		FileUtils.copyFile(screenshotAs, file);
	}

	/**
	 * 
	 * @param element
	 * @return File
	 * @Description To take a screenshot as a file format
	 * @created Date 06/29/2022
	 */
	public static File takesElementScreenshot(WebElement element) {
		File screenshotAs = element.getScreenshotAs(OutputType.FILE);
		return screenshotAs;
	}

	/**
	 * 
	 * @param element
	 * @param path
	 * @throws IOException
	 * @Description To takes a screenshot as a file format
	 * @created Date 06/29/2022
	 */
	public static void takesElementScreenshot(WebElement element, String path) throws IOException {
		File screenshotAs = element.getScreenshotAs(OutputType.FILE);
		File file = new File(path);
		FileUtils.copyFile(screenshotAs, file);
	}

	/**
	 * 
	 * @param url
	 * @Description To navigate the page respective url
	 * @created Date 06/29/2022
	 */
	public static void navigateToUrl(String url) {
		driver.navigate().to(url);
	}

	/**
	 * @Description to navigate the page back
	 * @created Date 06/29/2022
	 */
	public static void navigateBack() {
		driver.navigate().back();
	}

	/**
	 * @Description To navigate the page forward
	 * @created Date 06/29/2022
	 */
	public static void navigateForward() {
		driver.navigate().forward();
	}

	/**
	 * @Description To refresh the page
	 * @created Date 06/29/2022
	 */
	public static void refreshPage() {
		driver.navigate().refresh();
	}

	/**
	 * 
	 * @return String
	 * @Description to get the parent window Id
	 * @created Date 06/29/2022
	 */
	public static String parentWindowId() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	/**
	 * 
	 * @return Set<String>
	 * @Description To get the all windows Id
	 * @created Date 06/29/2022
	 */
	public static Set<String> allwindowIds() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}

	/**
	 * 
	 * @param nameOrHandle
	 * @Description to seitch the window by using window_Id
	 * @created Date 06/29/2022
	 */
	public static void switchToWindowById(String nameOrHandle) {
		driver.switchTo().window(nameOrHandle);
	}

	/**
	 * 
	 * @param element1
	 * @param element2
	 * @Description To perform the Drag and drop Actions on the element present on
	 *              the webpage
	 * @created Date 06/29/2022
	 */
	public static void dragAndDrop(WebElement element1, WebElement element2) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(element1, element2).perform();
	}

	/**
	 * 
	 * @param element
	 * @Description To perform the double click action on the element present on the
	 *              webpage
	 * @created Date 06/29/2022
	 */
	public static void doubleClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	/**
	 * @Description To close the all windows/browser
	 * @created Date 06/29/2022
	 */
	public static void closeAllWindow() {
		driver.quit();
	}

	/**
	 * @Description To close the current window control by a driver
	 * @created Date 06/29/2022
	 */
	public static void closeCurrentWindow() {
		driver.close();
	}

	/**
	 * 
	 * @param sec
	 * @throws InterruptedException
	 * @Description To implement the static wait concept
	 * @created Date 06/29/2022
	 */
	public static void staticWait(long sec) throws InterruptedException {
		Thread.sleep(sec);
	}

	/**
	 * 
	 * @param seconds
	 * @Description To implement implicit wait
	 * @created Date 06/29/2022
	 */
	public static void implicitlyWait(long seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	/**
	 * 
	 * @param path
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return String
	 * @throws IOException
	 * @Description get all the values present in the existing workbook
	 * @created Date 06/29/2022
	 */
	public static String getData(String path, String sheetName, int rowNo, int cellNo) throws IOException {
		FileInputStream stream = new FileInputStream(new File(path));
		workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		CellType cellType = cell.getCellType();
		String value = "";
		switch (cellType) {
		case STRING:
			value = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat();
				value = dateFormat.format(dateCellValue);

			} else {
				double numericCellValue = cell.getNumericCellValue();
				BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
				value = valueOf.toString();
			}
			break;

		default:
			System.out.println("");
			break;
		}
		return value;
	}

	/**
	 * 
	 * @param path
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param oldData
	 * @param newData
	 * @throws IOException
	 * @Description Replacing value on existing workbook
	 * @created Date 06/29/2022
	 */
	public static void replaceDataInExcel(String path, String sheetName, int rowNo, int cellNo, String oldData,
			String newData) throws IOException {
		File file = new File(path);
		FileInputStream stream = new FileInputStream(file);
		workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		String value = cell.getStringCellValue();
		if (value == oldData) {
			cell.setCellValue(newData);
		}
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
	}

	/**
	 * 
	 * @param path
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param data
	 * @throws IOException
	 * @Description to create a cell on existing workbook and insert the value
	 * @created Date 06/29/2022
	 */
	public static void createCellandInsertValue(String path, String sheetName, int rowNo, int cellNo, String data)
			throws IOException {
		File file = new File(path);
		FileInputStream stream = new FileInputStream(file);
		workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.createCell(cellNo);
		cell.setCellValue(data);
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
	}

	/**
	 * 
	 * @param path
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param data
	 * @throws IOException
	 * @Description to create new row and cell on existing workbook and insert the
	 *              value
	 * @created Date 06/29/2022
	 */
	public static void createCellRowAndInsertValue(String path, String sheetName, int rowNo, int cellNo, String data)
			throws IOException {
		File file = new File(path);
		FileInputStream stream = new FileInputStream(file);
		workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.createRow(rowNo);
		Cell cell = row.createCell(cellNo);
		cell.setCellValue(data);
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
	}

	/**
	 * 
	 * @param path
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param data
	 * @throws IOException
	 * @Description To create new workbook on mentioned location
	 * @created Date 06/29/2022
	 */
	public static void createWorkbookAndInsertValue(String path, String sheetName, int rowNo, int cellNo, String data)
			throws IOException {
		File file = new File(path);
		workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet(sheetName);
		Row row = sheet.createRow(rowNo);
		Cell cell = row.createCell(cellNo);
		cell.setCellValue(data);
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
	}
}
