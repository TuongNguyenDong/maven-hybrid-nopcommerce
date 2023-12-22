# maven-hybrid-nop-commerce
Hybrid framework with TestNG + SeleniumWebDriver + Maven in Java
This hybrid framework for Web applications, specifically a Nop-Commerce web application. They are currently used for UI Testing using the Maven project.
- Web Demo:
 - [Nopcommerce](https://demo.nopcommerce.com/)
 - [Admin-NopCommerce](https://admin-demo.nopcommerce.com/)
 
## Languages and Frameworks
This project uses the following languages and frameworks:

- Java 11 as the programming language
- TestNG to support the test creation
- Selenium WebDriver (version 3.141.59) is a web browser automation framework using Java binding.
- TestNG Report as the testing report strategy
- Log4J as the logging management strategy
- WebDriverManager (version 5.4.1) as the Selenium binaries management
- XPath, CSS helps identify elements from an XML document.
- Intergate with Jenkins to build and run test cases

## Test architecture
We know that any automation project starts with a good test architecture.

This project can be your initial test architecture for a faster start. You will see the following items in this architecture:

- [Page Objects pattern](https://github.com/TuongNguyenDong/maven-hybrid-nopcommerce/blob/master/README.md#page-objects-pattern)
- [Execution types](https://github.com/TuongNguyenDong/maven-hybrid-nopcommerce/blob/master/README.md#execution-types)
- [BaseTest](https://github.com/TuongNguyenDong/maven-hybrid-nopcommerce/blob/master/README.md#basetest)
- [TestListener](https://github.com/TuongNguyenDong/maven-hybrid-nopcommerce/blob/master/README.md#testlistener)
- [Logging](https://github.com/TuongNguyenDong/maven-hybrid-nopcommerce/blob/master/README.md#logging)
- [Parallel execution](https://github.com/TuongNguyenDong/maven-hybrid-nopcommerce/blob/master/README.md#parallel-execution)

### Page Objects pattern
- Test cases extend BaseTest
- Page UI contains XPath and CSS locators
- PageObjects extends BasePage
- PageGeneratorManager:
  - Initialize Page Objects.
  - Hides the initialization at both the Test cases and PageObject layers.
- Using Dynamic to handle (Page/Action/Component)

### Execution types
- `local-suite`
- `selenium-grid`
- `docker`
  
#### local-suite
- This execution type also uses the WebDriverManager to instantiate the web browser. The browser is taken from the TestNG suite file enabling you to run a multi-browser test approach locally.
- When the `envName` is `localUser` or `localAdmin` the` getBrowserDriver` method is used from the `BaseTest` to return the `LocalFactory` class to the execution needs of the browser.
    
#### selenium-grid
- The Selenium Grid approach executes the tests in remote machines (local or remote/cloud grid). When the `envName` is `GridUser` or `GridAdmin` the getBrowserDriver method is used from the `BaseTest` to return `GridFactory` class as the remote execution needs the browser capability.  
- The `GridFactory` class has the internal method `createDriverUser` or (`createDriverAdmin`) to return a RemoteWebDriver based on the browser capability.
- You must pay attention to the two required information regarding the remote execution: the `grid.url` and `grid.port` property values on the `GridFactory` class. You must update these values before the start.
        
#### Docker
- When the `envName` is `DockerGridUser` or `DockerGridAdmin` the getBrowserDriver method is used from the `BaseTest` to return `DockerGridFactory` class as the remote execution needs the browser capability.
- Ensure you have registered and integrated a Docker account with the Docker desktop. and also make sure that the version of selenium on the `yml` file and source code are the same.
  
### BaseTest
This testing pattern was implemented on the `BaseTest` class to automatically run the pre (setup) and post (teardown) conditions.

The pre-condition uses `@BeforeClass` from TestNG to create the browser instance based on the values passed either local or remote execution. The post-condition uses `@AfterClass` to close the browser instance. `@AfterClass` has the alwaysRun parameter as true to force the run on a pipeline.

It was designed to open a browser instance to each` @Test` in the test class.

This class also has the TestListener annotation which is a custom TestNG listener, and will be described in the next section.

###  TestListener
The TestListener is a class that implements ITestListener. The following method is used to help log errors and attach additional information to the test report:

onTestFailure: log the exceptions and add a screenshot to the test report

###  Logging
All the log is done by the Log4J using the @Log4j annotation.

The log4j.properties has two strategies: console and file. A file with all the log information will be automatically created in the user folder with /scriptLogs/NopCommerce.log filename. If you want to change it, update the appender.file.fileName property value.

The log.error is used to log all the exceptions this architecture might throw. Use log.info to log important information, like the users, automatically generated by the factory BookingDataFactory

### Parallel execution
The parallel test execution is based on the parallel tests feature on TestNG. This is used by `*.xml` test suite file which has the parallel="tests" attribute and value, whereas test item inside the test suite will execute in parallel. The `browser`, `envName`, `parallel` in use for each test should be defined by a parameter, like:

```xml
<suite name="NopCommerce"  parallel ="tests" thread-count = "2">
<parameter name="envName" value="localAdmin" />
<parameter name="browser" value="chrome"/>
</suite>
```
