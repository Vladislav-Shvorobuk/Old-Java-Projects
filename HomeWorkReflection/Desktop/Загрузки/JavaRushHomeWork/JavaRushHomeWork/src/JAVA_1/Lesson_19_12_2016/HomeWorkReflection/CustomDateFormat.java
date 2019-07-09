package JAVA_1.Lesson_19_12_2016.HomeWorkReflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Created by м on 12.01.2017.
 */
@Target(ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface CustomDateFormat {
    String format ();
}
