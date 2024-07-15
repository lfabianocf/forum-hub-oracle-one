package forum.hub.api.domain.usuario;

public record DadosListagemUsuario(Long id,String nome, String email, Perfil peril) {

   public DadosListagemUsuario(Usuario usuario) {

       this( usuario.getId(), usuario.getNome(), usuario.getLogin(), usuario.getPerfil());
   }
}
