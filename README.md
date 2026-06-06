# Flipkart E-Commerce Testing Project

This is a functional web automation project built to test the core features of the Flipkart website. The main goal of this project was to automate user flows like handling popups, searching for items, and managing the shopping cart using Selenium and TestNG.

## 🛠️ Tools & Technologies Used
* **Programming Language:** Java
* **Automation Tool:** Selenium WebDriver (v4.x)
* **Test Framework:** TestNG
* **Build Management:** Maven

---

## 🎯 What I Automated in this Project
* **Login Popup Handling:** Automated closing the initial login modal that appears upon launching Flipkart.
* **Product Search & Filters:** Simulated searching for products and dynamically applying filters like brand, price range, and ratings.
* **Window & Tab Management:** Handled multi-window switching when clicking a product opens a new detail tab.
* **Smart Wait Strategies:** Implemented Explicit Waits (`WebDriverWait`) to handle dynamic elements and prevent flaky test execution.
* **Failed Test Screenshots:** Integrated a custom listener/utility to automatically capture and save screenshots upon test failure for easier debugging.
* **Test Suite Execution:** Configured a centralized `testng.xml` file to group, prioritize, and run 15+ test scenarios seamlessly.

---

## 📂 Project Directory Structure
```text
├── src/
│   ├── main/java        # Core framework, Base Setup, and Utility classes
│   └── test/java        # TestNG Test classes containing actual validation scripts
├── testng.xml           # XML suite configuration file to manage execution
├── pom.xml              # Maven configuration file containing project dependencies
└── README.md            # Project documentation

