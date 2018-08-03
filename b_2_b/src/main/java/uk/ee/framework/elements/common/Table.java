package uk.ee.framework.elements.common;

import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Wrapper for {@link ru.yandex.qatools.htmlelements.element.Table}
 * <p>
 * Goal of this wrapper it to provide easy way of extending base functionality and add custom functions in case of necessity
 *
 * @see ru.yandex.qatools.htmlelements.element.Table
 */
public class Table extends ru.yandex.qatools.htmlelements.element.Table {

    public Table(WebElement wrappedElement) {
        super(wrappedElement);
    }

    public void selectLastColumnButtonByValueInRow(String value){
        List<List<WebElement>> rows = this.getRows();
        outer:
        for (List<WebElement> row : rows){
            for (WebElement td : row){
                if (td.getText().contains(value)){
                    row.get(row.size()-1).click();
                    break outer;
                }
            }
        }
    }
}
