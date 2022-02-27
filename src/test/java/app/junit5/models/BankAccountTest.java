package app.junit5.models;


import app.junit5.exceptions.InsufficientMoneyExceptions;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

  BankAccount bankAccount;

  @BeforeEach
  void initMetodTest(){
    this.bankAccount = new BankAccount("Alejandro", new BigDecimal("10000.12345"));
    System.out.println("Iniciando los Test unitarios");
  }

  @AfterEach
  void tearDown() {
    System.out.println("Finalizando las pruebas unitarias");
  }

  @BeforeAll
  static void beforeAll() {
    System.out.println("Inicializando el Test completo");
  }

  @AfterAll
  static void afterAll() {
    System.out.println("Finalizando el test");
  }

  @Test
  @DisplayName("Pruebas para validar el nombre de una cuenta de ahorro")
  void testNameCount() {
      // Verifico que el saldo no sea nulo
      assertNotNull(bankAccount.getBalance(), ()-> "La cuenta no puede ser Nula");

      String esperado = "Alejandro";
      assertEquals(esperado, bankAccount.getPerson(), ()-> "el nombre de la cuenta no es el que se esperaba: "
              + esperado + " lo que tenemos es: " + bankAccount.getPerson());
      // La linea anterior es igual a esta y mas efectiva
      assertTrue(bankAccount.getPerson().equals(esperado), ()-> "Nombre cuenta esperada debe ser igual a la real");
  }

  @Test
  // Con Disabled se indica que ese método no se ejecutará
  //@Disabled
  @DisplayName("Verificando el saldo en una cuenta")
  void testSaldoCuenta() {
      // Verifico que el saldo no sea nulo
      assertNotNull(bankAccount.getBalance());
      assertEquals(10000.12345, bankAccount.getBalance().doubleValue());
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
    @DisplayName("Depósito cuenta")
    void testCreditAmount() {
        bankAccount.credit(new BigDecimal(100));
        // Verifico que el saldo no sea nulo
        assertNotNull(bankAccount.getBalance());
        assertEquals(10100, bankAccount.getBalance().intValue());
        assertEquals("10100.12345", bankAccount.getBalance().toPlainString());
    }

  @Test
  void testInsuficientMoneyExceptionBalance() {
      //BankAccount bankAccount = new BankAccount("Alejandro Peredo", new BigDecimal("2000.121212"));
      Exception exception = assertThrows(InsufficientMoneyExceptions.class, ()->bankAccount.debit(new BigDecimal("10100")));
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

    assertAll(
        // Comparo si en las dos cuenta el saldo es el esperado, en la primera se debita y se
        // acredita en la segunda
        () -> assertEquals("1000", bill2.getBalance().toPlainString(),
                () -> " El valor de la cuenta no es el esperado"),
        () -> assertEquals("3000", bill1.getBalance().toPlainString()),
        () -> assertEquals(2, bank.getBankAccount().size(), () -> "El banco no tiene las cuentas esperadas"),
        () -> // Relacion Banco-Cuentas
        assertEquals("Bank of America", bill1.getBank().getName()),
        () -> // encuentra el nombre de la cuenta
        assertEquals(
                "Alejandro Peredo",
                bank.getBankAccount().stream()
                    .filter(c -> c.getPerson().equals("Alejandro Peredo"))
                    .findFirst()
                    .get()
                    .getPerson()),
        () ->
            assertTrue(
                bank.getBankAccount().stream()
                    .anyMatch(c -> c.getPerson().equals("Alejandro Peredo"))));
  }
}
