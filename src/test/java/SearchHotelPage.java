import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage extends Base {
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "location")
	private WebElement dDnlocation;

	@FindBy(id = "hotels")
	private WebElement dDnHotel;

	@FindBy(id = "room_type")
	private WebElement dDnRoom;

	@FindBy(id = "Submit")
	private WebElement btnSearch;

	public WebElement getBtnrooms() {
		return btnrooms;
	}

	@FindBy(id = "noofrooms")
	private WebElement btnrooms;

	public WebElement getdDnlocation() {
		return dDnlocation;
	}

	public WebElement getdDnHotel() {
		return dDnHotel;
	}

	public WebElement getdDnRoom() {
		return dDnRoom;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}

}
