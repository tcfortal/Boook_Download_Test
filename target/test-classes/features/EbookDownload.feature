
Feature: Ebook Download

  @tag1
  Scenario: Ebook Download
    Given that Im on the site "https://www.bibliotecadigital.unicamp.br"
    And enter the name of the book to be searched "Atenção Básica no Sistema Único de Saúde (SUS)"
    And I click search
    And should return the searched book "Atenção Básica no Sistema Único de Saúde (SUS)"

	  And I click access
	  And I click on another in access
	  When the book open in pdf
	   
	  Then I download "Baixar"
	  Then close
	  
  