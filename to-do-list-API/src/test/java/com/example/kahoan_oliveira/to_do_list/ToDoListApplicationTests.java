package com.example.kahoan_oliveira.to_do_list;

import com.example.kahoan_oliveira.to_do_list.entities.Todos;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ToDoListApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateSuccess() {
		var todo = new Todos("Todo 1","Desc Todo 1", 1, false);

		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(1)
				.jsonPath("$.[0].nome").isEqualTo(todo.getNome())
				.jsonPath("$.[0].descricao").isEqualTo(todo.getDescricao())
				.jsonPath("$.[0].realizado").isEqualTo(todo.getRealizado())
				.jsonPath("$.[0].prioridade").isEqualTo(todo.getPrioridade());
	}

	@Test
	void testCreateFailure(){
		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(
						new Todos("","",0,false)
				).exchange()
				.expectStatus().isBadRequest();
	}

}
