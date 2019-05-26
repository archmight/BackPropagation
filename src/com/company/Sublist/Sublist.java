package com.company.Sublist;

import com.company.Layer.Layer;
import com.company.Neuron.Neuron;

import java.util.ArrayList;

public class Sublist {
    public static ArrayList<Neuron> subLayer(Layer nextLayer){
        return (ArrayList<Neuron>) nextLayer.getNeurons().subList(1, nextLayer.getNeurons().size());
    }
}
