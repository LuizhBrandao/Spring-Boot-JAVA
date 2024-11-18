package med.voll.vollmed.service;

import med.voll.vollmed.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public void cadastrar(DadosCadastroMedico dados) {
        medicoRepository.save(new Medico(dados));
    }

    public Page<DadosListagemMedico> listar(Pageable paginacao) {
        return medicoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    public void atualizar(DadosAtualizacaoMedico dados) {
        var medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
        medicoRepository.save(medico);
    }

    public void excluir(Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.excluir();
        medicoRepository.save(medico);
    }
}
