<h1 align="center"> API Test Framework </h1>
<p align="center">
  <img width="460" height="300" src="https://i.ibb.co/L9sVXFN/7fljyy.jpg">
</p>
<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img width="120" height="20" src="https://img.shields.io/badge/License-Apache_2.0-blue.svg" ></a>
  <img width="120" height="20" src="https://badges.frapsoft.com/os/v2/open-source.png?v=10" >
</p>
Designed to test the RESTful APIs using the Service Layer Pattern.
This is a Playwright API framework written in Java and using TestNG as the testing framework, with Maven as the build automation tool. The framework's structure is as follows:

* **src/main/java/model**: This folder contains POJO classes for the framework.<br>
* **src/main/java/service**: This folder contains the APIService class, which contains methods for sending requests, creating instances for Playwright, and disposing and closing them. It also has an APIServiceException class for exception handling.<br>
* **src/main/resources**:This folder contains config.dev.properties and config.prod.properties files for configuration purposes.<br>

In addition, there is a Test folder which contains:
* **src/test/java**: This folder contains the test classes with test methods.<br>
* **src/test/java/utils**: This folder contains the BaseTest class.<br>
* **src/test/resources**: This folder contains schemas and other test data.

## Setup
* Clone the repository or download the code.
* Open the project in your IDE.
* Build the project using the following command: **mvn clean install**
* Run the tests using the following command: **mvn test**

## Reporting
The framework generates test reports using the Allure framework.<br> To generate the test report, run the following command: **mvn allure:serve**

The test report will be generated in the **target/site/allure-maven-plugin** directory.
## Dependencies
This framework has the following dependencies:

* Playwright Java
* TestNG
* Maven
* Allure Report

You can find more information about these dependencies in the pom.xml file.

## Structure 
```bash
📦 playwright-api-testing-framework   
├─ .gitignore  
├─ LICENSE  
├─ README.md  
└─ src  
   ├─ main  
   │  ├─ java  
   │  │  └─ io  
   │  │     └─ ndenic  
   │  │        └─ apitesting  
   │  │           ├─ model  (POJO classes)
   │  │           ├─ data  
   │  │           │  ├─ APIService.java  
   │  │           │  └─ APIServiceExceptionHandler.java  
   │  │           ├─ Utils  
   │  │           │  ├─ Helper.java  
   │  │           │  └─ product  
   │  └─ resources  
   │     ├─ config.dev.properties  
   |     ├─ config.prod.properties
   |     └─ allure.properties
   └─ test  
      ├─ java  
      │  └─ io  
      │     └─ ndenic  
      │        └─ apitesting  
      │           ├─ tests  
      │           └─ util  
      │              └─ BaseTest.java  
      └─ resources  
         ├ testdata 
         └─ schemas
```

## Contributing
Contributions to this framework are welcome. To contribute, please follow these steps:

Fork the repository.
Create a branch for your changes.
Make your changes and commit them.
Push your changes to your fork.
Submit a pull request to the original repository.
## License
This framework is licensed under the <a href="https://www.apache.org/licenses/LICENSE-2.0">Apache License 2.0</a>. See the LICENSE file for details.
