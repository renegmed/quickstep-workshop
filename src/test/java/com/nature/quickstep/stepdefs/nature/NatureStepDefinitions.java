package com.nature.quickstep.stepdefs.nature;

import com.nature.quickstep.pageobjects.nature.NatureHomepage;
import com.nature.quickstep.pageobjects.nature.SearchResultsPage;

import cucumber.api.java.en.*;
import static org.junit.Assert.*;


public class NatureStepDefinitions {
	
	NatureHomepage homepage = new NatureHomepage();
	SearchResultsPage searchResultsPage = new SearchResultsPage();

	@Given("^I am a nature user$")
	public void I_am_a_nature_user() throws Throwable {
	}

	@When("^I visit the nature.com homepage$")
	public void I_visit_the_nature_com_homepage() throws Throwable {
		homepage.navigateTo();
	}

	@Then("^I should see the correct title on the page$")
	public void I_should_see_the_correct_title_on_the_page() throws Throwable {
		assertEquals(
				"Nature Publishing Group : science journals, jobs, and information",
				homepage.getTitle());
	}
	
	@When("^I search for a popular search term$")
	public void I_search_for_a_popular_search_term() throws Throwable {
		homepage.searchFor("smoking");
	}
	
	@When("^I search for a unpopular search term$")
	public void I_search_for_an_unpopular_search_term() throws Throwable {
		homepage.searchFor("smoking");
	}
	
	@When("^I search for a zero-result search term$")
	public void I_search_for_a_zero_result_search_term() throws Throwable {
		homepage.searchFor("nonrepudiation");
	}
	
	@When("^I search for \"([^\"]*)\"$")
	public void I_search_for(String query) throws Throwable {
		homepage.searchFor(query);
	}

	@Then("^I should see the search results page$")
	public void I_should_see_the_search_results_page() throws Throwable {
	    assertTrue(searchResultsPage.isPresent());
	}
	
	@Then("^I should see (\\d+) search results$")
	public void I_should_see_results(int num) throws Throwable {
		assertEquals(num, searchResultsPage.getSearchResults().size());
	}
	
	@Then("^I should see pagination controls$")
	public void I_should_see_pagination_controls() throws Throwable {
	   assertNotNull(searchResultsPage.getPaginationBar());
	}
	
	@When("^I limit results to (\\d+) results per page$")
	public void I_limit_results_to_results_per_page(int numResults) throws Throwable {
		searchResultsPage.limitResultsTo(numResults);
	}

	@When("^I choose to show the context for search results$")
	public void I_choose_to_show_the_context_for_search_results() throws Throwable {
		searchResultsPage.btnShowContext().click();
	}

	@Then("^I should see the context embedded within search results$")
	public void I_should_see_the_context_embedded_within_search_results() throws Throwable {
		assertNotEquals(0, searchResultsPage.getSearchResultContexts().size());
	}
	
	@Then("^I should see a \"([^\"]*)\" link$")
	public void I_should_see_a_link(String linkText) throws Throwable {
	   assertNotNull(homepage.lnkWithText(linkText));
	}

}
