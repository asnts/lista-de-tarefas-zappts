package com.example.lista_de_tarefas;

import com.example.lista_de_tarefas.entity.Status;
import com.example.lista_de_tarefas.entity.Tarefa;
import com.example.lista_de_tarefas.repository.TarefaRepository;
import com.example.lista_de_tarefas.service.TarefaService;
import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class  TarefaServiceTest{

    @Mock

    private TarefaRepository tarefaRepository;

    @InjectMocks

    private TarefaService tarefaService;

    public  TarefaServiceTest(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void criarTarefaComSucesso(){

        Tarefa novaTarefa = new Tarefa();
        novaTarefa.setTitulo("Teste");
        novaTarefa.setDescricao("Descrição de teste");

                when(tarefaRepository.save(any(Tarefa.class))).thenReturn(novaTarefa);

                Tarefa tarefaCriada = tarefaService.criarTarefa(novaTarefa);

                assertNotNull(tarefaCriada);
                assertEquals("Teste", tarefaCriada.getTitulo());
                verify(tarefaRepository, times(1)).save(novaTarefa);

    }

    private void assertNotNull(Tarefa tarefaCriada) {
    }


    @Test

    void atualizarTarefaComSucesso() throws BadRequestException {

        Long tarefaId = 1L;

        Tarefa tarefaExistente = new Tarefa();

        tarefaExistente.setId(tarefaId);
        tarefaExistente.setTitulo("Titulo Antigo");
        tarefaExistente.setDescricao("Descricao Antiga");
        tarefaExistente.setStatus(Status.PENDENTE);


        Tarefa tarefaAtualizada = new Tarefa();

        tarefaAtualizada.setTitulo("Novo titulo");
        tarefaAtualizada.setDescricao("Nova descricao");
        tarefaAtualizada.setStatus(Status.CONCLUIDA);



        when(tarefaRepository.findById(tarefaId)).thenReturn(java.util.Optional.of(tarefaExistente));
        when(tarefaRepository.save(any(Tarefa.class))).thenReturn(tarefaExistente);

        Tarefa resultado = tarefaService.atualizarTarefa(tarefaId, tarefaAtualizada);

        assertNotNull(resultado);
        assertEquals("Novo titulo", resultado.getTitulo());
        assertEquals("Nova descricao", resultado.getDescricao());
        assertEquals(Status.CONCLUIDA, resultado.getStatus());
        assertNotNull(resultado.getDataConclusao());
        verify(tarefaRepository, times(1)).findById(tarefaId);
        verify(tarefaRepository, times(1)).save(tarefaExistente);


    }

    private void assertNotNull(LocalDateTime dataConclusao) {
    }


    @Test

    void lancarExcecaoSeTarefaNaoForEncontrada(){

        Long tarefaId = 1L;

        when(tarefaRepository.findById(tarefaId)).thenReturn(java.util.Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
             tarefaService.atualizarTarefa(tarefaId, new Tarefa()));


        assertEquals("Tarefa com ID" + tarefaId + "não encontrada", exception.getCause().getMessage());
        verify(tarefaRepository, times(1)).findById(tarefaId);

    }
}
