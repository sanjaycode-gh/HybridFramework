package automation.Utils;

public enum TestCases {

    T1("Testing the login functionality with valid credentials"),
    T2("Testing the purchase of one Sauce Labs Backpack");

    private String testName;
    TestCases(String value){
        this.testName = value;
    }

    public String getTestName() {
        return testName;
    }
}
