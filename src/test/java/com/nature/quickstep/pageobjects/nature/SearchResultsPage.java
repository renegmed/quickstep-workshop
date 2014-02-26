package com.nature.quickstep.pageobjects.nature;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.nature.quickstep.pageobjects.PageObject;

public class SearchResultsPage extends PageObject {

	/**
	 * This method does nothing since you can only navigate to the search page
	 * by executing a search on another page. The method is still implemented
	 * since this object extends PageObject.
	 */
	@Override
	public void navigateTo() {
		// Not possible in this case. You get to search page by searching for a
		// query.
	}

	/**
	 * Checks if the browser is currently displaying the search results
	 * homepage.
	 * 
	 * @return <code>true</code> if the browser is currently displaying the
	 *         search results homepage, <code>false</code> if not.
	 */
	@Override
	public boolean isPresent() {
		return browser().getTitle().contains("Search results")
				&& browser().getTitle().contains("Nature");
	}

	/**
	 * Returns a list of WebElement objects representing the search results.
	 * 
	 * @return A list of WebElement objects representing the search results
	 */
	public List<WebElement> getSearchResults() {

		return browser().findElements(By.xpath("//ol[@class='results-list']/li"));
	}

	/**
	 * Returns a handle to the pagination bar.
	 * 
	 * @return A handle to the pagination bar.
	 */
	public WebElement getPaginationBar() {

		WebElement result = null;

		try {
			result = browser().findElement(By.className("pagination-bar"));
		} catch (Exception e) {
		}

		return result;
	}

	/**
	 * Interacts with the search results page in order to ask it to limit search
	 * results displayed in one page to a specific number.
	 * 
	 * @param numResults
	 *            - The number of search results to limit per page (must be one
	 *            of the values in the combobox on the website).
	 */
	public void limitResultsTo(int numResults) {
		Select select = getLimitResultsSelectElement();
		select.selectByValue(Integer.toString(numResults));
	}

	/**
	 * Returns a handle to the combobox which enables the user to limit the
	 * amount of search results displayed on a single page.
	 * 
	 * @return A handle to the combobox which enables the user to limit the
	 *         amount of search results displayed on a single page.
	 */
	public Select getLimitResultsSelectElement() {
		return new Select(browser().findElement(By.id("sp-c")));
	}

	/**
	 * Returns a handle to the "Hide Context" button.
	 * 
	 * @return A handle to the "Hide Context" button.
	 */
	public WebElement btnHideContext() {
		return browser().findElement(By.className("hide-summ"));
	}

	/**
	 * Returns a handle to the "Show Context" button.
	 * 
	 * @return A handle to the "Show Context" button.
	 */
	public WebElement btnShowContext() {
		return browser().findElement(By.className("show-summ"));
	}

	/**
	 * Returns a list of WebElement objects which provide a handle to every
	 * "context" in the search results list. A context is a summary of the
	 * article in the search result.
	 * 
	 * @return A list of WebElement objects which provide a handle to every
	 * "context" in the search results list.
	 */
	public List<WebElement> getSearchResultContexts() {
		return browser().findElements(By.className("ml-snippet"));
	}

}
