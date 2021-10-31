package Currency;

import Enums.Coins;

public class CoinFactory {
//    "getCoinInstance" method to get the instance of a coin
    public static Coin getCoinInstance(Coins coin){
        switch (coin) {
            case ILS:
                return new ILS();
            case USD:
                return new USD();
        }
        return null;
    }
}
