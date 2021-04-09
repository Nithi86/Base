import java.io.IOException;

import javax.naming.directory.SearchResult;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SheeetDatas extends Base{

	public static void main(String[] args)throws IOException, InterruptedException {
		browserLaunch();		
	
		Login log=new Login();
		 launchUrl("http://adactinhotelapp.com/");
		Thread.sleep(5000);
	
	WebElement UserName = log.getTxtUserName();  
	
	type(UserName,getDataFormExcel("C:\\Users\\NITHYA\\eclipse-workspace\\Base\\Adactin\\adactin.xlsx","HOTEL",1,0));
	
	WebElement Passward =log.getTxtPassword(); 
	type(Passward,getDataFormExcel("C:\\Users\\NITHYA\\eclipse-workspace\\Base\\Adactin\\adactin.xlsx","HOTEL",1,1));
	
	WebElement btnClick = log.getBtnLogin();
	btnClick.click();
	
	
	//hotel search
	
	SearchHotelPage hotel=new SearchHotelPage();
	
WebElement location = hotel.getdDnlocation();
selectByValue(location, getDataFormExcel("C:\\Users\\NITHYA\\eclipse-workspace\\Base\\Adactin\\adactin.xlsx","HOTEL",1,2));
WebElement HotelName = hotel.getdDnHotel();
selectByValue(HotelName,getDataFormExcel("C:\\Users\\NITHYA\\eclipse-workspace\\Base\\Adactin\\adactin.xlsx","HOTEL",1,3));

WebElement room = hotel.getdDnRoom();
selectByValue(room, getDataFormExcel(System.getProperty("user.dir")+"\\Adactin\\adactin.xlsx","HOTEL",1,4));	
WebElement search = hotel.getBtnSearch();
btnClick(search);
	
	}

} 