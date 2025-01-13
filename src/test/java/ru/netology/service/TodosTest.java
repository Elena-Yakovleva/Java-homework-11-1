package ru.netology.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodosTest {
    Todos todos = new Todos();

    SimpleTask simpleTask1 = new SimpleTask(5, "Позвонить родителям");
    SimpleTask simpleTask2 = new SimpleTask(7, "Написать письмо");
    SimpleTask simpleTask3 = new SimpleTask(8, "Оплатить счет");

    String[] subtasks1 = {"Молоко", "Яйца", "Хлеб"};
    Epic products = new Epic(55, subtasks1);

    String[] subtasks2 = {"Русский язык", "Литература", "Физика", "География"};
    Epic lessons = new Epic(59, subtasks2);

    String[] subtasks3 = {"Полицейская академия 3", "Крепкий орешек", "Такси"};
    Epic films = new Epic(53, subtasks3);

    Meeting meeting1 = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );
    Meeting meeting2 = new Meeting(
            716,
            "Java-dz-project",
            "Добавить дз к лекции 13",
            "До четверга"
    );

    @BeforeEach
    public void setup1() {
        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(simpleTask3);
    }

    @BeforeEach
    public void setup2() {
        todos.add(products);
        todos.add(lessons);
    }

    @BeforeEach
    public void setup3() {
        todos.add(meeting1);
        todos.add(meeting2);
    }


    @Test
    public void shouldAddThreeTasksOfDifferentType() {

        Task[] expected = {simpleTask1, simpleTask2, simpleTask3, products, lessons, meeting1, meeting2};
        Assertions.assertArrayEquals(expected, todos.findAll());
    }

    @Test
    public void shouldFindWordInSimpleTask() {
        todos.search("Написать");

        Task[] expected = {simpleTask2};
        Assertions.assertArrayEquals(expected, todos.findAll());
    }

    @Test
    public void shouldFindWordInEpic() {
        todos.search("Литература");

        Task[] expected = {lessons};
        Assertions.assertArrayEquals(expected, todos.findAll());
    }

    @Test
    public void shouldFindWordInMeetingTitle() {
        todos.search("Выкатка");

        Task[] expected = {meeting1};
        Assertions.assertArrayEquals(expected, todos.findAll());
    }

    @Test
    public void shouldFindWordInMeetingProject() {
        todos.search("дз");

        Task[] expected = {meeting2};
        Assertions.assertArrayEquals(expected, todos.findAll());
    }

}