package octodrink.back.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categoria")
public class CategoriaRest {
    @Autowired
    private CategoriaService service;

    public CategoriaRest(CategoriaService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<CategoriaDTO> save(@RequestBody CategoriaDTO categoria){
        return ResponseEntity.ok(service.save(categoria));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable("id") String id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<CategoriaDTO> update(@RequestBody CategoriaDTO categoria){
        return ResponseEntity.ok(service.update(categoria));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id){
        service.delete(id);
    }
}
