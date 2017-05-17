package elosztott.me.iit;
import java.util.Locale;
 
 import org.springframework.context.MessageSource;
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.ComponentScan;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.context.support.ReloadableResourceBundleMessageSource;
 import org.springframework.ui.context.ThemeSource;
 import org.springframework.ui.context.support.ResourceBundleThemeSource;
 import org.springframework.web.servlet.LocaleResolver;
 import org.springframework.web.servlet.ThemeResolver;
 import org.springframework.web.servlet.config.annotation.EnableWebMvc;
 import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
 import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
 import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 import org.springframework.web.servlet.i18n.CookieLocaleResolver;
 import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
 import org.springframework.web.servlet.theme.CookieThemeResolver;
 import org.springframework.web.servlet.theme.ThemeChangeInterceptor;
 import org.springframework.web.servlet.view.InternalResourceViewResolver;
 
 @Configuration 
 @ComponentScan("elosztott.me.iit") 
 @EnableWebMvc
 public class AppConfiguration extends WebMvcConfigurerAdapter {
 
        @Bean  
           public InternalResourceViewResolver viewResolver() {  
               InternalResourceViewResolver resolver = new InternalResourceViewResolver();  
               resolver.setPrefix("/WEB-INF/jsp/");  
               resolver.setSuffix(".jsp");
               return resolver;  
           }
        
           /* Theme specific start */
          @Bean
           public ThemeSource themeSource() {
               ResourceBundleThemeSource source = new ResourceBundleThemeSource();
               source.setBasenamePrefix("theme-");
               return source;
           }
           @Bean 
           public ThemeResolver themeResolver(){
               CookieThemeResolver resolver = new CookieThemeResolver();
               resolver.setCookieMaxAge(2400);
               resolver.setCookieName("themecookie");
               resolver.setDefaultThemeName("light");
               return resolver;
           }
           /* End */
           
           /*Internationalization and Localization specific: start*/
           @Bean
           public MessageSource messageSource() {
               ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
               messageSource.setBasename("WEB-INF/languages/language");
               messageSource.setDefaultEncoding("UTF-8");
               return messageSource;
           }
           @Bean
           public LocaleResolver localeResolver(){
               CookieLocaleResolver resolver = new CookieLocaleResolver();
               resolver.setDefaultLocale(new Locale("en"));
               resolver.setCookieName("LocaleCookie");
               resolver.setCookieMaxAge(4800);
               return resolver;
           }
           /* End */
           
           //Register interceptors
           @Override
           public void addInterceptors(InterceptorRegistry registry) {
               //Internationalization and Localization specific
               LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
               interceptor.setParamName("lang");
               registry.addInterceptor(interceptor);
               //Theme specific
               ThemeChangeInterceptor themeInterceptor = new ThemeChangeInterceptor();
               themeInterceptor.setParamName("theme");
               registry.addInterceptor(themeInterceptor);
           }
           
           //Used to access CSS resource
           //@Override
     public void addResourceHandlers(final ResourceHandlerRegistry registry) {
               registry.addResourceHandler("/css/**").addResourceLocations("/css/");
               registry.addResourceHandler("/admin/css/**").addResourceLocations("/css/");
           }
 }