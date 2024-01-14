/************************************************
 *
 *  Copyright �2023
 *  AP Software Services
 *
 *  @project: zajecia
 *  @subproject: zajecia-webapp
 *
 *  @author: Andrzej Piechocki
 *           <br/>
 \*           andrzej.piechocki@software.com
 *
 *  Created: 2023-12-06
 *
 *****************************************************/
package com.software.conf;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

@Configuration
@EnableWebMvc
@EnableJpaRepositories("com.software.dao")
@ComponentScan(basePackages = { "com.software.controller", "com.software.service","com.software.dao" })
public abstract class ViewConf
extends WebMvcConfigurerAdapter {

  @Override
  public void addResourceHandlers(final ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
  }

  @Bean
  public TilesConfigurer tilesConfigurer() {
    final TilesConfigurer tilesConfigurer = new TilesConfigurer();
    tilesConfigurer.setDefinitions(new String[] { "/WEB-INF/defs/tiles.xml" });
    tilesConfigurer.setCheckRefresh(true);
    tilesConfigurer.setPreparerFactoryClass(org.springframework.web.servlet.view.tiles3.SpringBeanPreparerFactory.class);
    return tilesConfigurer;
  }

  @Bean
  public ViewResolver viewResolver() {
    final UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
    viewResolver.setViewClass(org.springframework.web.servlet.view.tiles3.TilesView.class);
    return viewResolver;
  }
  

  @Bean
  public MessageSource messageSource() {
      final ReloadableResourceBundleMessageSource ret = new ReloadableResourceBundleMessageSource();
      ret.setBasename("classpath:messages");
      ret.setDefaultEncoding("UTF-8");
      return ret;
  }
    
    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer () {
        return new PropertySourcesPlaceholderConfigurer();
    }

  @Override 
  public void addInterceptors(InterceptorRegistry registry) { 
          registry.addInterceptor(localeChangeInterceptor()); 
  } 

  @Bean 
  public LocaleChangeInterceptor localeChangeInterceptor() { 
          LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor(); 
          localeChangeInterceptor.setParamName("language"); 
          return localeChangeInterceptor; 
  } 

  @Bean 
  public CookieLocaleResolver localeResolver() { 
          CookieLocaleResolver localeResolver = new CookieLocaleResolver(); 
          Locale defaultLocale = new Locale("en"); 
          localeResolver.setDefaultLocale(defaultLocale); 
          return localeResolver; 
  } 
}