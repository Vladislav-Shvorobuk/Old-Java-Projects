package JAVA_1.Lesson_19_12_2016.HomeWorkReflection;


import java.io.*;
import java.time.LocalDate;

/**
 * Created by м on 12.01.2017.
 * Reflection API Hometask
 * Реализовать функционал сериализации данных с переданных файлов в формат JSON.
 * Результатом задания должен быть сервис с методом toJson(Object o), который может
 * принимать любой объект и возвращать его JSON представление.
 * Например:
 * class Human {
 * private String firstName;
 * private String lastName
 * <p>
 * name = “fun”)
 * private Stri@JsonValue(nng hobby;
 *
 * @CustomDateFormat(format = “ddMMyyyy”)
 * private LocalDate birthDate;
 * ……….
 * }
 * будет преобразован в
 * {
 * "firstName": "Ivan",
 * "lastName": "Ivanov",
 * "fun": "Guitar",
 * "birthDate": "01091990"
 * }
 * Для сериализации учитывать следующие моменты:
 * 1. если поле класа не помечено дополнительной аннотацией, то имя элемента в
 * JSON результате должно быть таким же как и имя поля
 * 2. если поле содержит аннотацию @JsonValue, то имя JSON элемента должно
 * соответствовать имени, указанному в аннотации.
 * 3. аннотация @CustomDateFormat должна задовать форматированный вывод
 * формата времени. Если есть поле даты, но без указанного формата использовать
 * формат по умолчания (вывод через toString)
 * 4. Аннотации @JsonValue и @CustomDateFormat должны быть написаны
 * самостоятельно
 * 5. если поле класса не имеет значение (null), то в результирующем JSON’е не
 * должно быть такого элемента
 * 6. Опционально. Реализовать механизм вычитки данных из строки JSON’а.
 * Реализовать метод fromJson(String json, Class<T> clazz), где json входящая
 * JSON
 */
public class Human implements Serializable {
    private String firstName;
    private String lastName;
    @JsonValue()
    private String hobby;
    @CustomDateFormat(format = "ddMMyyyy")
    private LocalDate birthDate;

    public Human(String firstName, String lastName, String hobby, LocalDate birthdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hobby = hobby;
        this.birthDate = birthdate;
    }

    @Override
    public String toString() {
        return  "firstName " + firstName  + "\n" +
                "lastName " + lastName + "\n" +
                "hobby " + hobby  + "\n" +
                "birthDate " + birthDate;
    }
}
