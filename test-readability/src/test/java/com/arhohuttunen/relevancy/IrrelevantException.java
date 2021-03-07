package com.arhohuttunen.relevancy;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class IrrelevantException {
    @Test
    void unnecessaryCatching() {
        try {
            URL url = new URL("http://localhost");

            assertEquals("http", url.getProtocol());
        } catch (MalformedURLException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void noNeedToCatch() throws MalformedURLException {
        URL url = new URL("http://localhost");

        assertEquals("http", url.getProtocol());
    }
}
