Feature: Thomas Cook Homepage checks

  Scenario: Open homepage and verify title contains Thomas Cook
    Given user opens the application
    When user captures the title
    Then title should contain "Thomas Cook"
