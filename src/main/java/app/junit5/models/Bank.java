package app.junit5.models;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Bank {
    // Un banco muchas cuentas
    private List<BankAccount> bankAccount;
    private String name;
    public Bank(){
        bankAccount = new ArrayList<>();
    }

    public void addCount(BankAccount count){
        bankAccount.add(count);
        // A cada cuenta que se agrega en la clase le agregamos el banco
        count.setBank(this);
    }
    /*
    Primero debitamos de la cuenta origen el monto indicado
    segundo acreditamos a la cuenta destino el monto indicado
     */
    public void transfer(BankAccount origin, BankAccount destin, BigDecimal mount){
        origin.debit(mount);
        destin.credit(mount);
    }
}
