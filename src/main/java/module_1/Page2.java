package module_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page2
{
@FindBy(xpath = "//h3[text()='Flipkart']") private WebElement Flip;
public Page2(WebDriver driver)
{
PageFactory.initElements(driver, this);	

}
public void click_flip()
{
	Flip.click();
	}

}
