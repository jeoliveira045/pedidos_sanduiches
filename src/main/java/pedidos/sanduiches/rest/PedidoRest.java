package pedidos.sanduiches.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pedidos.sanduiches.entities.Pedido;
import pedidos.sanduiches.repositories.PedidoRepository;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@AllArgsConstructor
public class PedidoRest {
    private PedidoRepository repository;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll(){
        return ResponseEntity.ok(repository.findAll());
    }
}
