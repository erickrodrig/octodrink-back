package octodrink.back.bebida;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("bebida")
public class BebidaRest {
    @Autowired
    private final BebidaService service;

    public BebidaRest(BebidaService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<BebidaDTO> save(@Valid @RequestBody BebidaDTO dto){
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bebida> findById(@PathVariable("id") String id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<BebidaDTO> update(@Valid @RequestBody BebidaDTO dto){
        return ResponseEntity.ok(service.update(dto));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id){
        service.delete(id);
    }
}
