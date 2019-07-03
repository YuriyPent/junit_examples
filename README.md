# JUnit examples
### Hello World Example
[JUnit](https://junit.org/junit4/) contains many annotations that are
used while creating test cases.
* `@BeforeClass`: It is used to write code that we want to run before all test cases.
* `@Before`: It will run before every test case.
* `@Test`: This is actual test case.
* `@After`: It will run after every test case.
* `@AfterClass`: It is used to write code that we want to run after all test cases.

Right click on JUnitHelloWorldTest and Run As → JUnit Test

### JUnit Tutorial for Beginners
Observing the JUnit Test cases.
* Using `@Test` to deﬁne a test method
* Put them all on the Test package (`src/test/main/`)
* Class always has a sufﬁx of Test (`AccountServiceImplTest`)
* Methods always starts with "test".
### Categories Example
JUnit has an awesome feature of organizing group of test cases called Categorizing. It can help developers differentiate test cases
from one another. In this post, I’ll showcase how easy it is to categorize unit tests by `@Category`.

Deﬁne the interfaces ﬁrst. In order for us to group test cases, we need to create a uniﬁer/union on them. We use interface
class to tag a speciﬁc class or method to a group. Here are the interfaces that we will use in this example.
Interfaces:
```java
public interface FunctionalGroupTests1 {}
public interface FunctionalGroupTests2 {}
public interface IntegrationTests {}
public interface SanityTests {}
```
We then use those interfaces on our test cases. This will differentiate the test case for our own test purposes. In the example
below, we tag tests method by category using the `@Category` annotation.

We can run speciﬁc test case category by running the commands in Maven below. 
* `mvn test -Dgroups="com.areyes.junit.cat.intf.FunctionalGroupTests1, com.areyes.junit.cat.intf.FunctionalGroupTests2"`
* `mvn test -Dgroups="com.areyes.junit.cat.intf.IntegrationTests, com.areyes.junit.cat.intf.SanityTests"`
Alternatively, we can run tests by proﬁle. We need to update our pom.xml and add a new proﬁles. We will then use these proﬁles
and tag the categories we created to each as shown below.
pom.xml
```xml
<project
    xmlns="https://maven.apache.org/POM/4.0.0"
    xmlns:xsi="https://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="https://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.jgc.areyes.junit</groupId>
    <artifactId>junit-categories-example</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.17</version>
                <dependencies>
                    <dependency>
                        <groupId>org.apache.maven.surefire</groupId>
                        <artifactId>surefire-junit47</artifactId>
                        <version>2.17</version>
                    </dependency>
                </dependencies>
                <configuration>
                    <groups>${testcase.groups}</groups>
                    <excludes>
                        <exclude>${exclude.tests}</exclude>
                    </excludes>
                    <includes>
                        <include>${include.tests}</include>
                    </includes>
                </configuration>
            </plugin>
        </plugins>
    </build>
    <profiles>
        <profile>
            <id>sanityTests</id>
            <properties>
                <testcase.groups>com.areyes.junit.svc.SanityTests</testcase.groups>
            </properties>
        </profile>
        <profile>
            <id>functionalGroupTests1</id>
            <properties>
                <testcase.groups>com.areyes.junit.svc.FunctionalGroupTests1</testcase.groups>
            </properties>
        </profile>
        <profile>
            <id>functionalGroupTests2</id>
            <properties>
                <testcase.groups>com.areyes.junit.svc.FunctionalGroupTests2</testcase.groups>
            </properties>
        </profile>
        <profile>
            <id>integrationTests</id>
            <properties>
                <testcase.groups>com.areyes.junit.svc.IntegrationTests</testcase.groups>
            </properties>
        </profile>
    </profiles>
    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project> 
```
Run them by using the following maven command: `mvn test -pfunctionalGroupTests1`
### Disable Test Example
There are instances that our test cases aren’t ready yet and it would almost be certain that when we run our builds with these,
there is a high probability that our test executions will fail. 
This can be avoided using the `@Ignore` annotation.

Developers sometimes just pass the test case to avoid build failures (assert(true)). This is a bad practice and should be avoided.
The `@Ignore` annotation is a better alternative as it will allow the runner to just ignore the test case ensuring that it won’t be
part of the build run.

This annotation can be used by developers to tag a speciﬁc test case as disabled. This means that even if we run our builds, the
JUnit test runner won’t bother running them since it assumes that it’s not yet ready or intentionally disabled.
### MultiThreaded Test Example
This is an example, where a counter is to be accessed and updated by many threads simultaneously. JUnit MultiThread example shows very basic usage.

[Concurrent-junit](https://github.com/ThomasKrieger/concurrent-junit) library helps the users to test the methods for multi threading. It will create threads for testing methods. By
default, number of threads created by this library is `4`, but we can set the desired number of threads. 
This can be achieved by `@ThreadCount` annotation of concurrent-junit.
### Keyboard Input Example
This example is very useful in case users want to
enter data from keyboard for testing of their methods.  
### Group Tests Example
In this example we shall show users, how they can group and run their JUnit test cases. JUnit group tests example, will try to
resolve issue of running multiple group tests all together. This is not a big deal in JUnit.
This can be achieved in different ways in JUnit. It’s wide API, helps developers all around the world to achieve the ﬂexibility to
test their methods.

There are 2 approaches in JUnit to group test the methods.
 #### @RunWith(Suite.class)
This annotation is helpful whenever we want to test multiple classes at once. In this case we do not need to run each individual
class for testing. Simply run the class with `@RunWith(Suite.class)` annotation and it will take care of running all your
test cases one by one.

Since, we have included all our classes in `@SuiteClasses()` annotation, all test cases of every class runs. We can modify it
to run our speciﬁc classes also.
It is very convenient to run in these types of scenarios. But when you want more complicated test cases like some speciﬁc test
cases to run from a class, or you want to run some type of test cases all together, then you need a more control over your test
cases.
In JUnit 4.8, the concept of categories is introduced.
#### @RunWith(Categories.class)
Another way of running test suite is with `@RunWith(Categories.class)` annotation. This is more organized way of
running your test cases. By this way, users have more control over test cases. 

`@Category` interface is used for this purpose. It
works more like a marker interface, where we mark the test cases with it.

JUnit Group Tests example provides, the way to test the JUnit test cases in more organized way. Users have learnt how they can
achieve this by using 2 scenarios.
Firstly, by using the `@RunWith(Suite.class)` annotation.
Secondly, with the use of `@RunWith(Categories.class)` annotation.
### RunListener Example
There are cases when we want to respond to the events during a test case run. Here we can extend the RunListener class and override the methods
according to our implementation. The JUnit RunListener can listen to the events of the JUnit lifecycle.
If somehow, listener throws an error, then it will be removed from remainder of the test case run.

By using a custom listener in JUnit we can log and do tasks accordingly on the basis of
methods executed. Like, if you want to call or notify the user that a particular test case is failed, you can simply write that piece
of code in `testFailure()` method.
It is also very useful in logging purpose.
### Hamcrest Example
[Hamcrest](https://hamcrest.org/) is a open source framework matcher library used in various language to match expression for your test cases. You can
visit github page if you want to explore the code of it.
Hamcrest has a very rich library of methods to fulﬁll our needs. It is used with different testing frameworks like JUnit and jMock.
Hamcrest is typically viewed as a third generation matcher framework.
* First Generation: `It typically uses assert(some statement). In this case tests are not easily readable`.
* Second Generation: `It uses the special methods such as assertEquals() for test. But this approach creates a lots of assert
methods`.
* Third Generation: `It uses assertThat() method for test. It is more ﬂexible and covers most of the scenarios. The beneﬁt
is that you still get ﬂuent error messages when the assertion fails, but now you have greater extensibility`.
### Report Generation Example
JUnit helps us in validation our methods for functionality. But in some cases we have to see the report also for the test cases. In
the process of developing reports, Maven plays an important role as it will make a text, XML and also HTML reports. All JUnit
test cases with the details are printed in the reports. We will see in this example how this can be achieved.
However, reports can be generated in many different ways like with Ant, TestNG and other independent libraries. But we will
focus on very simple case i.e. with the help of Maven.

First of all we need to put the dependencies for our project. Simply put the following line in the pom.xml ﬁle.
```xml
<dependencies>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
    </dependency>
</dependencies>
<properties>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
</properties>
<reporting>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-report-plugin</artifactId>
            <version>2.19.1</version>
        </plugin>
    </plugins>
</reporting>
```
To generate a report: `mvn clean install test surefire-report:report`
