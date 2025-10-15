package br.com.onp.onpTarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.onp.onpTarefas.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
