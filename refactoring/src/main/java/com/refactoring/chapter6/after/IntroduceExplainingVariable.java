package com.refactoring.chapter6.after;

public class IntroduceExplainingVariable {
    private String platform;
    private String browser;
    private int resize;

    private void method() {
        final boolean isMacOs = platform.toUpperCase().indexOf("MAC") > -1;
        final boolean isIEBrowser = browser.toUpperCase().indexOf("IE") > -1;
        final boolean wasResized = resize > 0;

        if(isMacOs && isIEBrowser && wasInitialized() && wasResized) {
        }
    }

    private boolean wasInitialized() {
        return false;
    }
}
