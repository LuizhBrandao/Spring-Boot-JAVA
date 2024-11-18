package med.voll.vollmed.service;

import med.voll.vollmed.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public void cadastrar(DadosCadastroPaciente dados) {
        pacienteRepository.save(new Paciente(dados));
    }

    public Page<DadosListagemPaciente> listar(Pageable paginacao) {
        return pacienteRepository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
    }

    public void atualizar(DadosAtualizacaoPaciente dados) {
        var paciente = pacienteRepository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
        pacienteRepository.save(paciente);
    }

    public void excluir(Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.excluir();
        pacienteRepository.save(paciente);
    }
}
