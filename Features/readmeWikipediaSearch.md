Nice 😎 let’s build a clean, real Cucumber **Feature file** to test a Wikipedia URL.

We’ll test something concrete:
👉 Open Wikipedia
👉 Search for "Selenium"
👉 Verify the page title contains "Selenium"

---

# 🥒 Example: Wikipedia Search Feature

Create a file:

```
wikipedia_search.feature
```

Put this inside 👇

```gherkin
Feature: Wikipedia Search

  As a user
  I want to search for information on Wikipedia
  So that I can read about a specific topic

  Scenario: Search for Selenium on Wikipedia
    Given the user opens the browser
    And navigates to "https://www.wikipedia.org"
    When the user enters "Selenium (software)" in the search field
    And clicks the search button
    Then the page title should contain "Selenium"
```

---

# 🔥 What This Tests

Step-by-step logic:

1. Open browser
2. Go to [https://www.wikipedia.org](https://www.wikipedia.org)
3. Type "Selenium (software)"
4. Click search
5. Verify title contains "Selenium"

Example expected title:

```
Selenium (software) - Wikipedia
```

---

# 💡 More Advanced Version (Better Practice)

If you want it cleaner and reusable:

```gherkin
Feature: Wikipedia Search

  Scenario Outline: Search different terms on Wikipedia
    Given the user is on Wikipedia homepage
    When the user searches for "<searchTerm>"
    Then the page title should contain "<expectedTitle>"

    Examples:
      | searchTerm           | expectedTitle |
      | Selenium (software)  | Selenium      |
      | Java                 | Java          |
      | Algeria              | Algeria       |
```

Now you can test 3 searches with 1 scenario. Powerful 💥

---

# 🎯 What You Learned

* Feature = what we test
* Scenario = one test
* Scenario Outline = multiple test data
* Given/When/Then = behavior steps

---

If you want, I can now:

* Provide the **Step Definition (Java + Selenium)**
* Or give you a full Maven project structure
* Or show how to run it from Jenkins 🚀
