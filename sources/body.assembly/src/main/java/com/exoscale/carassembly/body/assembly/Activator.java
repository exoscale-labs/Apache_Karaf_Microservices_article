package com.exoscale.carassembly.body.assembly;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator implements BundleActivator {

	private final static Logger LOGGER = LoggerFactory.getLogger(Activator.class);

	public void start(BundleContext arg0) throws Exception {
		LOGGER.info("Starting car body assembly ...");
	}

	public void stop(BundleContext arg0) throws Exception {
		LOGGER.info("Stopping car body assembly ...");
	}

}
