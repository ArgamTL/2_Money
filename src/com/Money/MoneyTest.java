package com.Money;

import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;

public class MoneyTest {

    @Test
    public void testmoneyMult() {

        Money m = new Money(new BigDecimal("1"), "usDollars");
        Money m1 = m.mult(new BigDecimal("2.5"));
        Assert.assertEquals(new BigDecimal("2.5")+ " USD", m1);

    }

    @Test //(expected = IllegalArgumentException.class)
    public void testDivMoney() {

        Money m = new Money(new BigDecimal("1"), "usDollars");
        Money m1 = m.div(new BigDecimal("2.5"));
        Assert.assertEquals(0.4, m1);

    }

    @Test
    public void testintoEqParts() {

        Money m = new Money(new BigDecimal("1"), "usDollars");
        Money[] eqParts = m.intoEqParts(2);
        Assert.assertEquals(0.5, eqParts[0]);

    }

    @Test
    public void testMoneyPlus() {

        Money m = new Money(new BigDecimal("2.5"), "usDollars");
        Money m1 = new Money(new BigDecimal("2.5"), "usDollars");
        Money m2 = m.Plus(m1);
        Assert.assertEquals(new Money(new BigDecimal("5.0"),"USD"), m2);

    }

    @Test
    public void testMoneyPlusConvert() {

        Money m = new Money(new BigDecimal("1"), "USD");
        Money m1 = new Money(new BigDecimal("10"), "RUB");
        Money m2 = m.Plus(m1);
        Assert.assertEquals( new Money(new BigDecimal("77.071"),"RUB"), m2);

    }

    @Test
    public void testMoneyConvert() {

        Money m = new Money(new BigDecimal("1"), "USD");

        Assert.assertEquals( new Money(new BigDecimal("67.071"),"RUB"), m.Convert("rub"));

    }


}
