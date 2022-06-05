package com.refactoring.chapter6.before;

public class IntroduceExplainingVariable {
    private String platform;
    private String browser;
    private int resize;

    private void method() {
        if(platform.toUpperCase().indexOf("MAC") > -1 &&
                browser.toUpperCase().indexOf("IE") > -1 &&
                wasInitialized() && resize > 0) {
        }
    }

    private boolean wasInitialized() {
        return false;
    }
}
