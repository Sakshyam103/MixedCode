package Algorithms;

public class BuyingTwoChocolate {
    public static int buyChoco(int[] prices, int money) {
        int x = 0;
        int max = -1;
        if(prices.length>=2 && prices.length<= 50){
            for(int i = 0; i< prices.length; i++){
                for(int j = 0; j< prices.length; j++){
                    if(i!=j){
                        x = money-prices[i]-prices[j];
                        if(x>= 0){
                            if(max < x){
                                max = x;
                            }
                        }
                    }
                }
            }
        }
        if(max == -1){
            return money;
        }else{
        return max;}
    }

    public static void main(String[] args) {
        int[] prices = {98,54,6,34,66,63,52,39};
        int money = 62;
        System.out.println(buyChoco(prices,money));
    }
}
