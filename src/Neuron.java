public class Neuron {
    private double bias = Math.random() * 2 - 1;
    private double[] weights;
    private final Neuron[] inputs;
    protected double lastOutput;
    private double learningRate = 0.25;

    public Neuron(Neuron[] inputs){
        randomizeWeights(inputs.length);
        this.inputs = inputs;
    }

    /**
     * Compute an output by getting values and weights from previous neurons
     * <p>Forward propagation</p>
     * @return Output of the neuron
     */
    public double compute(){
        double preActivation = bias;
        for (int i = 0; i < inputs.length; i++) {
            preActivation+= weights[i] * inputs[i].compute();
        }
        lastOutput = sigmoid(preActivation);
        return lastOutput;
    }

    /**
     * weight(old) + learning rate * output error * output(neurons i) * output(neurons i+1) * (1 - output(neurons i+1))
     * <p>Backwards propagation</p>
     * @param outputError Output error of the last computation
     */
    public void changeWeights(double outputError){
        for (int i = 0; i < inputs.length; i++) {
            // change current weight
            weights[i] = weights[i] + learningRate * outputError * inputs[i].lastOutput * lastOutput * (1 - lastOutput);
            // change input weights
            inputs[i].changeWeights(outputError);
        }
        bias = bias + learningRate * outputError * lastOutput * (1 - lastOutput);
    }

    /**
     * Randomizes all the weights
     * @param amount Number of inputs
     */
    public void randomizeWeights(int amount){
        weights = new double[amount];
        for (int i = 0; i < amount; i++) {
            weights[i] = Math.random() * 2 - 1;
        }
    }

    /**
     * Turn a double into a number from -1 to 1 with sigmoid rounding
     * @param in double to be rounded
     * @return sigmoid of the inputted number
     */
    public static double sigmoid(double in){
        return 1 / (1 + Math.exp(-in));
    }

    public double getLastOutput() {
        return lastOutput;
    }
}
