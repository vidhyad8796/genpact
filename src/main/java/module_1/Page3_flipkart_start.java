package module_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page3_flipkart_start 
{
@FindBy (xpath = "//button[contains(@class,'_2doB4z')]") private WebElement close;
public Page3_flipkart_start(WebDriver driver)
{
PageFactory.initElements(driver, this);	

}
public void click_close_X()
{
close.click();	
}
}
