package com.Syntax.Pages;

import com.Syntax.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageWithPageFactory extends CommonMethods {

    @FindBy(id="txtUsername")
    public WebElement usernamefield;

    @FindBy(xpath = "//input[@id='txtPassword']")
    public WebElement passwordfield;

    @FindBy(css="input#btnLogin")
    public WebElement loginbtn;

    // Call the constructor to initialize all elements
    public  LoginPageWithPageFactory(){
        PageFactory.initElements(driver, this);
    }




}
