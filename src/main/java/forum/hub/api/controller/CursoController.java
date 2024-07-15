package forum.hub.api.controller;

import forum.hub.api.domain.cursos.*;
import forum.hub.api.domain.cursos.Curso;
import forum.hub.api.domain.cursos.CursoRepository;
import forum.hub.api.domain.cursos.DadosListagemCurso;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/cursos")
@SecurityRequirement(name = "bearer-key")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCurso dados, UriComponentsBuilder uriBuilder){

        var curso = new Curso(dados);

       repository.save(curso);

       var uri = uriBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();

       return ResponseEntity.created(uri).body(new DadosDetalhamentoCurso(curso));

    }

    @GetMapping
    public ResponseEntity <Page<DadosListagemCurso>> listar(Pageable paginacao) {

        var page =  repository.findAllByAtivoTrue(paginacao).map(DadosListagemCurso::new);

        return  ResponseEntity.ok(page);

    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarCurso dados){
        var curso = repository.getReferenceById(dados.id());

        curso.atualizarDados(dados);

        return ResponseEntity.ok(new DadosDetalhamentoCurso(curso));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){

        var curso = repository.getReferenceById(id);

        curso.excluir();

        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){

        var curso = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoCurso(curso));

    }



}
