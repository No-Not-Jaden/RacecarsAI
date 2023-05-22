public class Network {
    Neuron[] inputNeurons;
    double[] expected = new double[]{1};
    int hiddenNodes;
    int hiddenLayers;
    int outputs;
    
    double[] error;

    Neuron[] network; // output neurons

    /**
     * Creates a new Neural Network with randomized weights
     */
    public Network(int inputs, int hiddenLayers, int hiddenNodes, int outputs){
        this.hiddenLayers = hiddenLayers;
        this.hiddenNodes = hiddenNodes;
        this.outputs = outputs;
        error = new double[outputs];
        inputNeurons = new Neuron[inputs];
        network = new Neuron[outputs];
        for (int i = 0; i < inputs; i++) {
            inputNeurons[i] = new Input(0);
        }
        Neuron[] lastLayer = new Neuron[hiddenNodes];
        for (int h = 0; h < hiddenNodes; h++) {
            lastLayer[h] = new Neuron(inputNeurons);
        }
        Neuron[] thisLayer;
        for (int i = 1; i < hiddenLayers; i++) {
            thisLayer = new Neuron[hiddenNodes];
            for (int h = 0; h < hiddenNodes; h++) {
                thisLayer[h] = new Neuron(lastLayer);
            }
            lastLayer = thisLayer;
        }

        for (int o = 0; o < outputs; o++) {
            network[o] = new Neuron(lastLayer);
        }
    }

    public void setValues(double[] inputs, double[] expected){
        for (int i = 0; i < inputNeurons.length; i++) {
            ((Input) inputNeurons[i]).setInput(inputs[i]);
        }
        this.expected = expected;
    }

    public double[] forwardPropagate(){
        double[] computations = new double[network.length];
        for (int i = 0; i < network.length; i++) {
            computations[i] = network[i].compute();
            error[i] = expected[i] - computations[i];
        }
        return computations;
    }

    public void propagate(int amount){
        for (int i = 0; i < amount; i++) {
            forwardPropagate();
            backwardPropagate();
        }
    }

    public void backwardPropagate(){
        for (int i = 0; i < network.length; i++) {
            network[i].changeWeights(error[i]);
        }
    }

}
