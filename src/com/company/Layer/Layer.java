package com.company.Layer;

import com.company.Neuron.Neuron;
import com.company.Sublist.Sublist;

import java.util.ArrayList;

public class Layer {

    ArrayList<Neuron> neurons;



    //Input Layer
    public Layer(Integer LayerSize, ArrayList<Double> NValue, Integer sizeOfNextLayer) {
        neurons = new ArrayList<>(LayerSize+1);
        neurons.add(0,new Neuron(1.0,sizeOfNextLayer));
        for (int i = 1; i < LayerSize+1; i++) {
            neurons.add(i, new Neuron(NValue.get(i-1),sizeOfNextLayer));
        }
    }

    //Inner Layer
    public Layer(Integer LayerSize, Integer sizeOfNextLayer) {
        neurons = new ArrayList<>(LayerSize+1);
        neurons.add(0,new Neuron(1.0,sizeOfNextLayer));
        for (int i = 1; i < LayerSize+1; i++) {
            neurons.add(i, new Neuron(sizeOfNextLayer));
        }
    }

    //Output Layer
    public Layer(Integer LayerSize, ArrayList<Double> NValue) {
        neurons = new ArrayList<>(LayerSize);
        for (int i = 0; i < LayerSize; i++) {
            neurons.add(i, new Neuron(NValue.get(i)));
        }
    }


    public Double sumForNextLayer (Integer number) {
        Double sum = 0.0;
        Double Value = 0.0;
        Double Weight = 0.0;
        for (int i = 0; i < neurons.size(); ++i) {
            Value = neurons.get(i).getNeuronValue().getValue();
            Weight = neurons.get(i).getOutputSignals().getOutputSignals().get(number).getWeight();
            sum += Weight*Value;
        }
        return sum;
    }


    public Double sumWeightsForDelta (Integer number){
        Double weightSum = 0.0;
        for (int i = 0; i < neurons.size(); ++i) {
            weightSum += neurons.get(i).getOutputSignals().getOutputSignals().get(number).getWeight();
        }
        return weightSum;
    }


    public ArrayList<Neuron> getNeurons() {
        return neurons;
    }

    public void setNeurons(ArrayList<Neuron> neurons) {
        this.neurons = neurons;
    }

    public Integer getSize(){
        return neurons.size();
    }
}
