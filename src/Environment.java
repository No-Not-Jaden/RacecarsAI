public class Environment {
    private final int[][] path; // each tile is scale x scale units
    private final int scale;
    public Environment(int[][] path, int scale){
        this.path = path;
        this.scale = scale;
    }

    /**
     * Get the value associated with the tile in the given position
     * @param x x-coordinate of object
     * @param y y-coordinate of object
     * @return Tile value
     */
    public int getTileValue(float x, float y){
        if (x < 0 || y < 0 || x > path.length * scale || y > path[0].length * scale)
            return 0; // return 0 for wall if the coordinates are out of bounds
        return path[(int) x / scale][(int) y / scale]; // divide by scale to transform [x][y] into [row][column] for path
    }

    /**
     * Gets distances to walls around an object
     * @param rays Number of distances that will be calculated
     * @param x x-coordinate of object
     * @param y y-coordinate of object
     * @param accuracy How accurate the rays are - 1 moves with the scale, smaller numbers are more accurate
     * @param blur thickness of the ray is - 1 is 1/10 the scale of the environment
     * @return Distances around an abject
     */
    public float[] getDistanceToWalls(int rays, float x, float y, float accuracy, float blur){
        float[] distances = new float[rays];
        // for loop for each ray to be found - r is radians
        for (int r = 0; r < 2 * Math.PI; r+= 2 * Math.PI / rays) {
            // these values are the distances between when the ray initially checks for collision
            float xBlockChange = (float) (Math.cos(r) * accuracy * scale);
            float yBlockChange = (float) (Math.sin(r) * accuracy * scale);
            // These values are going to be where the ray intercepts a wall
            float xIntercept = x;
            float yIntercept = y;
            // find where the next block intercept is
            while (!checkForWall(xIntercept - blur / 2, yIntercept - blur / 2, xIntercept + blur / 2, yIntercept + blur / 2)){
                x+= xBlockChange;
                y+= yBlockChange;
            }
            float distance = (float) Math.sqrt(Math.pow(xIntercept - x, 2) + Math.pow(yIntercept - y, 2)); // distance formula
            distances[(int) (r / (2 * Math.PI / rays))] = distance; // set the array value
        }
        return distances;
    }

    /**
     * Checks if there is a wall inside the coordinates
     * @param minX Minimum x value
     * @param minY Minimum y value
     * @param maxX Maximum x value
     * @param maxY Maximum y value
     * @return true if there is a wall inside the bounds
     */
    public boolean checkForWall(float minX, float minY, float maxX, float maxY){
        for (float x = minX; x < maxX; x+= scale) {
            for (float y = minY; y < maxY; y+= scale) {
                if (getTileValue(x, y) == 0)
                    return true;
            }
        }
        return getTileValue(maxX, maxY) == 0;
    }
}
