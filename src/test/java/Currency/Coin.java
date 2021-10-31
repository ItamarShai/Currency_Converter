package Currency;

import Interfaces.ICalculate;

public abstract class Coin implements ICalculate {
//    "getValue" method to return a double variable.
    public abstract double getValue();

    @Override
    public double calculate(double input) {
        return 0;
    }
}
