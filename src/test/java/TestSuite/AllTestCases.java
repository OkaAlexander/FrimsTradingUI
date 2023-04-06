package TestSuite;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pageObject.AbstractPage;
import testCase.LandingPageTest;
import testCase.LoginTest;
import testCase.Test1;
import testCase.Test2;

@RunWith(Suite.class)
@Suite.SuiteClasses({LandingPageTest.class,LoginTest.class})
public class AllTestCases {
}
