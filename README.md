# ZalandoDemo

This is test automation demo task of Zalando in which below test scenario is included:
Scenario: Create a automated test for following scenarios: 
Go to zalando website www.zalando.de
Go to the Search box and search for article DK151H09R-Q11
Add it to the cart
Go to the cart and change the quantity to 2
Move the items from the basket to the wishlist.

# Getting Started

Please follow below instruction to copy the project and running on your local machine for testing purpuse

#### Prerequisites

Maven home: apache-maven-3.5.0

Java version: 1.8.0_65, vendor: Oracle Corporation

Chrome version: Version 61.0.3163.100 (Official Build) (64-bit)

Git Bash

If you are running this code in windows then please update chrome driver in AttachHooks like below :
System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
###### Remove negative test cases from feature file for successful build
###### Item should not already be in wish list

# Running the tests

Given scenario is automated using selenium cucumber.
Gherkin language is used in cucumber for these scenario.

#### Below is the work flow of calling methods in this framework

Feature File >>>> Step Definition File >>>> Main File

For example: Feature file is created for zalando demo in which scenario is written in gherkin language.
This feature file calls step difinition file through glue code.
Then step definition file calls main zalando page file in which all methods are defined.

# Installation

### Linux Machine

If you’re on Fedora for example (or any closely-related RPM-based distro such as RHEL or CentOS), you can use below command to install Git:
##### $ sudo dnf install git-all

If you’re on a Debian-based distribution like Ubuntu, try apt-get:
##### $ sudo apt-get install git-all

Install Maven
#### $ sudo apt-get install maven

1. Clone the project from below location:

https://github.com/vishalverma21/ZalandoDemo.git

2. Go to source folder in local machine

ZalandoDemo

3. Run " mvn test " command in source folder " ZalandoDemo " from your maven or git bash
mvn test
