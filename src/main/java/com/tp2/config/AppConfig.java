package com.tp2.config;

import com.tp2.Interceptors.MyInterceptor1;
import com.tp2.Interceptors.MyInterceptor2;
import com.tp2.utils.tpClasses.CalculAgeImpl;
import com.tp2.utils.GestionPeronnes;
import com.tp2.utils.tpClasses.CalculAgeMoisImpl;
import com.tp2.utils.tpClasses.CompareAgeImpl;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


//Configuration d'une application Spring MVC (@EnableWebMvc)
//Avec support des transactions (@EnableTransactionManagement)

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.tp2" })
public class AppConfig implements WebMvcConfigurer {
    /** Utilisé pour la journalisation */
    private Logger LOGGER = Logger.getLogger(getClass().getName());

    public AppConfig() {
        LOGGER.info(" configuration init...");
    }

    // Configuration du ViewResolver

    @Bean
    public ViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");
        return bean;
    }

    @Bean
    MyInterceptor1 myInterceptor1() {
        return new MyInterceptor1();
    }

    @Bean
    MyInterceptor2 myInterceptor2() {
        return new MyInterceptor2();
    }

    @Bean
    CalculAgeImpl calculAge(){
        return new CalculAgeImpl();
    }

    @Bean
    GestionPeronnes gestionPeronnes(){
        return new GestionPeronnes();
    }

    @Bean
    CompareAgeImpl compareAge(){
        return  new CompareAgeImpl();
    }

    @Bean
    CalculAgeMoisImpl calculAgeMois(){
        return  new CalculAgeMoisImpl();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor1()).addPathPatterns("/exo1/private");
        registry.addInterceptor(myInterceptor2()).addPathPatterns("/exo1/private");
    }



}