package com.example.kahoan_oliveira.to_do_list.controllers;

import com.example.kahoan_oliveira.to_do_list.entities.Todos;
import com.example.kahoan_oliveira.to_do_list.services.TodoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    List<Todos> create(@RequestBody @Valid Todos todos){
        return todoService.create(todos);
    }

    @GetMapping
    List<Todos> list(){
        return todoService.list();
    }

    @PutMapping
    List<Todos> update(@RequestBody Todos todos){
        return todoService.update(todos);
    }

    @DeleteMapping("{id}")
    List<Todos> delete(@PathVariable("id") Long id){
        return todoService.delete(id);
    }
}
