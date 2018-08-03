package uk.ee.framework.elements.sections.my_ee;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;
import uk.ee.framework.business_objects.dao.user.User;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;
import uk.ee.framework.utils.Waiter;

/**
 * Created by kiryl_zayets on 4/28/16.
 */

@Timeout(8)
public class LoginSection extends CustomHtmlElement {

    @FindBy(id = "capture_signIn_traditionalSignIn_emailAddress")
    private TextInput loginUserName;

    @FindBy(name = "traditionalSignIn_password")
    private TextInput loginPwd;

    @FindBy(id = "capture_signIn_traditionalSignIn_signInButton")
    private Button submitButton;

    public void login(User user){
        loginUserName.sendKeys(user.getLogin());
        loginPwd.clear();
        loginPwd.sendKeys(user.getPassword());
        submitButton.click();
        
    }

}
