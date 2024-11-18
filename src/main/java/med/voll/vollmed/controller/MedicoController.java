package med.voll.vollmed.controller;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.vollmed.medico.*;
import med.voll.vollmed.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        medicoService.cadastrar(dados);
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return medicoService.listar(paginacao);
    }

    @PutMapping
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        medicoService.atualizar(dados);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        medicoService.excluir(id);
    }
}
