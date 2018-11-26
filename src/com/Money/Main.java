package com.Money;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


      Money m1 = new Money(new BigDecimal("10"), "rub");
      Money m2 = new Money(new BigDecimal("10"), "usd");
      Money m3 = m1.Plus(m2);
      System.out.println( m1.getAmount() + " " + m1.getCurrency() + " + " +
                          m2.getAmount() + " " + m2.getCurrency() + " = " + m3);

      Money m4 = m1.div(new BigDecimal("2.5"));
      System.out.println( m1.getAmount() + "/2.5 = " + m4);

      Money m5 = m1.mult(new BigDecimal("2.5"));
      System.out.println(m1.getAmount() + "*2.5 = " + m5);

      Money [] eqParts = m1.intoEqParts(2);
      System.out.println( m1.getAmount()   + " " +
                          m1.getCurrency() + " into 2 equal parts = " + eqParts[0]);


      Money ex = new Money(new BigDecimal( 10), "rub");
      Money result = ex.Convert("usd");
      System.out.println(ex.getAmount() + " " +
                         ex.getCurrency() + " converted into " +
                         result.getCurrency() + " = " + result);

    }
}