package com.company.Functions;

public class Function {
    public static Double activationFunction(Double net) {
        return (1.0-Math.exp(-net))/(1.0+Math.exp(-net));
    }
    public static Double DerivedFunction(Double net) { return 0.5*(1-Math.pow(activationFunction(net),2));}
}
