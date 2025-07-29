package com.java.interviewPrep.designPatterns.strategyDP;




import java.util.Arrays;
import java.util.List;

interface TicketPrice{
    int calculatePrice(int basePrice);
}

class PeekTime implements TicketPrice{

    @Override
    public int calculatePrice(int basePrice) {
        System.out.println("Price during peek time increase by 10! ");
        return basePrice+10;
    }
}
class Location implements TicketPrice{

    @Override
    public int calculatePrice(int basePrice) {
        System.out.println("Price of location time increase by 20! ");
        return basePrice+20;
    }
}
class PriceStrategy {
   private final List<TicketPrice> strategies;

    PriceStrategy(List<TicketPrice> strategies) {
        this.strategies = strategies;
    }

    public int calculatePrice(int basePrice){
        int price = basePrice;
        for(TicketPrice p:strategies){
            price = p.calculatePrice(price);
        }
        return price;
    }
}
public class StrategyMain {

    public static void main(String[] args) {
        int basePrice = 20;
        TicketPrice peekTime = new PeekTime();
        TicketPrice location = new Location();

        PriceStrategy priceStrategy = new PriceStrategy(Arrays.asList(
                peekTime,location));

        int finalPrice = priceStrategy.calculatePrice(basePrice);
        System.out.println("Final price of the ticket := "+ finalPrice);
    }
}
