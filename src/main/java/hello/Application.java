package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.Resource;
import java.util.Map;

@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan("hello")
public class Application {

	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
