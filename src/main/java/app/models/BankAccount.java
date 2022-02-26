package app.models;

import lombok.AllArgsConstructor;
import lombok.Data;


import java.math.BigDecimal;
/*
@Data .- Contiene las anotaciones de:
---> "@ToString", "@EqualsAndHashCode", "@Getter", "@Setter" y "@RequiredArgsConstructor"
(incluyendo el atributo "staticConstructor" para generar un método estático de fábrica).
Esta anotación es excelente para escribir POJOs.
 */
@Data
@AllArgsConstructor
public class BankAccount {
    private String person;
    private BigDecimal amount;
}
