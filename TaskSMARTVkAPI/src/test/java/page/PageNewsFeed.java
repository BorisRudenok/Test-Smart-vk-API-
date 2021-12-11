package page;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PageNewsFeed extends Form {
    public PageNewsFeed() {
        super(By.className("TopHomeLink"), "label Vk");
    }

    private final IButton buttonMyPage = getElementFactory().getButton(By.id("l_pr"), "button 'My page'");

    public void pushButtonMyPage() {
        buttonMyPage.click();
    }
}
