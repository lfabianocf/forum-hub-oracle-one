package forum.hub.api.domain.cursos;

public record DadosListagemCurso(Long id, String nome, Categoria categoria) {

    public DadosListagemCurso(Curso curso){

        this(curso.getId(), curso.getNome(), curso.getCategoria());
    }
}
