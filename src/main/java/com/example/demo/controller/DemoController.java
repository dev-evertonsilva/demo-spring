package com.example.demo.controller;
import com.example.demo.entity.Aluno;
import com.example.demo.entity.Dummy;
import com.example.demo.service.DemoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class DemoController{

    final DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping
    public List<Aluno> getAlunos() {
        return demoService.listAlunos();
    }

    @GetMapping("/dummy")
    public List<Dummy> getDummy() {
        return demoService.listDummy();
    }

    @GetMapping("/dummy/{id}")
    public Dummy getDummy(@PathVariable Long id) {
        return demoService.getDummy(id);
    }

    @PostMapping("/dummy")
    public Dummy createDummy(@RequestBody Dummy dummy) {
        return demoService.createDummy(dummy);
    }

    @PutMapping("/dummy/{id}")
    public Dummy createDummy(@PathVariable Long id,@RequestBody Dummy dummy) throws Exception {
        return demoService.updateDummy(id, dummy);
    }

    @DeleteMapping("/dummy/{id}")
    public void deleteDummy(@PathVariable Long id) {
        demoService.deleteDummy(id);
    }

}
