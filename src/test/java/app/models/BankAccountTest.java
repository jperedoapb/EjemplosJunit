package app.models;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
  @Test
  void testNameCount() {
      BankAccount bankAccount = new BankAccount("Alejandro", new BigDecimal("10000.12345"));

      // Verifico que el saldo no sea nulo
      assertNotNull(bankAccount.getAmount());

      String esperado = "Alejandro";
      assertEquals(esperado, bankAccount.getPerson());
      // La linea anterior es igual a esta y mas efectiva
      assertTrue(bankAccount.getPerson().equals(esperado));
  }

  @Test
  void testSaldoCuenta() {
      BankAccount bankAccount = new BankAccount("Alejandro", new BigDecimal("123456.123456"));
      // Verifico que el saldo no sea nulo
      assertNotNull(bankAccount.getAmount());
      assertEquals(123456.123456, bankAccount.getAmount().doubleValue());
      // Comparamos que sea falsa una premisa
      assertFalse(bankAccount.getAmount().compareTo(BigDecimal.ZERO) < 0);
      // Comparamos que sea verdadera la premisa
      assertTrue(bankAccount.getAmount().compareTo(BigDecimal.ZERO) > 0);
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
      assertNotNull(bankAccount.getAmount());
      assertEquals(900, bankAccount.getAmount().intValue());
      assertEquals("2000.121212", bankAccount.getAmount().toPlainString());
  }

    @Test
    void testCreditAmount() {
        BankAccount bankAccount = new BankAccount("Alejandro Peredo", new BigDecimal("2000.121212"));
        bankAccount.credit(new BigDecimal(100));
        // Verifico que el saldo no sea nulo
        assertNotNull(bankAccount.getAmount());
        assertEquals(2900, bankAccount.getAmount().intValue());
        assertEquals("2000.121212", bankAccount.getAmount().toPlainString());
    }
}