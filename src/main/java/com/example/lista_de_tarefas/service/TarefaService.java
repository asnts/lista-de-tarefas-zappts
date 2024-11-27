package com.example.lista_de_tarefas.service;

import com.example.lista_de_tarefas.entity.Status;
import com.example.lista_de_tarefas.entity.Tarefa;
import com.example.lista_de_tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TarefaService {
    @Autowired

    private TarefaRepository repository;

    public Tarefa criarTarefa(Tarefa tarefa){
        return repository.save(tarefa);
    }

    public Tarefa atualizarTarefa(Long id, Tarefa tarefaAtualizada){
        Tarefa tarefa = repository.findById(id).orElseThrow(() -> new
                tarefa.setTitulo(tarefaAtualizada.getTitulo());
                tarefa.setDescricao(tarefaAtualizada.getDescricao());
                tarefa.setStatus(tarefaAtualizada.getStatus());

                if (tarefa.getStatus() == Status.CONCLUIDA){
                    tarefa.setDataConclusao(LocalDateTime.now());
                }

                return repository.save(tarefa);

    }

    public List<Tarefa> listarTarefas(){
        return repository.findAll();
    }

    public void deletarTarefa(Long id){
        repository.deleteAllById(id);
    }
}
