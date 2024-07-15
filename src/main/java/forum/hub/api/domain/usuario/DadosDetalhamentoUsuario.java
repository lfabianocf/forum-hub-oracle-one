package forum.hub.api.domain.usuario;

public record DadosDetalhamentoUsuario(Long id, String nome, String email, Perfil perfil) {

    public DadosDetalhamentoUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getLogin(), usuario.getPerfil());
    }
}
