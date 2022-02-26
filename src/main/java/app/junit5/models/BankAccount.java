package app.junit5.models;

import app.junit5.exceptions.InsufficientMoneyExceptions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
/*
@Data .- Contiene las anotaciones de:
---> "@ToString", "@EqualsAndHashCode", "@Getter", "@Setter" y "@RequiredArgsConstructor"
(incluyendo el atributo "staticConstructor" para generar un método estático de fábrica).
Esta anotación es excelente para escribir POJOs.
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class BankAccount {
    private String person;
    private BigDecimal balance;
    // 1 cuenta 1 banco
    private Bank bank;

    public void debit(BigDecimal amount){
        BigDecimal newBalance = this.balance.subtract(amount);
        if ( newBalance.compareTo(BigDecimal.ZERO) < 0 ){
            throw new InsufficientMoneyExceptions("Insufficient Money");
        }
        this.balance = newBalance;
    }
    public void credit(BigDecimal amount){
        this.balance = this.balance.add(amount);
    }

    public BankAccount(String person, BigDecimal balance) {
        this.person = person;
        this.balance = balance;
    }
}
