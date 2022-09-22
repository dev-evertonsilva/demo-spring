package com.example.demo.service;

import com.example.demo.entity.Aluno;
import com.example.demo.entity.Dummy;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.repository.DummyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemoService {

    final AlunoRepository alunoRepository;
    final DummyRepository dummyRepository;

    public DemoService(AlunoRepository alunoRepository, DummyRepository dummyRepository) {
        this.alunoRepository = alunoRepository;
        this.dummyRepository = dummyRepository;
    }

    public List<Aluno> listAlunos() {
        return alunoRepository.findAll();
    }

    public List<Dummy> listDummy() {
        return dummyRepository.findAll();
    }

    public Dummy getDummy(Long id){
        return dummyRepository.findById(id).get();
    }
    public Dummy createDummy(Dummy dummy) {
        return dummyRepository.save(dummy);
    }

    public Dummy updateDummy(Long id, Dummy dummy) throws Exception {
        Optional<Dummy> dummyExists = dummyRepository.findById(id);

        if (dummyExists.isPresent()) {

            Dummy dummyForUpdate = dummyExists.get();

            dummyForUpdate.setName(dummy.getName());
            dummyForUpdate.setSurname(dummy.getSurname());

            return dummyRepository.save(dummyForUpdate);
        } else {
            throw new Exception("O id " + id + " não existe no banco de dados!");
        }
    }

    public void deleteDummy(Long id) {
        dummyRepository.deleteById(id);
    }
}
