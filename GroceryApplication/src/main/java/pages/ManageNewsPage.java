 package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageNewsPage {
	
		public WebDriver driver;
		PageUtility pageutility=new PageUtility();
		WaitUtility waitutility=new WaitUtility();
	   public ManageNewsPage(WebDriver driver)
	   {
		  this.driver=driver; 
		  PageFactory.initElements(driver, this);	
	   }
	   
	  @FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")WebElement newbtn;
	  public ManageNewsPage clickNewButton()
	  {
		 pageutility.clickElement(newbtn);
		 return this;
	  }
	  @FindBy(xpath = "//textarea[@placeholder='Enter the news']")WebElement addnewsinputbox;
	  public ManageNewsPage clickAddNewsInput()
	  {	
		
		 pageutility.sendDataToElement(addnewsinputbox,"sample news");
		 return this;
	  }
	  
	  @FindBy(xpath = "//button[@name='create']")WebElement addnewssavebtn;
	  public ManageNewsPage clickAddNewsSavebtn()
	  {
		pageutility.clickElement(addnewssavebtn);
		 return this;
	  } 
	  
	  @FindBy(xpath = "//a[text()='Home']")WebElement homebtn;
	  
	  public HomePage clickhomebtn()
	  {
		  pageutility.clickElement(homebtn);
		  return new HomePage(driver);
	  }
	  
	  @FindBy(xpath = "//a[@href='javascript:void(0)']")WebElement searchbtn;
	  public ManageNewsPage clickSearchButton() 
	  {
		  pageutility.clickElement(searchbtn);
		  return this;
	  }
	  
	  @FindBy(xpath = "//input[@placeholder='Title']")WebElement newstitlteinputbox;
	  public ManageNewsPage enterNewsTitlteInputBox()
	  {
		pageutility.sendDataToElement(newstitlteinputbox,"Sample news");
		 return this;
	  }
	  
	  @FindBy(xpath = "//button[text()='Search']")WebElement searchbtnInSearch;
	  public ManageNewsPage clickSearchbtnInSeach() 
	  
	  {
		  pageutility.clickElement(searchbtnInSearch);
		  return this;
	  }
	  
	  @FindBy(xpath = "//a[text()='Reset']")WebElement resetbtn;
	  public ManageNewsPage clickResetInSearch() {
		pageutility.clickElement(resetbtn);
		 return this;
	  }
	  //assertion web elements and methods
	  
	  @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement addNewsAlert;
	  
	  public boolean isaddNewsAlertDisplayed() 
	     {
			return addNewsAlert.isDisplayed();
		  }
	  
	  @FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]") WebElement fistcelloftable;
	  public String isSearchedNewsListedIntable() {
	  return fistcelloftable.getText();
		  }
   
	  @FindBy(xpath = "//form[@role='form']") WebElement searchandmangenewscard;
	  	public boolean isSearchAndMangeNewsCarddisplayed() {
		return searchandmangenewscard.isDisplayed();
		  }
	  

	}