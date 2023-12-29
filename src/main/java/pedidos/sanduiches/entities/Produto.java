package pedidos.sanduiches.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Blob;

@Data
@Entity
@Table(name = "PRODUTO")
public class Produto {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "PRODUTO_SEQ")
    private Long id;

    private String nome;

    private BigDecimal precoUnitario;
}
