package com.dt2.GTAVI.controller;

import com.dt2.GTAVI.entities.Veicolos;
import com.dt2.GTAVI.repository.VeicolosRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/veiculos")
public class VeicolosController {

    private final VeicolosRepository repository;

    public VeicolosController(VeicolosRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Veicolos> criarVeicolos(@RequestBody Veicolos bugate) {
        try {
            Veicolos veiculoSalvo = repository.save(bugate);
            return ResponseEntity.ok(veiculoSalvo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public List<Veicolos> mostrar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Veicolos> buscarId(@PathVariable int id) {
        return repository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veicolos> atualizar(@PathVariable int id, @RequestBody Veicolos v) {
        return repository.findById(id).map(veicolos -> {
            veicolos.setNome(v.getNome());
            veicolos.setCategoria(v.getCategoria());
            veicolos.setMarca(v.getMarca());
            veicolos.setDescricao(v.getDescricao());
            veicolos.setImagem(v.getImagem());
            return ResponseEntity.ok(repository.save(veicolos));
        }).orElse(ResponseEntity.notFound().build());
    }
}