package forum.hub.api.domain.topico;

import java.time.LocalDateTime;

public record DadosListagemTopicos(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime data,
        Status status,
        Long curso_id,
        Long autor_id

) {

    public DadosListagemTopicos(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getData(), topico.getStatus(), topico.getCurso().getId(), topico.getUsuario().getId());
    }

}
