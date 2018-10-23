package hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties
//@PropertySource("classpath:application.properties")
@ImportResource({"classpath:*-config.xml"})
public class AppConfig {

	@Value("${field1}")
	private String field1;

	public String getField1() {
		return field1;
	}

	public void setField1(final String field1) {
		this.field1 = field1;
	}

}
