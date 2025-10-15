package br.com.onp.onpTarefas.model;

import jakarta.persistence.*;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tarefas")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("nomeTarefa")
    private String nomeTarefa;
    private LocalDate dataEntrega;
    private String responsavel;

    public Tarefa() {}

    public Tarefa(String nomeTarefa, LocalDate dataEntrega, String responsavel) {
        this.nomeTarefa = nomeTarefa;
        this.dataEntrega = dataEntrega;
        this.responsavel = responsavel;
    }

    public Long getId() {
        return id;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
}

