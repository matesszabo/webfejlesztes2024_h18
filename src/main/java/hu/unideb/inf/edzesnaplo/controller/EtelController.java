package hu.unideb.inf.edzesnaplo.controller;

import hu.unideb.inf.edzesnaplo.data.entity.EtelEntity;
import hu.unideb.inf.edzesnaplo.data.repository.EtelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//json-t küld, json-t fogad
@RequestMapping("/api")
public class EtelController {

    @Autowired
    EtelRepository repository;

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/hw")
    public ResponseEntity<String> helloworld(){
        return new ResponseEntity<>("Hello, world!", HttpStatus.NOT_FOUND);
    }

    //localhost:8080/api/saveetel POST
    @PostMapping("/saveetel")
    public EtelEntity save(@RequestBody EtelEntity etel){
        return repository.save(etel);
    }

    @PutMapping("/updateetel")
    public EtelEntity update(@RequestBody EtelEntity etel){
        if(etel.getId() > 0L){
            return repository.save(etel);
        }
        return null;
    }

    //localhost:8080/api/etel?id=1 DELETE
    @DeleteMapping("/etel")
    public void delete(@RequestParam Long id){
        repository.deleteById(id);
    }

    //localhost:8080/api/etel GET
    @GetMapping("/etel")
    public List<EtelEntity> findAll(){
        return repository.findAll();
    }
}







