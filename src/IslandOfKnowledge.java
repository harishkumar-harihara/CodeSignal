import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class IslandOfKnowledge {

    boolean areEquallyStrong(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {
        int yourMax = Math.max(yourLeft,yourRight);
        int yourMin = Math.min(yourLeft,yourRight);

        int friendsMax = Math.max(friendsLeft,friendsRight);
        int friendsMin = Math.min(friendsLeft,friendsRight);

        return (yourMax==friendsMax && yourMin==friendsMin)?true:false;
    }

    int arrayMaximalAdjacentDifference(int[] inputArray) {

        int maxDiff = Integer.MIN_VALUE;
        int x=0, y=0, greaterAdjVal = 0;

        for(int i = 1; i < inputArray.length-1; i++){
            x = Math.abs(Math.subtractExact(inputArray[i],inputArray[i-1]));
            y = Math.abs(Math.subtractExact(inputArray[i],inputArray[i+1]));
            greaterAdjVal = Math.max(x,y);
            maxDiff = Math.max(maxDiff,greaterAdjVal);
        }
        System.out.println(maxDiff);
        return maxDiff;
    }

    boolean isIPv4Address(String inputString) {
        String inputArray[] = inputString.split("\\.");

        String regex = "(1[0-9][0-9]|2[0-4][0-9]|25[0-5]|[1-9][0-9]|[0-9])";
        if(!(inputArray.length == 4))
            return false;

        for(String x: inputArray){
            boolean b = Pattern.matches(regex,x);
            if(!b)
                return false;
        }

        return true;
    }

    int avoidObstacles(int[] inputArray) {
        int probeLength = 0;
        int maxValue = Arrays.stream(inputArray).max().getAsInt();
        List<Integer> temp = new ArrayList<>();

        for (int i = 1; i < maxValue; i++){
            temp.clear();
            for(int j = 0; j < inputArray.length; j++){
                temp.add(inputArray[j]%i);
            }
            if(!temp.contains(0)) {
                probeLength = i;
                break;
            }
        }
        return (probeLength==0)?(maxValue+1):probeLength;
    }

    int[][] boxBlur(int[][] image) {
        int d = 3;
        int[][] blurredImage = new int[image.length-d+1][image[0].length-d+1];

        for(int i = 1; i < image.length-1; i++){
            for(int j = 1; j < image[0].length-1; j++){
                blurredImage[i-1][j-1] = getNeighBoursSum(image,i,j);
            }
        }
        return blurredImage;
    }

    int getNeighBoursSum(int[][] image, int i, int j){
        int avg = (image[i][j] + image[i][j-1] + image[i][j+1] + image[i-1][j] + image[i+1][j] +
                image[i-1][j-1] + image[i-1][j+1] + image[i+1][j-1] + image[i+1][j+1])/9;
        return avg;
    }

    int[][] minesweeper(boolean[][] matrix) {
        int[][] minesweeperMatrix = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                minesweeperMatrix[i][j] = getMinesCount(matrix,i,j);
            }
        }
        return minesweeperMatrix;
    }

    int getMinesCount(boolean[][] matrix, int i, int j){

        if(i==0){
            if(j==0) {
                return getSouth(matrix,i,j) + getSouthEast(matrix,i,j) + getEast(matrix,i,j);
            }else if(j==matrix[0].length-1){
                return getWest(matrix,i,j) + getSouth(matrix,i,j) + getSouthWest(matrix,i,j);
            }else{
                return getWest(matrix,i,j) + getEast(matrix,i,j) + getSouthWest(matrix,i,j) + getSouthEast(matrix,i,j) +
                        getSouth(matrix,i,j);
            }
        }else if(i == matrix.length-1){
            if(j==0) {
                return getNorth(matrix,i,j) + getEast(matrix,i,j) + getNorthEast(matrix,i,j);
            }else if(j==matrix[0].length-1){
                return getWest(matrix,i,j) + getNorth(matrix,i,j) + getNorthWest(matrix,i,j);
            }else{
                return getNorthWest(matrix,i,j) + getWest(matrix,i,j) + getEast(matrix,i,j) + getNorthEast(matrix,i,j) +
                        getNorth(matrix,i,j);
            }
        }else{
            if(j == 0){
                return getNorth(matrix,i,j) + getNorthEast(matrix,i,j) + getEast(matrix,i,j) + getSouth(matrix,i,j) +
                        getSouthEast(matrix,i,j);
            }else if(j == matrix[0].length-1){
                return getNorth(matrix,i,j) + getNorthWest(matrix,i,j) + getWest(matrix,i,j) +
                        getSouth(matrix,i,j) + getSouthWest(matrix,i,j);
            }else {
                return getSouthWest(matrix, i, j) + getSouth(matrix, i, j) + getSouthEast(matrix, i, j) +
                        + getNorth(matrix, i, j) + getNorthEast(matrix, i, j) + getNorthWest(matrix, i, j) +
                        getEast(matrix, i, j) +  + getWest(matrix, i, j);
            }
        }
    }

    int getCurrent(boolean[][] matrix, int i, int j){
        return (matrix[i][j])?1:0;
    }
    int getWest(boolean[][] matrix, int i, int j){
        return (matrix[i][j-1])?1:0;
    }
    int getNorthWest(boolean[][] matrix, int i, int j){
        return (matrix[i-1][j-1])?1:0;
    }
    int getSouthWest(boolean[][] matrix, int i, int j){
        return (matrix[i+1][j-1])?1:0;
    }
    int getEast(boolean[][] matrix, int i, int j){
        return (matrix[i][j+1])?1:0;
    }
    int getNorthEast(boolean[][] matrix, int i, int j){
        return (matrix[i-1][j+1])?1:0;
    }
    int getSouthEast(boolean[][] matrix, int i, int j){
        return (matrix[i+1][j+1])?1:0;
    }
    int getNorth(boolean[][] matrix, int i, int j){
        return (matrix[i-1][j])?1:0;
    }
    int getSouth(boolean[][] matrix, int i, int j){
        return (matrix[i+1][j])?1:0;
    }



    public static void main(String[] args) {
        IslandOfKnowledge test = new IslandOfKnowledge();
//        test.areEquallyStrong(10,15,15,9);
        int inputArray[] = {2, 3};
//        test.arrayMaximalAdjacentDifference(inputArray);
//        test.isIPv4Address("01.254.255.0");
        test.avoidObstacles(inputArray);

        int image[][] = {{7, 4, 0, 1},{5, 6, 2, 2},{6, 10, 7, 8},{1, 4, 2, 0}};
        test.boxBlur(image);

        boolean[][] matrix = {{true,false,false,true},{false,false,true,false},{true,true,false,true}};
        test.minesweeper(matrix);

    }

}
