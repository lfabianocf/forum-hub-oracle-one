package forum.hub.api.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAtualizarTopico(

        @NotNull
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime data,
        Status status,
        @NotNull
        Long curso_id,
        @NotNull
        Long autor_id

) {

}
