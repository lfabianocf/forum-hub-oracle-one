package forum.hub.api.domain.topico;

import forum.hub.api.domain.cursos.CursoRepository;
import forum.hub.api.domain.usuario.UsuarioRepository;
import forum.hub.api.infra.validacao.ValidacaoEXception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoServico {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public DadosDetalheTopico cadastrarTopico(DadosCadastroTopico dados) {


        if (!usuarioRepository.existsById(dados.autor_id())){
            throw new ValidacaoEXception("Id do autor não existe!");
        }

        if (!cursoRepository.existsById(dados.curso_id())){
            throw new ValidacaoEXception("Id do Curso não existe!");
        }

        if(dados.titulo() != null && topicoRepository.existsByTituloIgnoreCase(dados.titulo()) ){
            throw new ValidacaoEXception("Existe um título cadastrado!");

        }

        if(dados.mensagem() != null && topicoRepository.existsByMensagemIgnoreCase(dados.mensagem())){
            throw new ValidacaoEXception("Existe uma mensagem cadastrado!");
        }

        var curso = cursoRepository.getReferenceById(dados.curso_id());

        var autor = usuarioRepository.getReferenceById(dados.autor_id());

        System.out.println(curso);
        System.out.println(autor);


        var topico = new Topico(null, dados.titulo(), dados.mensagem(), dados.data(), dados.status() ,curso, autor );

        topicoRepository.save(topico);

        return  new DadosDetalheTopico(topico);
    }

}
