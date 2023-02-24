package by.elena.springcourse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


//обязательно помещаем анннотацией @Controller класс для Spring
@Controller
public class HelloController {

    //Создаем метод, который будет вовращать строку hello_world
    //помечаем анннотацию @GetMapping и указываем какой url будет приходить в этот метод контролера

    @GetMapping("/hello-world") //указываем url hello-world
    public String sayHello() {
        return "hello_world"; //hello_world должно находиться во views, его нужно создать webapp/WEB-INF
        //просто вернем представление пользователю

    }
}
