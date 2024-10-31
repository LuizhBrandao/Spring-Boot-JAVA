package med.voll.vollmed.paciente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import med.voll.vollmed.endereco.DadosEndereco;

public record DadosCadastroPaciente(

        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String telefone,
        String cpf,
        DadosEndereco endereco) {
}