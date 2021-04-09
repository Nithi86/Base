 import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Base {
	public static WebDriver driver;

	public static WebDriver browserLaunch() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\NITHYA\\eclipse-workspace\\Base\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}

	public static void launchUrl( String url) {
		driver.get(url);

	}

	public static void type(WebElement element, String data) {
		element.sendKeys(data);

	}

	public static void btnClick(WebElement element) {
		element.click();
	}

	public static void selectByVisibleText(WebElement element, String data) {
		new Select(element).selectByVisibleText(data);

	}

	public static void selectByValue(WebElement element, String data) {
		new Select(element).selectByValue(data);
	}

	public static void quitBrowser(WebDriver driver) {
		driver.quit();

	}

	public static String getDataFormExcel(String pathname, String name, int rownum, int cellnum) throws IOException {
		File file = new File(pathname);
		FileInputStream stream = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(stream);
		Sheet sheet = wb.getSheet("sheet1");
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		int cellType = cell.getCellType();
		String value = " ";
		if (cellType == 1) {
			value = cell.getStringCellValue();
		} else {
			if (DateUtil.isCellDateFormatted(cell)) {

				Date date = cell.getDateCellValue();
				SimpleDateFormat DateFormat = new SimpleDateFormat("dd-mm-yy");
				 value = DateFormat.format(date);
			} else {
				double d = cell.getNumericCellValue();
				long l = (long) d;
				 value = String.valueOf(l);
			}
		}
		return value;
	}
}
