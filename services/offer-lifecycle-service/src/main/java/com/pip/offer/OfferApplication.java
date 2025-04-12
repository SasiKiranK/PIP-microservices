package com.pip.offer;

import io.dropwizard.Application;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Environment;
import org.jdbi.v3.core.Jdbi;

public class OfferApplication extends Application<OfferConfiguration> {

    @Override
    public void run(OfferConfiguration configuration, Environment environment) {
        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql");

        final OfferDAO offerDAO = jdbi.onDemand(OfferDAO.class);
        environment.jersey().register(new OfferResource(offerDAO));
    }

    public static void main(String[] args) throws Exception {
        new OfferApplication().run(args);
    }
}
