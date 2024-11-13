package com.example.kahoan_oliveira.to_do_list.repositories;

import com.example.kahoan_oliveira.to_do_list.entities.Todos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todos, Long> {

}
