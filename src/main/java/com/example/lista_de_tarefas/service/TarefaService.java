package com.example.lista_de_tarefas.service;

import com.example.lista_de_tarefas.entity.Status;
import com.example.lista_de_tarefas.entity.Tarefa;
import com.example.lista_de_tarefas.repository.TarefaRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TarefaService {
    @Autowired
    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }
    public Tarefa criarTarefa(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }


    public Tarefa atualizarTarefa(Long id, Tarefa tarefaAtualizada) throws BadRequestException {
        if (tarefaAtualizada == null) {
            throw new IllegalArgumentException("Tarefa atualizada não pode ser nula.");
        }


        Tarefa tarefa = null;
        try {
            tarefa = tarefaRepository.findById(id).orElseThrow(() ->
                    new BadRequestException("Tarefa com ID " + id + " não encontrada."));
        } catch (BadRequestException e) {
            throw new RuntimeException(e);
        }


        tarefa.setTitulo(tarefaAtualizada.getTitulo());
        tarefa.setDescricao(tarefaAtualizada.getDescricao());
        tarefa.setStatus(tarefaAtualizada.getStatus());


        if (tarefa.getStatus() == Status.CONCLUIDA) {
            tarefa.setDataConclusao(LocalDateTime.now());
        }

        return tarefaRepository.save(tarefa);
    }


    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }

    public Page<Tarefa> listarTarefasPaginadas(Pageable pageable) {
        return tarefaRepository.findAll(pageable);
    }


    public void deletarTarefa(Long id) {
        if (!tarefaRepository.existsById(id)) {
            try {
                throw new com.example.lista_de_tarefas.service.EntityNotFoundException("Tarefa com ID " + id + " não encontrada.");
            } catch (com.example.lista_de_tarefas.service.EntityNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        tarefaRepository.deleteById(id);
    }
}
