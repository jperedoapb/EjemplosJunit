package app.models;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
  @Test
  void testNameCount() {
      BankAccount bankAccount = new BankAccount("Alejandro", new BigDecimal("10000.12345"));
      //bankAccount.setPerson("Alejandro");

      String esperado = "Alejandro";
      assertEquals(esperado, bankAccount.getPerson());
      // La linea anterior es igual a esta y mas efectiva
      assertTrue(bankAccount.getPerson().equals(esperado));
  }

  @Test
  void BankAccountTest() {
      BankAccount bankAccount = new BankAccount("Alejandro", new BigDecimal("123456.123456"));
      assertEquals(123456.123456, bankAccount.getAmount().doubleValue());
      // Comparamos que sea falsa una premisa
      assertFalse(bankAccount.getAmount().compareTo(BigDecimal.ZERO) < 0);
      // Comparamos que sea verdadera la premisa
      assertTrue(bankAccount.getAmount().compareTo(BigDecimal.ZERO) > 0);
  }



}