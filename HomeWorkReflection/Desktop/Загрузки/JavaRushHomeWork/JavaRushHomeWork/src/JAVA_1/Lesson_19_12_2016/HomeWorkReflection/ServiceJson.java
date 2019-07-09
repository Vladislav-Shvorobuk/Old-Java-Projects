package JAVA_1.Lesson_19_12_2016.HomeWorkReflection;

import java.io.*;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
 * Created by м on 20.01.2017.
 */
public class ServiceJson {

    static String jsonString = "";

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, IOException, InstantiationException {

        Human human = new Human("Ivan", "Ivanov", "Guitar", LocalDate.of(1989, Month.SEPTEMBER, 16));
        toJson(human);
        fromJson(jsonString, human);
    }

    public static void toJson(Object o) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException {

        jsonString = "{";

        for (Field field : o.getClass().getDeclaredFields()) {
            field.setAccessible(true);

            if (field.isAnnotationPresent(JsonValue.class)) {
                jsonString = jsonString + "\"" + field.getAnnotation(JsonValue.class).name() + "\":" +
                        " \"" + (String) field.get(o) + "\", ";
            } else if (field.isAnnotationPresent(CustomDateFormat.class)) {
                LocalDate date = (LocalDate) field.get(o);
                jsonString = jsonString + "\"" + field.getName() + "\":" + " \"" +
                        date.format(DateTimeFormatter.ofPattern(field.getAnnotation(CustomDateFormat.class).format())) + "\"";
            } else {
                jsonString = jsonString + "\"" + field.getName() + "\":" + " \"" + (String) field.get(o) + "\", ";
            }
        }
        jsonString += "}";
        System.out.println("Пример работы метода toJson: " + "\n" +jsonString + "\n");
    }

    public static void fromJson(String Json, Object o) throws NoSuchFieldException, IllegalAccessException, InstantiationException {

        String regax = "(\\{|}|\\\"| \\\\s|:)";
        String[] strings = Json.replaceAll(regax, "").split(", ");

        for (String string : strings) {

            String[] pair = string.split(" ");
            String fieldName = pair[0];
            String value = pair[1];

            if (fieldName.equals("fun")) {
                fieldName = "hobby";
            }
            Field field = o.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);

            if (fieldName.equals("birthDate")) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
                LocalDate date = LocalDate.parse(value, formatter);
                field.set(o, date);
            } else field.set(o, value);
    }
        System.out.println("Пример работы метода fromJson :" + "\n" + o);

    }
}

