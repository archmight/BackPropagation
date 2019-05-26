package com.company.outputSignals;

public class OutputSignal {

    Double Weight;

    public OutputSignal(double weight) {
        Weight = weight;
    }

    public Double getWeight() {
        return Weight;
    }

    public void IncreaseWeight(Double weight) {
        Weight +=weight;
    }

    public void setWeight(Double weight) {
        Weight = weight;
    }

}
