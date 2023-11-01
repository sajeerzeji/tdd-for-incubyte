package com.tdd.incubyte.tddforincubyte.config.log;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

public class TestLogger implements TestWatcher {
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String testName = context.getDisplayName();
        System.out.println("Test failed: " + testName);
        cause.printStackTrace();
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        String testName = context.getDisplayName();
        System.out.println("Test passed: " + testName);
    }
}
