package com.nature.quickstep.pageobjects.nature;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.nature.quickstep.pageobjects.PageObject;
//import com.nature.quickstep.util.QuickstepContext;
//import com.nature.quickstep.util.QuickstepContext.Website;

/**
 * This class enables interaction with (and querying of) the nature.com
 * homepage.
 * 
 * @author mark.micallef
 */

public class NatureHomepage extends PageObject {

	/**
	 * Navigates to the Nature.com homepage. The URL used is determined by the
	 * environment in which Quickstep has been told to execute tests.
	 */
	@Override
	public void navigateTo() {
		try {
			browser().get(context().getURL("nature.com/"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Checks if the browser is currently displaying the nature.com homepage.
	 * 
	 * @return <code>true</code> if the browser is currently displaying the
	 *         nature.com homepage, <code>false</code> if not.
	 */
	@Override
	public boolean isPresent() {

		boolean result = false;
		try {
			result = browser().getCurrentUrl().equals(
					context().getURL("/"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * Returns the browser title
	 * 
	 * @return The browser title
	 */
	public String getTitle() {
		return browser().getTitle();
	}

	/**
	 * Uses the search field on the homepage to search for the given query.
	 * 
	 * @param query
	 *            - The query
	 */
	public void searchFor(String query) {
		fldSearch().sendKeys(query);
		btnGo().click();
	}

	/**
	 * Returns a handle to the search field element.
	 * 
	 * @return A handle to the search field element
	 */
	public WebElement fldSearch() {
		return browser().findElement(By.id("searchtext"));
	}

	/**
	 * Returns a handle to the "Go" button element.
	 * 
	 * @return A handle to the "Go" button element
	 */
	public WebElement btnGo() {
		return browser().findElement(By.name("submit"));
	}

	/**
	 * Returns a handle to a link with the given text.
	 * @param linkText - The text of the desired link.
	 * @return A handle to a link with the given text.
	 */
	public WebElement lnkWithText(String linkText) {
		return browser().findElement(By.linkText(linkText));
	}

}
