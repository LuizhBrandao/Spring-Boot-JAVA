package med.voll.vollmed.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.vollmed.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
