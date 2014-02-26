Feature: Nature search functionality

In order to find nature content
As a user of nature.com
I want to be able to use the search functionality 

Scenario: Basic Search
Given I am a nature user
When I visit the nature.com homepage
And I search for a popular search term
Then I should see the search results page
And I should see 25 search results
And I should see pagination controls

Scenario: Display 10 search results
Given I am a nature user
And I visit the nature.com homepage
And I search for a popular search term
When I limit results to 10 results per page
Then I should see 10 search results

Scenario: Search for zero-result search term
Given I am a nature user
And I visit the nature.com homepage
When I search for a zero-result search term
Then I should see 0 search results

Scenario: Show context in search results
Given I am a nature user
And I visit the nature.com homepage
And I search for a popular search term
When I choose to show the context for search results
Then I should see the context embedded within search results