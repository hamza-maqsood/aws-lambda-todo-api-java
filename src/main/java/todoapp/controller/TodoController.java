package todoapp.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import todoapp.model.Todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@RestController
@EnableWebMvc
public class TodoController {

    private static final ArrayList<Todo> todos = new ArrayList<>(
            Arrays.asList(
                    new Todo("1", "Buy Egs", true),
                    new Todo("2", "Go to gym", false),
                    new Todo("3", "Finish the book chapter", false)
            )
    );

    @RequestMapping(path = "/todo", method = RequestMethod.GET)
    public List<Todo> getTodos() {
        return todos;
    }

    @RequestMapping(path = "/todo/{id}", method = RequestMethod.GET)
    public Todo getTodo(@PathVariable String id) {
        for (Todo todo: todos) {
            if (Objects.equals(todo.getId(), id)) {
                return todo;
            }
        }
        return null;
    }

    @RequestMapping(path = "/todo/{id}", method = RequestMethod.DELETE)
    public Boolean deleteTodo(@PathVariable String id) {
        return todos.removeIf(todo -> Objects.equals(todo.getId(), id));
    }

    @RequestMapping(path = "/todo", method = RequestMethod.POST)
    public Todo addTodo(@RequestBody Todo todo) {
        todos.add(todo);
        return todo;
    }

    @RequestMapping(path = "/todo", method = RequestMethod.PUT)
    public Todo updateTodo(@RequestBody Todo updatedTodo) {
        for (Todo todo: todos) {
            if (Objects.equals(todo.getId(), updatedTodo.getId())) {
                todo.setDescription(updatedTodo.getDescription());
                todo.setIsDone(updatedTodo.isDone());
            }
            return todo;
        }
        return null;
    }
}
