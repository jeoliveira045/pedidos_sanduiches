package pedidos.sanduiches.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pedidos.sanduiches.entities.Produto;
import pedidos.sanduiches.repositories.ProdutoRepository;
import pedidos.sanduiches.services.CarregarPlanilhaProdutoService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/produtos")
@AllArgsConstructor
public class ProdutoRest {
    private ProdutoRepository repository;

    private CarregarPlanilhaProdutoService carregarPlanilhaProdutoService;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("/file-upload")
    public void fileUpload(@RequestParam("file") MultipartFile file) throws FileNotFoundException {


        carregarPlanilhaProdutoService.processExcelFile(file);

    }
}
