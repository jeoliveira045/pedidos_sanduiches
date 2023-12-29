package pedidos.sanduiches.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "PEDIDOITEM")
public class PedidoItem {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "PEDIDO_ITEM")
    private Long id;

    @ManyToMany
    private List<Produto> produto;

    @ManyToOne
    private Pedido pedido;
}
