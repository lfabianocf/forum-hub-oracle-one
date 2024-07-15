
package forum.hub.api.controller;

import forum.hub.api.domain.topico.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoContoller {

    @Autowired
    private TopicoServico topicoServico;


    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarTopico(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder ){

      var dtoTopico =     topicoServico.cadastrarTopico(dados);

        return  ResponseEntity.ok(dtoTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopicos>> listar(@PageableDefault(size=10, sort = {"data"}) Pageable paginacao) {

        var topicos = topicoRepository.findAll(paginacao).map(DadosListagemTopicos::new);

        return ResponseEntity.ok(topicos);

    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {

        var topico = topicoRepository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalheTopico(topico));

    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarTopico dados) {

        Topico topico = topicoRepository.getReferenceById(dados.id());

        System.out.println("Inicio :" + topico);

        System.out.println("teste   : " + dados.id());
        System.out.println("teste   : " + dados.mensagem());
        System.out.println("teste   : " + dados.titulo());

        topico.atualizarDados(dados);

        return ResponseEntity.ok(new DadosDetalheTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {

        var topico = topicoRepository.getReferenceById(id);

        topico.excluir();

        return ResponseEntity.noContent().build();


    }

}
