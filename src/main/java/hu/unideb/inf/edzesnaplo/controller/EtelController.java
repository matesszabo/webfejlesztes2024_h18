package hu.unideb.inf.edzesnaplo.controller;

import hu.unideb.inf.edzesnaplo.service.EtelManagementService;
import hu.unideb.inf.edzesnaplo.service.dto.EtelDto;
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
    EtelManagementService service;

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
    public EtelDto save(@RequestBody EtelDto etel){
        return service.save(etel);
    }

    @PutMapping("/updateetel")
    public EtelDto update(@RequestBody EtelDto etel){
        if(etel.getId() > 0L){
            return service.save(etel);
        }
        return null;
    }

    //localhost:8080/api/etel?id=1 DELETE
    @DeleteMapping("/etel")
    public void delete(@RequestParam Long id){
        service.delete(id);
    }

    //localhost:8080/api/etel GET
    @GetMapping("/etel")
    public List<EtelDto> findAll(){
        return service.findAll();
    }

    //localhost:8080/api/etel/rizs GET
    @GetMapping("/etel/{nev}")
    public List<EtelDto> findAllByNev(@PathVariable String nev){
        return service.findByNev(nev);
    }

    //localhost:8080/api/etelbynev?nev=rizs GET
    @GetMapping("/etelbynev")
    public List<EtelDto> findAllByNevRp(@RequestParam String nev){
        return service.findByNevDb(nev);
    }

    //localhost:8080/api/filteretel?nev=rizs
    //localhost:8080/api/filteretel?nev=rizs&kaloria=130
    @GetMapping("filteretel")
    public List<EtelDto> filterEtel(@RequestParam(required = false) String nev,
                                       @RequestParam(required = false) Integer kaloria,
                                       @RequestParam(required = false) Float mennyiseg,
                                       @RequestParam(required = false) String mennyisegiEgyseg){

        return service.findByAny(nev, kaloria, mennyiseg, mennyisegiEgyseg);
    }




}







