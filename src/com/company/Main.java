package com.company;


import com.company.Graphics.DrawGraphics;
import com.company.Neural.NeuralNet;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        ArrayList<Double> Input = new ArrayList<>(Arrays.asList(0.2,0.1));
        Integer InnerSize = 2;
        ArrayList<Double> Output = new ArrayList<>(Arrays.asList(0.2,0.1));
        NeuralNet net = new NeuralNet(Input,InnerSize,Output);

        System.out.println(net.getLayers().get(0).getNeurons().get(0).getOutputSignals().getOutputSignals().get(0).getWeight());
        System.out.println(net.getLayers().get(0).getNeurons().get(1).getOutputSignals().getOutputSignals().get(0).getWeight());
        System.out.println(net.getLayers().get(0).getNeurons().get(2).getOutputSignals().getOutputSignals().get(0).getWeight());
        System.out.println(net.getLayers().get(1).getNeurons().get(0).getOutputSignals().getOutputSignals().get(0).getWeight());
        System.out.println(net.getLayers().get(1).getNeurons().get(0).getOutputSignals().getOutputSignals().get(1).getWeight());
        System.out.println(net.getLayers().get(1).getNeurons().get(1).getOutputSignals().getOutputSignals().get(0).getWeight());
        System.out.println(net.getLayers().get(1).getNeurons().get(1).getOutputSignals().getOutputSignals().get(1).getWeight());

        System.out.println("sum" + net.getLayers().get(0).sumForNextLayer(0));

//         net.ActivationInnerLayer();
//        System.out.println("!!!!" + net.getLayers().get(1).getNeurons().get(1).getNeuronValue().getValue());
//        System.out.println("ddd"+net.getLayers().get(2).getNeurons().get(1).getNeuronValue().getValue());
//        net.ActivationOutputLayer();
//        System.out.println("ddd" + net.getLayers().get(2).getNeurons().get(1).getNeuronValue().getValue());
//        net.deltaOutput();
//        net.deltaInner();


//        ArrayList<Double> a = net.getDelta1Inner();

        ArrayList<Integer> Error = net.Lesson();



        for (int i  = 0; i < Error.size(); ++i){
            System.out.println(Error.get(i));
        }
        new DrawGraphics(Error,"aa");


        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(net.getLayers().get(0).getNeurons().get(0).getNeuronValue().getValue());
        System.out.println(net.getLayers().get(0).getNeurons().get(1).getNeuronValue().getValue());
        System.out.println(net.getLayers().get(1).getNeurons().get(0).getNeuronValue().getValue());
        System.out.println(net.getLayers().get(2).getNeurons().get(0).getNeuronValue().getValue());
        System.out.println(net.getLayers().get(2).getNeurons().get(1).getNeuronValue().getValue());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");



        System.out.println("///////////////////////////////////////");
        System.out.println(net.getLayers().get(0).getNeurons().get(0).getOutputSignals().getOutputSignals().get(0).getWeight());
        System.out.println(net.getLayers().get(0).getNeurons().get(1).getOutputSignals().getOutputSignals().get(0).getWeight());
        System.out.println(net.getLayers().get(0).getNeurons().get(2).getOutputSignals().getOutputSignals().get(0).getWeight());
        System.out.println(net.getLayers().get(1).getNeurons().get(0).getOutputSignals().getOutputSignals().get(0).getWeight());
        System.out.println(net.getLayers().get(1).getNeurons().get(0).getOutputSignals().getOutputSignals().get(1).getWeight());
        System.out.println(net.getLayers().get(1).getNeurons().get(1).getOutputSignals().getOutputSignals().get(0).getWeight());
        System.out.println(net.getLayers().get(1).getNeurons().get(1).getOutputSignals().getOutputSignals().get(1).getWeight());

        System.out.println("///////////////////////////////////////");


    }
}
