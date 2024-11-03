package com.juaracoding.utils;

public enum ScenarioTests {

    T1("Successful login with valid credentials"),
    T2("Failed login with invalid credentials"),
    T3("Failed login with invalid credentials"),
    T4("Failed login with invalid credentials"),
    T5("Add product to cart");

    private String scenarioTestName;

    ScenarioTests(String value){
        scenarioTestName = value;
    }

    public String getScenarioTestName(){
        return scenarioTestName;
    }
}
