package com.company.Neural;

import com.company.Functions.Function;
import com.company.Layer.Layer;
import com.company.NeuronValue.NeuronValue;

import java.util.ArrayList;

public class NeuralNet {
    ArrayList<Layer> layers;
    ArrayList<Double> trueOutput;
    ArrayList<Double> net1;
    ArrayList<Double> net2;
    ArrayList<Double> delta1Inner;
    ArrayList<Double> delta2Output;
    final Double LearningRate = 0.3;


    public NeuralNet(ArrayList<Double> InputValues, Integer InnerSize, ArrayList<Double> OutputLayer){
        layers = new ArrayList<>(3);
        for (int i = 0; i < 3; ++i){
            layers.add(i, null);
        }

        trueOutput = OutputLayer;

        layers.set(2, new Layer(OutputLayer.size(),OutputLayer));
        layers.set(1,new Layer(InnerSize,layers.get(2).getSize()));
        layers.set(0, new Layer(InputValues.size(),InputValues,layers.get(1).getSize()-1));

        net2 = new ArrayList<>(layers.get(2).getNeurons().size());
        delta2Output = new ArrayList<>(layers.get(2).getNeurons().size());
        for (int i = 0; i < layers.get(2).getNeurons().size(); i++) {
            delta2Output.add(0.0);
            net2.add(0.0);
        }

        net1 = new ArrayList<>(layers.get(1).getNeurons().size()-1);
        delta1Inner = new ArrayList<>(layers.get(1).getNeurons().size()-1);
        for (int i = 0; i < layers.get(1).getNeurons().size()-1; i++) {
            delta1Inner.add(0.0);
            net1.add(0.0);
        }


    }


    public void deltaOutput() {
        for (int i = 0; i < net2.size(); i++) {
            delta2Output.set(i,(trueOutput.get(i)-layers.get(2).getNeurons().get(i).getNeuronValue().getValue())*Function.DerivedFunction(net2.get(i)));
        }
    }

    public ArrayList<Double> getDelta2Output() {
        return delta2Output;
    }

    public ArrayList<Double> getDelta1Inner() {
        return delta1Inner;
    }

    public  void deltaInner() {


        Double sumDeltaWeight;

        for (int i = 0; i < net1.size(); i++) {
            sumDeltaWeight = 0.0;

            for (int j = 0; j < net2.size(); j++) {
                sumDeltaWeight += delta2Output.get(j)*layers.get(1).getNeurons().get(i).getOutputSignals().getOutputSignals().get(j).getWeight();
            }

            delta1Inner.set(i,sumDeltaWeight*Function.DerivedFunction(net1.get(i)));
        }
    }


    public void Activation() {
        ActivationInnerLayer();
        ActivationOutputLayer();
    }


    public void delta() {
        deltaOutput();
        deltaOutput();
    }


    public void ActivationInnerLayer() {
        Double sumValue = 0.0;
        Double activationValue = 0.0;

        for (int i = 0; i <layers.get(1).getNeurons().size()-1; i++) {
            sumValue =  layers.get(0).sumForNextLayer(i);

            net1.set(i,sumValue);
            activationValue = Function.activationFunction(sumValue);
            layers.get(1).getNeurons().get(i+1).setNeuronValue(new NeuronValue(activationValue));   //neuronActivation

        }
    }

    public void ActivationOutputLayer() {
        Double sumValue = 0.0;
        Double activationValue = 0.0;
        for (int i = 0; i <layers.get(2).getNeurons().size(); i++) {
            sumValue =  layers.get(1).sumForNextLayer(i);
            net2.set(i,sumValue);
            activationValue = Function.activationFunction(sumValue);
            layers.get(2).getNeurons().get(i).setNeuronValue(new NeuronValue(activationValue));   //neuronActivation
        }

    }


    public ArrayList<Layer> getLayers() {
        return layers;
    }

    public void setLayers(ArrayList<Layer> layers) {
        this.layers = layers;
    }

    public void training() {
        trainingInnerOutput();
        trainingInputInner();
    }

    public void trainingInputInner() {
        Double a = 0.0;
        for (int i = 0; i < layers.get(0).getSize(); ++i) {
            a = 0.0;
            for (int j = 0; j < delta1Inner.size(); ++j) {
                a = LearningRate*layers.get(0).getNeurons().get(i).getNeuronValue().getValue().doubleValue()*delta1Inner.get(j);
                layers.get(0).getNeurons().get(i).getOutputSignals().getOutputSignals().get(j).IncreaseWeight(a);
            }
        }
    }

    public void trainingInnerOutput() {
        Double a = 0.0;
        for (int i = 0; i < layers.get(1).getSize(); i++) {
            a = 0.0;
            for (int j = 0; j < delta2Output.size(); j++) {
                a = LearningRate*layers.get(1).getNeurons().get(i).getNeuronValue().getValue().doubleValue()*delta2Output.get(j);
                layers.get(1).getNeurons().get(i).getOutputSignals().getOutputSignals().get(j).IncreaseWeight(a);
            }
        }
    }




    public Double errorRootValue() {
        Double result = 0.0;
        for (int i = 0; i < layers.get(2).getNeurons().size(); ++i){
            result += Math.pow(trueOutput.get(i)-layers.get(2).getNeurons().get(i).getNeuronValue().getValue(),2);
        }
        return Math.sqrt(result);
    }




}
