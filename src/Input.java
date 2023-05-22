import java.util.ArrayList;
import java.util.List;

public class Input extends Neuron{
    private double value;
    public Input(double value) {
        super(new Neuron[0]);
        this.value = value;
        lastOutput = value;
    }

    @Override
    public void changeWeights(double outputError) {
    }

    @Override
    public double compute() {
        return value;
    }

    public void setInput(double value){
        this.value = value;
    }
}
