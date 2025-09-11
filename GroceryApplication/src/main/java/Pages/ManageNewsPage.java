package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	
		public WebDriver driver;
		
	   public ManageNewsPage(WebDriver driver)
	   {
		  this.driver=driver; 
		  PageFactory.initElements(driver, this);
	
	   }
	   
	   @FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'and @class='small-box-footer']")WebElement managenewstile;
	   public void clickManageNewsTile() {
	//	WebElement managenewstile=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'and @class='small-box-footer']"));
		managenewstile.click();
	   }
	   @FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")WebElement newbtn;
	  public void clickNewButton()
	  {
		//  WebElement newbtn=driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
		  newbtn.click();
	  }
	  @FindBy(xpath = "//textarea[@placeholder='Enter the news']")WebElement editnewsinput;
	  public void enterEditNewsInput() {
	
		  editnewsinput.sendKeys("sample news");
	  }
	  
	  @FindBy(xpath = "//button[@name='create']")WebElement editnewssavebtn;
	  public void enterEditNewsSavebtn() {
		//WebElement editnewssavebtn=driver.findElement(By.xpath("//button[@name='create']"));
		editnewssavebtn.click();
	  } 
	  
	  @FindBy(xpath = "//a[text()='Home']")WebElement homebtn;
	  public void clickhomebtn() {
	 // WebElement homebtn=driver.findElement(By.xpath("//a[text()='Home']"));
	  homebtn.click();
	  }
	  
	  @FindBy(xpath = "//a[@href='javascript:void(0)']")WebElement searchbtn;
	  public void clickSearchButton() {
	   // WebElement searchbtn=driver.findElement(By.xpath("//a[@href='javascript:void(0)']"));
		searchbtn.click();
	  }
	  
	  @FindBy(xpath = "//input[@placeholder='Title']")WebElement newstitlteinputbox;
	  public void enterNewsTitlteInputBox() {
		//WebElement newstitlteinputbox=driver.findElement(By.xpath("//input[@placeholder='Title']"));
		newstitlteinputbox.sendKeys("Sample news");
	  }
	  
	  @FindBy(xpath = "//button[text()='Search']")WebElement searchbtnInSearch;
	  public void clickSearchbtnInSeach() {
		  WebElement searchbtnInSearch=driver.findElement(By.xpath("//button[text()='Search']"));
		  searchbtnInSearch.click();
	  }
	  
	  @FindBy(xpath = "//a[text()='Reset']")WebElement resetbtn;
	  public void clickResetInSearch() {
		WebElement resetbtn=driver.findElement(By.xpath("//a[text()='Reset']"));
		resetbtn.click();
	  }
	  //assertion web elements methods
	  
	  @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement addNewsAlert;
	  
	  public boolean isaddNewsAlertDisplayed() {
			return addNewsAlert.isDisplayed();
		  }
	  
	  @FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]") WebElement fistcelloftable;
	  
	  public String isSearchedNewsListedIntable() {
		return fistcelloftable.getText();
		  }
   
	  @FindBy(xpath = "//form[@role='form' ]") WebElement searchandmangenewscard;
	  	  public boolean isSearchAndMangeNewsCarddisplayed() {
		return searchandmangenewscard.isDisplayed();
		  }
	  

	}