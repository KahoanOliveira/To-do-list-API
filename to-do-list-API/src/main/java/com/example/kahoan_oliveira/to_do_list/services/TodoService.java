package com.example.kahoan_oliveira.to_do_list.services;

import com.example.kahoan_oliveira.to_do_list.entities.Todos;
import com.example.kahoan_oliveira.to_do_list.repositories.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todos> create(Todos todos){
        todoRepository.save(todos);
        return list();
    }

    public List<Todos> list(){
        Sort sort = Sort.by("prioridade").descending().and(
                Sort.by("nome").ascending());
        return todoRepository.findAll(sort);
    }

    public List<Todos> update(Todos todos){
        todoRepository.save(todos);
        return list();
    }
    public List<Todos> delete(Long id){
        todoRepository.deleteById(id);
        return list();
    }
}
