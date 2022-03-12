@tag
Feature: Search and Place Orders for products
  I want to use this template for my feature file

  #@tag1
  #Scenario: Search product in bothhome and offers page
    #Given user is on Greenkart landing page
    #When User search product shortname "<prod>" in home page search bar and extracts actual name of product
#		Then user search short name in offers page
#		And Verify product exists in the list on the offers page
		 
  @tag2
  Scenario: Search product in bothhome and offers page
    Given user is on Greenkart landing page
    When User search product shortname "<prod>" in home page search bar and extracts actual name of product
		Then user search short name in offers page
		And Verify product exists in the list on the offers page

    Examples: 
      |prod	|
      |pot	|
      |Tom	|
