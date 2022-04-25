package ru.LearnUp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.LearnUp.event.EventPub;


import java.util.Locale;
import java.util.Scanner;

@Slf4j
@SpringBootApplication
public class SpringBootTestApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootTestApplication.class, args);
        Locale locale = Locale.getDefault();
        Scanner scanner = new Scanner(System.in);
        Integer number = (int) (Math.random() * 1000);
        System.out.println(number);
        EventPub pub = context.getBean(EventPub.class);
        pub.pubEvent(context.getMessage("hi", null, locale));
        int inputNumber = scanner.nextInt();
        while (inputNumber != number) {
            if (inputNumber < number) {
                pub.pubEvent(context.getMessage("bigger", null, locale));
            }
            if (inputNumber > number) {
                pub.pubEvent(context.getMessage("less", null, locale));
            }
            pub.pubEvent(context.getMessage("condition", null, locale));
            inputNumber = scanner.nextInt();
        }

        pub.pubEvent(context.getMessage("guessed", new Object[]{number.toString()}, locale));
    }
}
