package module_1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class page4 
{
	@FindBy(xpath = "(//div[text()='More'])") private WebElement more;
	@FindBy(xpath = "//li[@class='_2NOVgj']") private List<WebElement> more_options;
	
	public page4(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void more_click()
	{
		more.click();
	}
 
	public  List<WebElement> more_options_get() 
	{
		List<WebElement> value = more_options;
		
		return value;
		
	}
}
