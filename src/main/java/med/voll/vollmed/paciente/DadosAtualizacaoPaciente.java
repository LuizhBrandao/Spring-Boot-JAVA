package med.voll.vollmed.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.vollmed.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
