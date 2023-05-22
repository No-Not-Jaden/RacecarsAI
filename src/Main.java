import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] path = new int[][]{
                { 0, 0, 0, 0, 0,48,49,50, 0, 0},
                {17,18,19, 0, 0,47, 0, 0, 0, 0},
                {16, 0, 0,20, 0,46,45,44,43, 0},
                {15, 0, 0,21, 0, 0, 0, 0,42,41},
                {14, 0, 0,22,23,24,25, 0, 0,40},
                {13,12, 0, 0, 0, 0,26,27, 0,39},
                { 0,11,10, 9, 8, 0, 0,28, 0,38},
                { 0, 0, 0, 0, 7, 0,30,29, 0,37},
                { 0, 0, 4, 5, 6, 0,31, 0, 0,36},
                { 1, 2, 3, 0, 0, 0,32,33,34,35}
        };

        //Environment environment = new Environment(path);

        /*
        Network network = new Network(1, 2, 25, 1);
        for (int i = 0; i < 10000; i++) {
            double input = Math.random();
            double output = 1 - input;
            network.setValues(new double[]{input}, new double[]{output});
            network.propagate(1);
        }


        network.setValues(new double[]{0.25}, new double[]{0.25});*/

        Network network = new Network(2, 1, 100, 1);

        double[][][] presetValues = new double[][][]{
                {new double[]{0,0}, new double[]{0}},
                {new double[]{0,1}, new double[]{1}},
                {new double[]{1,0}, new double[]{1}},
                {new double[]{1,1}, new double[]{0}}
        };

        for (int i = 0; i < 100000; i++) {
            int index = (int) (Math.random() * 4);

            network.setValues(presetValues[index][0], presetValues[index][1]);
            network.propagate(1);
        }


        for (int i = 0; i < 5; i++) {

            int index = (int) (Math.random() * 4);

            network.setValues(presetValues[index][0], presetValues[index][1]);

            System.out.println(Arrays.toString(presetValues[index][0]));
            System.out.println(Arrays.toString(presetValues[index][1]));

            System.out.println(Arrays.toString(network.forwardPropagate()));
        }
    }
}
