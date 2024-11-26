package com.example.lista_de_tarefas.entity;
import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String titulo;
    private  String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCriacao;
    private LocalDateTime dataConclusao;

    @PrePersist

    protected void onCreate(){
        Instant localDateTime = null;
        this.dataCriacao = LocalDateTime.from(localDateTime.now());

    }
}
