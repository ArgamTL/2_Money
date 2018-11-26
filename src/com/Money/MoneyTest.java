package com.Money;

import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;

public class MoneyTest {

    @Test
    public void testmoneyMult() {

        Money m = new Money(new BigDecimal("2"), "usDollars");
        Money m1 = m.mult(new BigDecimal("2.5"));
        Assert.assertEquals(m1.getAmount(), new BigDecimal("5.0"));
        Assert.assertEquals(m.getCurrency(), m1.getCurrency());


    }

    @Test //(expected = IllegalArgumentException.class)
    public void testDivMoney() {

        Money m = new Money(new BigDecimal("1"), "usDollars");
        Money m1 = m.div(new BigDecimal("2.5"));
        Assert.assertEquals(new Money(new BigDecimal("0.4"),"USD"), m1);

    }

    @Test
    public void testintoEqParts() {

        Money me = new Money(new BigDecimal("10"), "usDollars");
        Money[] eqParts = me.intoEqParts(2);
        Assert.assertEquals(new Money(new BigDecimal("5"),"USD"), eqParts[0]);

    }

    @Test
    public void testMoneyPlus() {

        Money m = new Money(new BigDecimal("2.5"), "usd");
        Money m1 = new Money(new BigDecimal("2.5"), "usd");
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
        Assert.assertEquals( new Money(new BigDecimal("67.071"),"RUB"), m.Convert("RUB"));

    }




}
