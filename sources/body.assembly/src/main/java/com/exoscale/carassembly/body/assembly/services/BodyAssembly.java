package com.exoscale.carassembly.body.assembly.services;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.exoscale.carassembly.config.api.ConfigService;
import com.exoscale.carassembly.config.api.model.Config;

@Component(service=BodyAssembly.class)
public class BodyAssembly {

	private ConfigService configService;

	public void assemble() {
		assembleParts();
		triggerDoorsAssembly();
	}

	private void triggerDoorsAssembly() {
		// TODO Auto-generated method stub
	}

	private void assembleParts() {
		// TODO Auto-generated method stub
	}

	@Reference
	public void bindConfigService(ConfigService configService) {
		System.out.println("Config bound: " + configService);
		this.configService = configService;
		Config config = new Config();
		config.setKey("color");
		config.setValue("green");
		configService.add(config);
	}


}
