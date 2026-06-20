# Flipkart E-Commerce Functional Testing Project

This is an automated functional testing project for the Flipkart website. The project focuses on automating end-to-end user workflows, from searching for products to managing the shopping cart, using Selenium and TestNG.

## 🛠️ Tools & Technologies Used
* **Programming Language:** Java
* **Automation Tool:** Selenium WebDriver (v4.x)
* **Test Framework:** TestNG
* **Build Management:** Maven

## 🎯 Key Functionalities Automated
* **Popup Handling:** Automatic detection and closing of login/promotional popups.
* **Product Search & Filtering:** Automating search queries and applying brand/price filters.
* **Window Management:** Switching contexts between the main result page and individual product detail tabs.
* **Cart Management:** Adding items, updating quantity, and verifying price calculations.
* **Negative Testing:** Validating "No results found" messages and error handling for invalid user inputs.
* **Failure Handling:** Custom listener to capture screenshots automatically upon test failure.

## 📂 Project Structure
* `src/test/java`: Contains the complete test suite (`FlipkartTest.java`) including all functional scenarios.
* `testng.xml`: Configuration file for test execution.
* `pom.xml`: Maven configuration for dependencies.

## 🚀 How to Run
1. Clone this repository.
2. Ensure you have JDK 24 installed.
3. Run the project using Maven: `mvn clean test`
