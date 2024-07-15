package forum.hub.api.domain.cursos;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarCurso(
        @NotNull
        Long id,

        String nome,
        Categoria categoria) {
}
