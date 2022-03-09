package com.atmo.authentication;

import com.atmo.authentication.view.StudentView;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    public static Bundle bundle;

    public void start(BundleContext context) {
        System.out.println("Starting the bundle");
        bundle = context.getBundle();
        StudentView.selectChoice();
    }

    public void stop(BundleContext context) {
        System.out.println("Stopping the bundle");
    }
}