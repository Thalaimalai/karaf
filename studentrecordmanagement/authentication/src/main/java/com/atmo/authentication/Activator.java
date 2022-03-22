package com.atmo.authentication;

import com.atmo.authentication.view.StudentView;
import com.atmo.database.connection.DatabaseConnection;
import com.atmo.studentrecord.controller.StudentRestControllerImpl;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import org.apache.cxf.BusFactory;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

import java.util.Map;

/**
 * Activator class to get the server for API.
 *
 * @author ThalaimalaiPandiyanT
 *
 */
@Component(immediate = true, name = "database")
public class Activator {

    public static Bundle bundle;
    private Server server;

    /**
     * Get the server to call API.
     *
     * @param properties
     * @param context
     */
    @Activate
    public void activate(Map<String, String> properties, BundleContext context) {

        try {
            DatabaseConnection.dataBaseProperty(properties);
            JAXRSServerFactoryBean bean = new JAXRSServerFactoryBean();
            bean.setAddress("/record");
            bean.setBus(BusFactory.getDefaultBus());
            bean.setProvider(new JacksonJsonProvider());
            bean.setServiceBean(new StudentRestControllerImpl());

            server = bean.create();
            bundle = context.getBundle();

            StudentView.selectChoice();
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    /**
     * Deactivate the API server.
     */
    @Deactivate
    public void deactivate() {

        try {
            if (server != null) {
                server.destroy();
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}