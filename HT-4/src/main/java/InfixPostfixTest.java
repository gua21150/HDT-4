//package main.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
class InfixPostfixTest {
  InfixPostfix pruebaInfix;
  @org.junit.jupiter.api.BeforeEach
  void setUp() {
      pruebaInfix = new InfixPostfix();
  }
  Test
  void conversion() {
      assertEquals("5  6+", pruebaInfix.conversion("5 + 6"));
  }
}