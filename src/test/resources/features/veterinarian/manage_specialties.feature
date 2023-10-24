Feature: Manage specialties
  The veterinarian wants to be able to add, edit, and delete specialties.

  Scenario: Add new specialty
    Given a system operator named "John" is looking at the specialties page
    When he adds a new specialty called "cardiology"
    Then he should see the specialty "cardiology" on the list of specialties

  Scenario: Edit the first specialty
    Given a system operator named "John" is looking at the specialties page
    When he edits the first specialty to "snake oil"
    Then he should see the specialty "snake oil" on the list of specialties

  # TODO: Add a scenario to "Add new specialty and remove it immediately"