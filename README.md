# 🖥️ Java Selenium BDD - End-to-End Testing Framework 🚀

## Reasoning - Steps Followed (High-Level)

### Project Setup and Implementation:
1. **📥 Install Java, Java Compiler, and Maven**
2. **🛠️ Eclipse**: Create a Maven project
3. **📝 Include Dependencies and Plugins**: 
    - Add dependencies to the `pom.xml` file:
        - cucumber-java, cucumber-core, cucumber-junit, selenium-java, webdrivermanager
    - Add plugins:
        - maven-cucumber-reporting, maven-surefire-plugin

### Quick Documentation of Dependencies:

* **🍃 cucumber-java**: Integrates the Cucumber framework with Java, enabling the execution of feature files written in Gherkin language. It allows step definitions to be implemented in Java, facilitating Behavior Driven Development (BDD) for testing Java-based applications.

* **🛠️ cucumber-core**: Provides the essential runtime for executing Cucumber scenarios. Includes the core components for parsing feature files, running tests, and reporting results based on the step definitions and Gherkin specifications.

* **📦 cucumber-junit**: Integrates Cucumber with the JUnit framework, allowing Cucumber tests to be executed as JUnit tests. Leverages JUnit’s test lifecycle and reporting capabilities while supporting BDD.

* **🌐 selenium-java**: Provides the core Selenium WebDriver libraries for automating web browsers. Essential for controlling browsers programmatically in Java, enabling web testing and interaction with web elements.

* **🔧 webdrivermanager**: Simplifies browser setup by automatically downloading the appropriate browser binaries and eliminating the need for manual setup of the browser drivers.

### Quick Documentation of Plugins:

* **🔍 maven-surefire-plugin**: is responsible for running the unit tests during the Maven build process.
  
* **📊 maven-cucumber-reporting**: Generates detailed HTML reports for Cucumber test results. Reads the Cucumber JSON output and produces reports with overviews of test results, feature-specific reports, and more, saving output in specified directories.

---

## Implementation of BDD

1) **📂 Creation of the "Features" package** under `src/test/resources`:
   - Created the `.feature` file: `car_registration_submission.feature`.
   - Described all scenarios using the BDD approach with Gherkin tables (Examples) and Gherkin language.
   - Includes tagging, preconditions (via the Background keyword), and DDT (Data-Driven Testing).

2) **📜 Creation of the "step_definitions" package**:
   - Created `CarRegistrationSubmissionSteps.java` for all step definitions linked to the feature file.
   - Acts as the glue code connecting Gherkin steps to Selenium logic.
   - Implements Cucumber hooks (`@Before`, `@After`) for setup and teardown at the Scenario level.
   - Includes JUnit assertions for validation of expected results.

3) **🏃 Creation of the "test_runner" package**:
   - Created `TestRunner.java`, responsible for configuring and running Cucumber tests.
   - Specifies the location of the feature files, step definitions, and output reports (.html, .json, .xml).
   - Uses tag filtering and manages browser selection through the `browser` field.
   - Sandobx file `QA Programming Exercise.html` access should be treated as a resource rather than a direct file path. `ClassLoader` was used to resolve this issue.

4) **🌐 Creation of the "web_pages" package**:
   - Created `CarRegistrationSubmission.java` following the Page Object Model (POM) design pattern.
   - Contains references to web elements and their corresponding actions for interaction.
   - Includes getter methods for retrieving success and error messages.


---

# 🚀 How to run the automated tests using Maven

### Prerequisites:

#### ☕ Java:
- Make sure you have JDK installed (in this case, JDK 17 is being used).
- Set the `JAVA_HOME` environment variable to the JDK installation path.

#### 🔧 Apache Maven:
- Download and install Maven.
- Set the `MAVEN_HOME` environment variable and add Maven to the system’s `PATH`.


---

### Steps to run the automated tests:

1. **📥 Download or Clone the project** from Git.
2. **🖥️ Open the command line** and navigate to the `e2e-ui-tests` directory of this project.
3. **⚙️ Run the following command**:
   ```bash
   mvn clean test
   ```
   This will:
   - 🧹 Clean the previous build.
   - 🧪 Run all tests defined in your Cucumber feature files.

4. 📄 Generate the test reports by running:
   ```bash
   mvn verify -DskipTests
   ```
   This will:
   - Generate the automated test reports in an interactive `.html` file.
   - The file `SmokeTests.html` will be saved in `e2e-ui-tests\target\cucumber-report-html\cucumber-html-reports\`.

5. 🔍 Review the results of the automated tests**:
   - Open the file `e2e-ui-tests\target\cucumber-report-html\cucumber-html-reports\SmokeTests.html` in your browser.
   - You can interact with the test results and explore details like:
     - Cucumber features, tags, hooks, steps.
     - Failures (if any), errors (if any).
     - Other useful specs and statistics of your test results.
   - ✅ Normally, all tests (10) should pass.

---

## 🔮 Future Considerations - Suggestions for Improvement, Expansion, and Integrations

### 🔧 Additional Browser Support:
Consider expanding the project to support more browsers like Opera or Safari for wider test coverage.

### ⚡ CI/CD Integration:
Integrating this project into a CI/CD pipeline (e.g., Jenkins, GitHub Actions) could automate the execution of tests upon each code commit or update.

### 🛠️ Parallel Testing:
Explore parallel execution to run tests concurrently, reducing test execution time and improving efficiency for large test suites.

### 📊 Enhanced Reporting:
Consider adding more advanced reporting tools or integrating with third-party services like Allure or TestRail for more detailed insights.

### 📜 Logging:
- Implement comprehensive logging to track test execution details and capture key events, making it easier to debug issues and monitor test progress.

### ⚠️ Exception Handling:
- Enhance exception handling to gracefully handle unexpected errors during test execution, allowing tests to fail more meaningfully and generate actionable error messages.

### 🔄 Retry Logic:
- Introduce retry logic to re-run tests automatically in case of intermittent failures or flaky tests. This can help stabilize test results and improve the reliability of automated testing.

### 📧 Automated Report Emails:
- Implement the ability to send automated test reports via email once the test execution is complete. This can be done by integrating an email service like SMTP or third-party APIs (e.g., SendGrid) to automatically send test reports in various formats (HTML, JSON, XML) to relevant stakeholders after each test run.
