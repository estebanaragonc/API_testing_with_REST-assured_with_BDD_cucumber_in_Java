Feature:
  Verify different GET operations using rest-assured

  Scenario: Verify one author of the post
    Given I perform GET operation for "/posts"
    Then I should see the author name as "esteban"

  Scenario: Verify collection of author of the post
    Given I perform GET operation for "/posts"
    Then I should see the author names

  Scenario: Verify parameter of get
    Given I perform GET operation for "/posts"
    Then I should verify get parameter

  Scenario: Verify parameter of get using query parameter
    Given I perform GET operation for "/posts"
    Then I should verify get parameter with query parameter