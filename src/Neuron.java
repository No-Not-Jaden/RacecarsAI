import java.util.ArrayList;
import java.util.List;

public class Neuron {
    private double bias = Math.random() * 2 - 1;
    private double[] weights;
    private final Neuron[] inputs;

    public Neuron(Neuron[] inputs){
        randomizeWeights(inputs.length);
        this.inputs = inputs;
    }

    /**
     * Compute an output by getting values and weights from previous neurons
     * @return Output of the neuron
     */
    public double compute(){
        double preActivation = bias;
        for (int i = 0; i < inputs.length; i++) {
            preActivation+= weights[i] * inputs[i].compute();
        }
        return sigmoid(preActivation);
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
}
