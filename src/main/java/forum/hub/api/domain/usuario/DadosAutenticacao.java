package forum.hub.api.domain.usuario;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosAutenticacao(
        String login,
        String senha) {
}
