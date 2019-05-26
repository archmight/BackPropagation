package com.company.outputSignals;

import com.company.RandomGenerator.RandomGenerator;

import java.util.ArrayList;

public class OutputSignals {
    ArrayList<OutputSignal> outputSignals;

    public OutputSignals(Integer sizeOfLayer) {
        outputSignals = new ArrayList<>(sizeOfLayer);
        InitWeight(sizeOfLayer);
    }


    void InitWeight(Integer sizeOfLayer){
        for (int i = 0; i < sizeOfLayer; ++i){
            outputSignals.add(i, new OutputSignal(RandomGenerator.mainFunction()));
        }
    }

    public ArrayList<OutputSignal> getOutputSignals() {
        return outputSignals;
    }

    public void setOutputSignals(ArrayList<OutputSignal> outputSignals) {
        this.outputSignals = outputSignals;
    }
}
