package coursConfig;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.xml.xsd.XsdSchemaException;


@EnableWs
@Configurable
public class webserviceConfig extends WsConfigurerAdapter {
	
	@Bean
	 public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
	 MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
	 messageDispatcherServlet.setApplicationContext(context);
	 messageDispatcherServlet.setTransformWsdlLocations(true);
	 return new ServletRegistrationBean(messageDispatcherServlet,"/ws/*");
	 }
	
	@Bean(name = "courseDetails")
	 public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema coursSchema) {
	DefaultWsdl11Definition definition = new DefaultWsdl11Definition();

	 definition.setPortTypeName("CourseDetailsPort");
	 definition.setTargetNamespace("http://www.example.org/cours");
	 definition.setLocationUri("/ws");
	 definition.setSchema(coursSchema);
	 return definition;
	 }
	
	 @Bean
	 public SimpleXsdSchema courseDetailsSchema() {
	             return new SimpleXsdSchema(new ClassPathResource("cours.xsd"));
     }
}