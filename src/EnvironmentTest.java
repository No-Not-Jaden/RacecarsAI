

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class EnvironmentTest {
    int[][] path = new int[][]{
            { 0, 0, 0, 0, 0,49,50,51,52,53},
            {17,18,19, 0, 0,48, 0, 0, 0, 0},
            {16, 0,20,21, 0,47,46,45,44, 0},
            {15, 0, 0,22, 0, 0, 0, 0,43,42},
            {14, 0, 0,23,24,25,26, 0, 0,41},
            {13,12, 0, 0, 0, 0,27,28, 0,40},
            { 0,11,10, 9, 8, 0, 0,29, 0,39},
            { 0, 0, 0, 0, 7, 0,31,30, 0,38},
            { 0, 0, 4, 5, 6, 0,32, 0, 0,37},
            { 1, 2, 3, 0, 0, 0,33,34,35,36}
    };
    int scale = 10;
    Environment environment = new Environment(path, scale);


    @org.junit.jupiter.api.Test
    void getTileValue() {
        assertEquals(1, environment.getTileValue(90,0));
        assertEquals(0, environment.getTileValue(1,5));
        assertEquals(23, environment.getTileValue(46,32));
        assertEquals(0, environment.getTileValue(-2,3));
        assertEquals(0, environment.getTileValue(1,-99));
        assertEquals(0, environment.getTileValue(1000,230));
        assertEquals(0, environment.getTileValue(70,50));
    }

    @org.junit.jupiter.api.Test
    void checkForWall() {
        assertTrue(environment.checkForWall(5, 5, 15, 15));
    }

    @org.junit.jupiter.api.Test
    void getDistanceToWalls() {
        float[] result = environment.getDistanceToWalls(8, 15, 5, 0.1f, 0.5f);
        int[] roundedResult = new int[result.length];
        for (int i = 0; i < result.length; i++) {
            roundedResult[i] = Math.round(result[i]);
        }
        int[] expected = new int[]{45,7,25,7,5,7,5,7};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], roundedResult[i]);
        }

    }
}