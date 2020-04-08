package octodrink.back.linha.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("linha-categoria")
public class LinhaCategoriaRest {
    @Autowired
    private LinhaCategoriaService service;

    public LinhaCategoriaRest(LinhaCategoriaService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<LinhaCategoriaDTO> save(@RequestBody LinhaCategoriaDTO dto){
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LinhaCategoria> findById(@PathVariable("id") String id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<LinhaCategoriaDTO> update(@RequestBody LinhaCategoriaDTO dto){
        return ResponseEntity.ok(service.update(dto));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id){
        service.delete(id);
    }
}
