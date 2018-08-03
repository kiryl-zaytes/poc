package uk.ee.framework.elements.sections.my_ee;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Radio;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

/**
 * Created by kiryl_zayets on 5/13/16.
 */
public class UsageControls extends CustomHtmlElement {

    @FindBy(id="use_data_allow")
    Radio useDataAllowed;

    @FindBy(id="use_data_block")
    Radio useDataBlock;

    @FindBy(id="buy_addons_allow")
    Radio buyDataAllowed;

    @FindBy(id="buy_addons_block")
    Radio buyDataBlock;

    @FindBy(id="calls_anywhere_allow")
    Radio callAboardAllowed;

    @FindBy(id="calls_anywhere_block")
    Radio callAboardBlock;

    @FindBy(id="usageControls_Submit")
    Button apply;

    @FindBy(id="usageControls_Cancel")
    Button usageControls_Cancel;
}
