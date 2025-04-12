package com.pip.offer;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class OfferApplication extends Application<OfferConfiguration> {
    public static void main(String[] args) throws Exception {
        new OfferApplication().run(args);
    }

    @Override
    public void run(OfferConfiguration config, Environment env) {
        env.jersey().register(new OfferResource());
    }
}
