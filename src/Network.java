import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Network {
    Neuron[] inputNeurons = new Neuron[]{new Input(0.1), new Input(0.6), new Input(0.35)};
    int hiddenNodes = 3;
    int outputs = 2;

    Neuron[] network = new Neuron[outputs];

    /**
     * Creates a new Neural Network with randomized weights
     */
    public Network(){
        Neuron[] hiddenNeurons = new Neuron[hiddenNodes];
        for (int h = 0; h < hiddenNodes; h++) {
            hiddenNeurons[h] = new Neuron(inputNeurons);
        }
        for (int o = 0; o < outputs; o++) {
            network[o] = new Neuron(hiddenNeurons);
        }
    }

    public void getOutputs(){
        for (Neuron neuron :
                network) {
            System.out.println(neuron.compute());
        }
    }

}
