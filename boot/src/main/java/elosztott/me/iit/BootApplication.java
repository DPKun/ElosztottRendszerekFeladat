package elosztott.me.iit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@SpringBootApplication
@EnableAutoConfiguration
@EnableWebMvc
@ImportResource({"classpath:/security.xml"})
@ComponentScan(basePackages = {"elosztott.me.iit"})
public class BootApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BootApplication.class);
	}
	
	/*//JSP resolver
	@Bean
	public InternalResourceViewResolver jspViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
	       resolver.setSuffix(".jsp");
	       return resolver;
	}*/
	

	public static void main(String[] args) throws Exception {
		SpringApplication.run(BootApplication.class, args);
	}

}