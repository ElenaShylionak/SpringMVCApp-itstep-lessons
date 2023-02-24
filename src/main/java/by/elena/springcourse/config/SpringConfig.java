package by.elena.springcourse.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

//Java конфирурация полностью эквивалентна файлу wapplicationContextMVC.xml
    @Configuration
    @ComponentScan("by.elena.springcourse")
    @EnableWebMvc
    //EnableWebMvc равноценна тегу MVCdriven. У нас MVC приложение, которое поодерживает web -функции, поэтому эта аннотация нужна
    public class SpringConfig implements WebMvcConfigurer { //WebMvcConfigurer реализуется тогда, когда мы хотим под себя подстроить SpringMVC
        //в данном случае мы используем этот интерфейс, чтобы настроить Thymeleaf

        private final ApplicationContext applicationContext; //applicationContext будет внедрен Spring

        @Autowired
        public SpringConfig(ApplicationContext applicationContext) {
            this.applicationContext = applicationContext;
        }

        //отвечает за шаблонизацию Thymeleaf
        @Bean
        public SpringResourceTemplateResolver templateResolver() {
            SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
            templateResolver.setApplicationContext(applicationContext); //applicationContext нужен для настройки Thymeleaf
            templateResolver.setPrefix("/WEB-INF/views/"); //путь где будут наши представления (view)
            templateResolver.setSuffix(".html"); //расширение представлений
            return templateResolver;
        }

        @Bean
        public SpringTemplateEngine templateEngine() {
            SpringTemplateEngine templateEngine = new SpringTemplateEngine();
            templateEngine.setTemplateResolver(templateResolver());
            templateEngine.setEnableSpringELCompiler(true);
            return templateEngine;
        }
        //Вместо стандартного шаблонизатора использовать Thymeleaf
        @Override
        public void configureViewResolvers(ViewResolverRegistry registry) {
            ThymeleafViewResolver resolver = new ThymeleafViewResolver();
            resolver.setTemplateEngine(templateEngine());
            registry.viewResolver(resolver);
        }
    }

