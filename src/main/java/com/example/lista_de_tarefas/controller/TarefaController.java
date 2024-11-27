package com.example.lista_de_tarefas.controller;
import com.example.lista_de_tarefas.entity.Tarefa;
import com.example.lista_de_tarefas.service.TarefaService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

@Autowired
    private TarefaService service;

@PostMapping
    public ResponseEntity<Tarefa> criarTarefa(@RequestBody @Valid Tarefa tarefa){

    Tarefa tarefaCriada = service.criarTarefa(tarefa);
    return ResponseEntity.status(HttpStatus.CREATED).body(tarefaCriada);
}

@PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id, @RequestBody @Valid Tarefa tarefa){
    Tarefa tarefaAtualizada = null;
    try {
        tarefaAtualizada = service.atualizarTarefa(id, tarefa);
    } catch (BadRequestException e) {
        throw new RuntimeException(e);
    }
    return  ResponseEntity.ok(tarefaAtualizada);
}

@GetMapping
    public ResponseEntity<List<Tarefa>> listarTarefas(){
    return ResponseEntity.ok(service.listarTarefas());


}

@DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id){
    service.deletarTarefa(id);
    return ResponseEntity.noContent().build();
}

}
