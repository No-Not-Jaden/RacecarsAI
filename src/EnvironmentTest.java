

import static org.junit.jupiter.api.Assertions.*;

class EnvironmentTest {
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
    int scale = 10;
    Environment environment = new Environment(path, scale);


    @org.junit.jupiter.api.Test
    void getTileValue() {
        assertEquals(1, environment.getTileValue(90,0));
        assertEquals(0, environment.getTileValue(1,5));
        assertEquals(22, environment.getTileValue(46,32));
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
    }
}