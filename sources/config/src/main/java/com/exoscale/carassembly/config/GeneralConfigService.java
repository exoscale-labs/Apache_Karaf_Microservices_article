package com.exoscale.carassembly.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.cxf.dosgi.common.api.IntentsProvider;
import org.osgi.service.component.annotations.Component;

import com.exoscale.carassembly.config.api.ConfigService;
import com.exoscale.carassembly.config.api.model.Config;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

@Component(service = ConfigService.class, immediate = true, property = //
{ //
		"service.exported.interfaces=*", //
		"service.exported.configs=org.apache.cxf.rs", //
		"org.apache.cxf.rs.address=/api", //
		"cxf.bus.prop.skip.default.json.provider.registration=true"//,
} //
)
public class GeneralConfigService implements ConfigService, IntentsProvider {

	private static HashMap<String, Config> configuration = new HashMap<>();

	public Config get(String key) {
		if(key == null) {
			throw new RuntimeException("No key specified");
		}
		
		return configuration.get(key);
	}

	public Config remove(String key) {
		if(key == null) {
			throw new RuntimeException("No key specified");
		}

		return configuration.remove(key);
	}

	public Config add(Config config) {
		if(config.getKey() == null) {
			throw new RuntimeException("No key specified");
		}
		configuration.put(config.getKey(), config);
		return config;
	}

	@Override
	public List<?> getIntents() {
		return Arrays.asList(new JacksonJaxbJsonProvider());
	}

}
