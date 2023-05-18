package module_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class page1_google 
{

	@FindBy(xpath = "//input[@class='gLFyf']")  private WebElement search; 
	@FindBy(xpath = "(//input[@value='Google Search'])[2]") private WebElement search_button;
	public page1_google(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void search_box(String sh)
	{
		search.sendKeys(sh);
	}
	public void click_search_button()
	{
		search_button.click();
	}
	
	
}
