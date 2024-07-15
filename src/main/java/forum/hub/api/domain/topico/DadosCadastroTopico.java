package forum.hub.api.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCadastroTopico(

        @NotBlank
        String titulo,

        @NotBlank
        String mensagem,

        @NotNull
        LocalDateTime data,

        @NotNull
        Status status,

        @NotNull
        Long curso_id,

        @NotNull
        Long autor_id
     ) {
}
