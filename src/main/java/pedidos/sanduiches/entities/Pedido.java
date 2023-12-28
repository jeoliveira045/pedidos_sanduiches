package pedidos.sanduiches.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;

@Data
@Entity
@Table(name = "PEDIDO")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PEDIDO_SEQ")
    private Long id;

    private BigInteger numeroDoPedido;

    private String nomeDoCliente;


}
