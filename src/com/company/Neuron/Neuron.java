package com.company.Neuron;

import com.company.NeuronValue.NeuronValue;
import com.company.outputSignals.OutputSignals;

public class Neuron {
    OutputSignals OutputSignals;
    NeuronValue NeuronValue;




    //Neuron of Input Layer
    public Neuron(Double NValue, Integer sizeOfNextLayer) {
        NeuronValue = new NeuronValue(NValue);
        OutputSignals = new OutputSignals(sizeOfNextLayer);
    }


    //Neuron of Inner Layer
    public Neuron(Integer sizeOfNextLayer){
        NeuronValue = new NeuronValue(0.0);
        OutputSignals = new OutputSignals(sizeOfNextLayer);
    }

    //Neuron of OutputLayer
    public Neuron(Double NValue){
        NeuronValue = new NeuronValue(NValue);
    }


    public OutputSignals getOutputSignals() {
        return OutputSignals;
    }

    public void setOutputSignals(OutputSignals outputSignals) {
        OutputSignals = outputSignals;
    }

    public NeuronValue getNeuronValue() {
        return NeuronValue;
    }

    public void setNeuronValue(NeuronValue neuronValue) {
        NeuronValue = neuronValue;
    }
}
