package by.elena.springcourse.config;

//Java конфирурация полностью эквивалентна файлу web.xml

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherSerlvetIntitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() { //этот метод не иупользуется, поэтому ничего не меняем
        return null;
    }

    //указываем, где находиться конфирурациионный класс {SpringConfig.class}
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; //все запросы от пользователя будут приходить на DispatcherServlet
    }

}
