package page;


import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PageHomeVk extends Form {
    public PageHomeVk() {
        super(By.className("TopHomeLink"), "label VK");
    }

    private final ITextBox inputFieldEmailOrPhoneNumber = getElementFactory().getTextBox(By.id("index_email")
            , "input field email or phone number");
    private final ITextBox inputFieldPassword = getElementFactory().getTextBox(By.id("index_pass")
            , "input field password");
    private final IButton buttonLogIn = getElementFactory().getButton(By.id("index_login_button"), "button LogIn");

    public void inputEmailOrPhoneNumber(String setEmailOrPhoneNumber) {
        inputFieldEmailOrPhoneNumber.sendKeys(setEmailOrPhoneNumber);
    }

    public void inputPassword(String setPassword) {
        inputFieldPassword.sendKeys(setPassword);
    }

    public void pressButtonLogIn() {
        buttonLogIn.click();
    }
}
