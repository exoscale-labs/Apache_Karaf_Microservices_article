package com.exoscale.carassembly.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Path;

import org.apache.cxf.dosgi.common.api.IntentsProvider;
import org.osgi.service.component.annotations.Component;

import com.exoscale.carassembly.config.api.ConfigService;
import com.exoscale.carassembly.config.api.model.Config;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

@Path("config")
@Component(service = ConfigService.class, immediate = true, property = //
{ //
		"service.exported.interfaces=*", //
		"service.exported.configs=org.apache.cxf.rs", //
		"org.apache.cxf.rs.address=/api", //
		"cxf.bus.prop.skip.default.json.provider.registration=true"//,
} //
)
public class GeneralConfigService implements ConfigService, IntentsProvider {

	private HashMap<String, Config> configuration = new HashMap<>();

	public Config get(Config config) {
		if(config.getKey() == null) {
			throw new RuntimeException("No key specified");
		}

		return configuration.get(config.getKey());
	}

	public Config remove(Config config) {
		if(config.getKey() == null) {
			throw new RuntimeException("No key specified");
		}

		return configuration.remove(config.getKey());
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
