Feature: Manage pet types
  The veterinarian wants to be able to add, edit, and delete pet types.

  Scenario: Add new pet type
    Given a system operator named "Jane" is looking at the pet types page
    And she found the following pet types exist:
      | cat     |
      | dog     |
      | lizard  |
      | snake   |
      | bird    |
      | hamster |
    When she adds a new pet type named "turtle"
    Then she should see the pet type "turtle" on the list of pet types

  # TODO: Add a scenario to "Edit the last pet type"