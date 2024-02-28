package org.example;

public class Stock {
    public static int maxProfit (int[] prices)

    {
        int BuyPrice = Integer.MAX_VALUE;

        int Sell = 0;

        for (int i = 0; i < prices.length; i++) {

                if (BuyPrice>prices[i])
                {
                    BuyPrice = prices[i];
                }
                int Profit = 0;
                Profit = prices[i] - BuyPrice;

                if (Sell<Profit)
                {
                    Sell = Profit;
            }

        }
        System.gc();
        return Sell;
    }

    public static void main(String[] args) {

        int[] WeekOne = {2,1,8,20};
        System.out.println(Stock.maxProfit(WeekOne));

    }

}
