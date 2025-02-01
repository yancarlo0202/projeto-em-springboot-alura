package med.voll.api.domain.paciente;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.endereco.Endereco;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String nome;
    private String email;
    private String telefone;

    @Embedded
    private Endereco endereco;

    private boolean ativo;

    public Paciente(DadosCadastroPaciente dados){
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = String.valueOf(dados.cpf());
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(@Valid DadosAtualizadosPaciente dados){
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if(dados.enedereco() != null){
            this.endereco.atualizarInformacoes(dados.enedereco());
        }
    }

    public void exluir() {
        this.ativo = false;
    }

    public Long getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public boolean isAtivo() {
        return ativo;
    }

}
