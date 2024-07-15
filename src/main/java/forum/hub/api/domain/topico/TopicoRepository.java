package forum.hub.api.domain.topico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    boolean existsByTituloIgnoreCase(String titulo);

    boolean existsByMensagemIgnoreCase(String mensagem);
}
