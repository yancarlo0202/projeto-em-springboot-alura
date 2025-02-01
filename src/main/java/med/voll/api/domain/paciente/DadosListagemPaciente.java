package med.voll.api.domain.paciente;

import med.voll.api.domain.endereco.Endereco;

public record DadosListagemPaciente(Long id, String nome, String email, String cpf, String telefone, Endereco endereco) {

    public DadosListagemPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getEmail(), paciente.getTelefone(), paciente.getEndereco());
    }

}
