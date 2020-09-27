package com.anla.sseemitter.rx;

/**
 * Temperature in Celsius.
 */
public final class Temperature {
   private final double value;

   public Temperature(double value) {
      this.value = value;
   }

   public double getValue() {
      return value;
   }
}
