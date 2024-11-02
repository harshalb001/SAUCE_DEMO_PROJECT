package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HandleDropdownlist 
{
	public static void  dropdownlist(WebElement el , String value)
	{
		Select s = new Select(el);
		s.selectByVisibleText(value);
	}

}
