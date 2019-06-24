package com.exoscale.carassembly.body.assembly.services;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

import com.exoscale.carassembly.config.api.ConfigService;

@Component
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

	@Reference(name = "config", service = ConfigService.class, cardinality = ReferenceCardinality.MANDATORY, policy = ReferencePolicy.STATIC, unbind = "unbindConfigService")
	public void bindConfigService(ConfigService config) {
		System.out.println("Config bound: " + config);
		this.configService = config;
	}

	public void unbindConfigService(ConfigService config) {
		this.configService = null;
	}

}
