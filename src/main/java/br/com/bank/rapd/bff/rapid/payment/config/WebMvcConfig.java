package br.com.bank.rapd.bff.rapid.payment.config;

//import br.com.bank.enge.logcloud.api.SrvCanalLoggerFactory;
//import br.com.bank.enge.logcloud.canal.SrvCanalLogger;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration(proxyBeanMethods = false)
public class WebMvcConfig implements WebMvcConfigurer {

//    @Bean
//    public SrvCanalLogger getLogSrvCanalLogger() {
//        return SrvCanalLoggerFactory.getLogger(LogServicoCanal.class);
//    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggerInterceptor());
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        ApplicationConversionService.configure(registry);
    }

	@Bean
	public RequestContextListener requestContextListener() {
		return new RequestContextListener();
	}
}
