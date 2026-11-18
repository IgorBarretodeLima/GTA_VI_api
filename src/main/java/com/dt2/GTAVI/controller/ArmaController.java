package com.dt2.GTAVI.controller;

import com.dt2.GTAVI.entities.Arma;
import com.dt2.GTAVI.repository.ArmaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/armas")
public class ArmaController {

    private final ArmaRepository repository;

    public ArmaController(ArmaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Arma> criarArma(@RequestBody Arma glock19mm) {
        try {
            Arma armaSalva = repository.save(glock19mm);
            return ResponseEntity.ok(armaSalva);
        } catch (Exception e) {
            e.printStackTrace(); // Mostra o motivo exato no console do IntelliJ
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public List<Arma> mostrar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Arma> buscarId(@PathVariable int id) {
        return repository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Arma> atualizar(@PathVariable int id, @RequestBody Arma a) {
        return repository.findById(id).map(arma -> {
            arma.setNome(a.getNome());
            arma.setCategoria(a.getCategoria());
            arma.setFabricante(a.getFabricante());
            arma.setDescricao(a.getDescricao());
            arma.setImagem(a.getImagem());
            return ResponseEntity.ok(repository.save(arma));
        }).orElse(ResponseEntity.notFound().build());
    }
}