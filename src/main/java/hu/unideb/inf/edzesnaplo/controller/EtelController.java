package hu.unideb.inf.edzesnaplo.controller;

import hu.unideb.inf.edzesnaplo.data.entity.EtelEntity;
import hu.unideb.inf.edzesnaplo.data.repository.EtelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    //localhost:8080/api/etel/rizs GET
    @GetMapping("/etel/{nev}")
    public List<EtelEntity> findAllByNev(@PathVariable String nev){
        List<EtelEntity> szurt = new ArrayList<>();

        szurt = repository.findAll()
                .stream()
                .filter(x -> x.getNev().contains(nev))
                .toList();

        return szurt;
    }

    //localhost:8080/api/etelbynev?nev=rizs GET
    @GetMapping("/etelbynev")
    public List<EtelEntity> findAllByNevRp(@RequestParam String nev){
        return repository.findAllByNevContains(nev);
    }

    //localhost:8080/api/filteretel?nev=rizs
    //localhost:8080/api/filteretel?nev=rizs&kaloria=130
    @GetMapping("filteretel")
    public List<EtelEntity> filterEtel(@RequestParam(required = false) String nev,
                                       @RequestParam(required = false) Integer kaloria,
                                       @RequestParam(required = false) Float mennyiseg,
                                       @RequestParam(required = false) String mennyisegiEgyseg){

        List<EtelEntity> szurt = new ArrayList<>();
        szurt = repository.findAll()
                .stream()
                .filter(x -> nev == null || x.getNev().contains(nev))
                .filter(x -> kaloria == null || x.getKaloria() < kaloria)
                .filter(x -> mennyiseg == null || x.getMennyiseg().equals(mennyiseg))
                .filter(x -> mennyisegiEgyseg == null || x.getMennyisegiEgyseg().equals(mennyisegiEgyseg))
                .toList();

        return szurt;
    }




}







