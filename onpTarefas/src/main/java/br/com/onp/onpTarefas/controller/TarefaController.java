package br.com.onp.onpTarefas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.onp.onpTarefas.model.Tarefa;
import br.com.onp.onpTarefas.repository.TarefaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Criar uma tarefa
    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    // Listar todas as tarefas
    @GetMapping
    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }

    // Buscar uma tarefa por ID
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable Long id) {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);
        return tarefa.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    // Atualizar tarefa existente
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa dadosAtualizados) {
        Optional<Tarefa> tarefaExistente = tarefaRepository.findById(id);
        if (tarefaExistente.isPresent()) {
            Tarefa tarefa = tarefaExistente.get();
            tarefa.setNomeTarefa(dadosAtualizados.getNomeTarefa());
            tarefa.setDataEntrega(dadosAtualizados.getDataEntrega());
            tarefa.setResponsavel(dadosAtualizados.getResponsavel());
            return ResponseEntity.ok(tarefaRepository.save(tarefa));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Remover tarefa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        if (tarefaRepository.existsById(id)) {
            tarefaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 🔹 Novo endpoint: deletar todas as tarefas e resetar ID
    @DeleteMapping("/resetar")
    @Transactional
    public ResponseEntity<String> resetarTarefas() {
        // Deleta todas as tarefas
        tarefaRepository.deleteAll();

        // Resetar auto-increment dependendo do banco
        try {
            // MySQL
            jdbcTemplate.execute("ALTER TABLE tarefas AUTO_INCREMENT = 1");
        } catch (Exception e) {
            try {
                // H2
                jdbcTemplate.execute("ALTER TABLE tarefas ALTER COLUMN id RESTART WITH 1");
            } catch (Exception ex) {
                return ResponseEntity.status(500)
                        .body("Erro ao resetar IDs: " + ex.getMessage());
            }
        }

        return ResponseEntity.ok("Todas as tarefas deletadas e IDs resetados!");
    }
}


