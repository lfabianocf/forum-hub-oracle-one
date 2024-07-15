package forum.hub.api.domain.usuario;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizaUsuario(


        @NotNull
        Long id,

        String nome,
        String senha,
        Perfil perfil) {
}
