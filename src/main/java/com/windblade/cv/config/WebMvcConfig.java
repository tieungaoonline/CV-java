package com.windblade.cv.config;

import com.windblade.cv.intercepter.UrlLocaleInterceptor;

import com.windblade.cv.intercepter.LogInterceptor;
import com.windblade.cv.resolver.UrlLocaleResolver;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
 
      
    @Bean(name = "localeResolver")
    public LocaleResolver getLocaleResolver()  {
//        CookieLocaleResolver resolver= new CookieLocaleResolver();
//        resolver.setCookieDomain("myAppLocaleCookie");
//        // 60 minutes 
//        resolver.setCookieMaxAge(60*60);
        LocaleResolver resolver = new UrlLocaleResolver();
     
        return resolver;
    } 
     
    @Bean(name = "messageSource")
    public MessageSource getMessageResource()  {
        ReloadableResourceBundleMessageSource messageResource= new ReloadableResourceBundleMessageSource();
         
        // Đọc vào file i18n/messages_xxx.properties
        // Ví dụ: i18n/messages_en.properties
        messageResource.setBasename("classpath:i18n/messages");
        messageResource.setDefaultEncoding("UTF-8");
        return messageResource;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    		
    		registry.addInterceptor(new LogInterceptor());
    	  UrlLocaleInterceptor localeInterceptor = new UrlLocaleInterceptor();
    	  
          registry.addInterceptor(localeInterceptor).addPathPatterns("/en/*", "/vi/*");
    }
/*    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //
        // Access Bootstrap static resource:
        //
        // http://somedomain/SomeContextPath/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css
        //
        registry.addResourceHandler("/webjars/**") //
                .addResourceLocations("classpath:/static/");
    }*/
    
     
}