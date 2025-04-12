package com.pip.offer;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Environment;
import io.dropwizard.db.DataSourceFactory;
import org.jdbi.v3.core.Jdbi;

public class OfferApplication extends Application<Configuration> {

    @Override
    public void run(Configuration configuration, Environment environment) {
        final JdbiFactory factory = new JdbiFactory();
        final DataSourceFactory dataSourceFactory = ((OfferConfiguration) configuration).getDataSourceFactory();

        final Jdbi jdbi = factory.build(environment, dataSourceFactory, "postgresql");

        final OfferDAO offerDAO = jdbi.onDemand(OfferDAO.class);
        environment.jersey().register(new OfferResource(offerDAO));
    }

    public static void main(String[] args) throws Exception {
        new OfferApplication().run(args);
    }
}
