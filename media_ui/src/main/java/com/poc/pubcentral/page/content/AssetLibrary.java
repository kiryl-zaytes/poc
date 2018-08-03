package com.poc.pubcentral.page.content;

import com.poc.pubcentral.page.Page;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class AssetLibrary extends Page {

	@FindBy(xpath = "//h1[contains(@class, 'page-title')]")
	HtmlElement pageTitle;

	@FindBy(xpath = "//span[contains(@aria-hidden, 'true')][contains(text(), 'Next')]")
	HtmlElement nextButton;

	@FindBy(xpath = "//a[contains(text(), 'Home')]")
	HtmlElement homeLink;

	@FindBy(xpath = "//div[@class= 'views-row']")
	HtmlElement viewRows;
}
