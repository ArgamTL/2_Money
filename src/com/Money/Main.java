package com.Money;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

      Money m1 = new Money(new BigDecimal("10"), "usDollars");
      Money m2 = new Money(new BigDecimal("10"), "ruble");
      Money m3 = m1.Plus(m2);
      System.out.println("\n" + m3);

      Money m4 = m1.div(new BigDecimal("2.5"));
      Money m5 = m1.mult(new BigDecimal("2.5"));

      //Money [] eqParts = m1.intoEqParts(1);

      System.out.println(m1.Plus(m2));
      System.out.println(m4);
      System.out.println(m5);
      //System.out.println(" = " + eqParts[0]);


       /*
        Money ex = new Money(new BigDecimal( 1), "USdollars");
        Money result = ex.Convert("Rubles");
        System.out.println(ex.getAmount() + " " + ex.getCurrency() + " = " + result);
        */
    }
}