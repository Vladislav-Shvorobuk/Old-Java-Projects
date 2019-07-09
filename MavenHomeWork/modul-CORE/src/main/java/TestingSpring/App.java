package TestingSpring;


import TestingSpring.impl.Robocop;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by м on 27.01.2017.
 */
public class App {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring/dao-context.xml");

        Robocop robocop = (Robocop) context.getBean(Robocop.class);
        robocop.on();
        robocop.of();
    }

}
