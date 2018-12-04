package com.Money;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RatesLoader {



  public static Map<String, BigDecimal> loadrates(){
      Stream<String> filelines;
      try {
          filelines = Files.lines(FileSystems.getDefault().getPath("rates.txt"));
      }catch (IOException e) {
          throw new IllegalArgumentException( "Can not load curreny rates file", e);
      }
      Map<String, BigDecimal> rates =
              filelines
                      .map((line) -> line.trim()) // "USDEUR, 123.23", "EURGBP, 234.345"
                      .map((line) -> line.split(",")) // ["USDEUR", "123.23"], ["EURGBP", "234.345"]
                      .distinct()
                      .filter((word) -> word.length == 2)
                      .filter((word) -> word[0].trim().length() >= 6)
                      .filter( (word) -> word[0].matches("[a-zA-Z]+"))
                      .filter( (word) -> word[1].matches("[0-9\\\\.\\s]+"))
                      //.map((input) -> input[0].toUpperCase())
                      .collect(Collectors
                              .toMap( word -> word[0],
                                      word -> new BigDecimal(word[1].trim()),
                                      (u,v) ->  u
                              )
                      );
      System.out.println(rates);
      return rates;


  }
}
