package com.juaracoding.utils;

public enum ScenarioTests {

    T1("Successful login with valid credentials"),
    T2("Failed login with invalid credentials"),
    T3("Failed login with invalid credentials"),
    T4("Failed login with invalid credentials"),
    T5("Failed login with invalid credentials"),
    T6("Add product to cart"),
    T7("Successful to complete checkout process"),
    T8("Failed to finish checkout process"),
    T9("Forget to fill all identity requirement"),
    T10("Forget to fill all identity requirement"),
    T11("Forget to fill all identity requirement");

    private String scenarioTestName;

    ScenarioTests(String value){
        scenarioTestName = value;
    }

    public String getScenarioTestName(){
        return scenarioTestName;
    }
}
