@Calculator
Feature: Calculator test

  @plus
  Scenario Outline: Calculator plus function test
    Given Type first number
    And Press plus button
    And Type second number
    And Press equal button
    And Get expected result
    And Get actually result
    Then Assert result

  @minus
  Scenario Outline: Calculator minus function test
    Given Type first number
    And Press minus button
    And Type second number
    And Press equal button
    And Get expected result
    And Get actually result
    Then Assert result

  @multiple
  Scenario Outline: Calculator multiple function test
    Given Type first number
    And Press multiple button
    And Type second number
    And Press equal button
    And Get expected result
    And Get actually result
    Then Assert result

  @divided
  Scenario Outline: Calculator divided function test
    Given Type first number
    And Press divided button
    And Type second number
    And Press equal button
    And Get expected result
    And Get actually result
    Then Assert result
