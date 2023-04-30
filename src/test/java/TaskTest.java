import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    public void testMatchesForSimpleTaskWhenTrue(){
        SimpleTask task = new SimpleTask(5, "Позвонить родителям");

        boolean actual = task.matches("родителям");
        Assertions.assertTrue(actual);
    }
    @Test
    public void testMatchesForSimpleTaskWhenFalse(){
        SimpleTask task = new SimpleTask(5, "Позвонить родителям");

        boolean actual = task.matches("бабушке");
        Assertions.assertFalse(actual);
    }




    @Test
    public void testSearchWhenFewTasksFounded(){
        SimpleTask simpleTask = new SimpleTask(5, "купить хлеб");
        String[] subtasks = {"молоко","яйца", "хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic};
        Task[] actual = todos.search("хлеб");
        Assertions.assertArrayEquals(expected, actual);
    }


}