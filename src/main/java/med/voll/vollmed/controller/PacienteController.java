package med.voll.vollmed.controller;

import jakarta.validation.Valid;
import med.voll.vollmed.endereco.Endereco;
import med.voll.vollmed.paciente.*;
import med.voll.vollmed.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {
        pacienteService.cadastrar(dados);
    }

    @GetMapping
    public Page<DadosListagemPaciente> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return pacienteService.listar(paginacao);
    }

    @PutMapping
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados) {
        pacienteService.atualizar(dados);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        pacienteService.excluir(id);
    }
}
