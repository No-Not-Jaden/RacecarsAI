import java.util.ArrayList;
import java.util.List;

public class Input extends Neuron{
    private final double value;
    public Input(double value) {
        super(new Neuron[0]);
        this.value = value;
    }

    @Override
    public double compute() {
        return value;
    }
}
