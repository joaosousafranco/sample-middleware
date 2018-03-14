package com.jsfsi;

import com.jsfsi.sample.extensibility.BvetMiddlewareConfiguration;
import com.jsfsi.lib.dropwizard.DropwizardConfiguration;

public class Configuration extends DropwizardConfiguration implements BvetMiddlewareConfiguration {
    private String sampleApiUrl;

    @Override
    public String getBvetApiUrl() {
        return sampleApiUrl;
    }

    @Override
    public void setBvetApiUrl(String sampleApiUrl) {
        this.sampleApiUrl = sampleApiUrl;
    }
}
