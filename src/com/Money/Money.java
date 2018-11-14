package com.Money;

import java.math.BigDecimal;
import java.util.Map;
import java.util.HashMap;

import java.lang.String;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class Money {

    private BigDecimal amount;
    private String currency;
   private static Map<String, BigDecimal> rates = RatesLoader.loadrates();
	

	/*
    static {
        rates.put("USDEUR", new BigDecimal(".8888"));
        rates.put("USDRUB", new BigDecimal("67.071"));
        rates.put("USDBTC", new BigDecimal(".00016"));
        rates.put("EURUSD", new BigDecimal("1.27579"));
        rates.put("EURRUB", new BigDecimal("78.42"));
        rates.put("RUBUSD", new BigDecimal(".015"));
        rates.put("RUBEUR", new BigDecimal(".013"));
    }
   */
    public Money( BigDecimal amount, String currency ) {
        if(amount.compareTo(BigDecimal.ZERO) > 0) {
            this.amount = amount;
        } else {
           throw new IllegalArgumentException("AMOUNT SHOULDN'T BE LESS THAN OR EQUAL TO ZERO!");
        }

        if(currency.length() >= 3) {
            currency = currency.substring(0, 3);
            currency = currency.toUpperCase();
            this.currency = currency;
        }else{
            throw new IllegalArgumentException("PLEASE ENTER A 3 LETTER CURRENCY CODE; e.g. RUB");
        }

    }


    public Money mult(BigDecimal knumber){
        Money result = new Money(this.amount.multiply(knumber), this.currency);
        return result;
    }


    public Money div(BigDecimal knumber){
        Money result = new Money(this.amount.divide(knumber), this.currency);
        return result;

    }

    public Money[] intoEqParts(int knumber){
        BigDecimal[] Divamount = this.amount.divideAndRemainder(new BigDecimal(knumber));
        Money[] result = new Money[knumber];

        for(int i = 0; i < knumber;i++){
            result[i] =  new Money(Divamount[0], this.currency);
        }
        result[0] = result[0].Plus(new Money(Divamount[1], this.currency ) );
        return result;
    }

    public Money Plus(Money other){
        if(this.currency.equals(other.currency)) {
            Money result = new Money(this.amount.add(other.amount), this.currency );
            return result;
        }else{
            Money result = this.Convert(other.currency);
            Money result_p = new Money(result.amount.add(other.amount), result.currency);
            return result_p;
        }
    }


    public Money Convert( String out_currency ) {
        if(out_currency.length() >= 3) {
            out_currency = out_currency.substring(0, 3);
            out_currency = out_currency.toUpperCase();
        }else{
            throw new IllegalArgumentException("PLEASE ENTER A 3-LETTER CURRENCY CODE: e.g. RUB");
        }

        if (this.currency.equals(out_currency)){
            throw new IllegalArgumentException("PLEASE ENTER DIFFERENT CURRENCIES");
        }

        try{
            BigDecimal converted_amount = this.amount.multiply(this.rates.get(this.currency.concat(out_currency)));
            Money result = new Money(converted_amount, out_currency);
            return result;
        }catch(NullPointerException e){
            throw new IllegalArgumentException("PLEASE ASK OUR ADMIN TO ADD THAT CURRENCY!");
        }
    }


    public BigDecimal getAmount(){ return this.amount; }
	
    public String getCurrency() { return this.currency; }
	
    public String  toString(){ return this.amount + " " + this.currency; }

}