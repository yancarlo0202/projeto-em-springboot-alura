package med.voll.api.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    boolean existsByMedicoIdAndDataBetween(Long aLong, @NotNull @Future LocalDateTime data);
    boolean existsByPacienteIdAndDataBetween(Long idPaciente, @NotNull @Future LocalDateTime data, LocalDateTime ultimoHorario);
}
