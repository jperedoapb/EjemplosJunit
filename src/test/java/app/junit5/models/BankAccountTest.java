package app.junit5.models;


import app.junit5.exceptions.InsufficientMoneyExceptions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
  @Test
  void testNameCount() {
      BankAccount bankAccount = new BankAccount("Alejandro", new BigDecimal("10000.12345"));

      // Verifico que el saldo no sea nulo
      assertNotNull(bankAccount.getBalance());

      String esperado = "Alejandro";
      assertEquals(esperado, bankAccount.getPerson());
      // La linea anterior es igual a esta y mas efectiva
      assertTrue(bankAccount.getPerson().equals(esperado));
  }

  @Test
  void testSaldoCuenta() {
      BankAccount bankAccount = new BankAccount("Alejandro", new BigDecimal("123456.123456"));
      // Verifico que el saldo no sea nulo
      assertNotNull(bankAccount.getBalance());
      assertEquals(123456.123456, bankAccount.getBalance().doubleValue());
      // Comparamos que sea falsa una premisa
      assertFalse(bankAccount.getBalance().compareTo(BigDecimal.ZERO) < 0);
      // Comparamos que sea verdadera la premisa
      assertTrue(bankAccount.getBalance().compareTo(BigDecimal.ZERO) > 0);
  }

  /*
  En esta prueba se debe tomar en cuenta que el objeto tiene anotaciones de Lombok
  por lo que el método equals esta sobre escrito, por lo que la comparación esta verificando
  que la refencia es igual pero no los parámetros
   */
  @Test
  void testReferenceAccount() {
      BankAccount bankAccount = new BankAccount("Alejandro Peredo", new BigDecimal("987654.121212"));
      BankAccount bankAccount2 = new BankAccount("Alejandro Peredo", new BigDecimal("987654.121212"));
      //assertNotEquals(bankAccount2, bankAccount);
      assertEquals(bankAccount2, bankAccount);
  }

  @Test
  void testDebitAccount() {
      BankAccount bankAccount = new BankAccount("Alejandro Peredo", new BigDecimal("2000.121212"));
      bankAccount.debit(new BigDecimal(100));
      // Verifico que el saldo no sea nulo
      assertNotNull(bankAccount.getBalance());
      assertEquals(1900, bankAccount.getBalance().intValue());
      assertEquals("1900.121212", bankAccount.getBalance().toPlainString());
  }

    @Test
    void testCreditAmount() {
        BankAccount bankAccount = new BankAccount("Alejandro Peredo", new BigDecimal("2000.121212"));
        bankAccount.credit(new BigDecimal(100));
        // Verifico que el saldo no sea nulo
        assertNotNull(bankAccount.getBalance());
        assertEquals(2100, bankAccount.getBalance().intValue());
        assertEquals("2100.121212", bankAccount.getBalance().toPlainString());
    }

  @Test
  void testInsuficientMoneyExceptionBalance() {
      BankAccount bankAccount = new BankAccount("Alejandro Peredo", new BigDecimal("2000.121212"));
      Exception exception = assertThrows(InsufficientMoneyExceptions.class, ()->bankAccount.debit(new BigDecimal("2100")));
      String actual = exception.getMessage();
      String esperado = "Insufficient Money";
      assertEquals(esperado, actual);
  }

  @Test
  void testTransferMoneyAccount() {
      BankAccount bill1 = new BankAccount("Alejandro Peredo", new BigDecimal("2500"));
      BankAccount bill2 = new BankAccount("Jaime Peredo", new BigDecimal("1500"));
      Bank bank = new Bank();
      bank.setName("Bank of America");
      bank.transfer(bill2, bill1, new BigDecimal("500"));
      // Comparo si en las dos cuenta el saldo es el esperado, en la primera se debita y se acredita en la segunda
      assertEquals("1000", bill2.getBalance().toPlainString());
      assertEquals("3000", bill1.getBalance().toPlainString());
  }

    @Test
    void testBankAccountRelationship() {
        BankAccount bill1 = new BankAccount("Alejandro Peredo", new BigDecimal("2500"));
        BankAccount bill2 = new BankAccount("Jaime Peredo", new BigDecimal("1500"));
        Bank bank = new Bank();
        bank.addCount(bill1);
        bank.addCount(bill2);
        bank.setName("Bank of America");
        bank.transfer(bill2, bill1, new BigDecimal("500"));
        // Comparo si en las dos cuenta el saldo es el esperado, en la primera se debita y se acredita en la segunda
        assertEquals("1000", bill2.getBalance().toPlainString());
        assertEquals("3000", bill1.getBalance().toPlainString());

        // Relacion Cuentas-Bancos
        assertEquals(2, bank.getBankAccount().size());
        // Relacion Banco-Cuentas
        assertEquals("Bank of America", bill1.getBank().getName());

        // encuentra el nombre de la cuenta
        assertEquals("Alejandro Peredo", bank.getBankAccount().stream()
                .filter(c -> c.getPerson().equals("Alejandro Peredo"))
                .findFirst()
                .get().getPerson());

        assertTrue(bank.getBankAccount().stream()
                .anyMatch(c -> c.getPerson().equals("Alejandro Peredo")));

    }
}
