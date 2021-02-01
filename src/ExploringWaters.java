import java.nio.file.LinkPermission;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ExploringWaters {

    String[] addBorder(String[] picture) {
        int rowSize = picture.length;
        int colSize = picture[0].length();

        String result[] = new String[rowSize+2];
        Arrays.fill(result,"");

        for(int i = 0; i < rowSize+2; i++){
            for(int j=0; j<colSize+2; j++){
                if(i==0 || i==rowSize+1){
                    result[i] = result[i].concat("*");
                }else {
                    if(j==0 || j==colSize+1)
                        result[i] = result[i].concat("*");
                    else
                        result[i] = result[i].concat(String.valueOf(picture[i-1].charAt(j-1)));
                }
            }
        }

        return result;
    }

    boolean areSimilar(int[] a, int[] b) {
        int missimilarity = 0;
        int swap = 0;
        int matchFound = -1;

        if(a.length != b.length)
            return false;

        for(int i = 0; i < a.length; i++){
            if((a[i] != b[i]) && (i != matchFound)){
                missimilarity++;
                for(int j = 0; j < a.length; j++){
                    if(a[i] == b[j] && b[i] == a[j]){
                        swap++;
                        matchFound = j;
                        break;
                    }
                }
                if(swap == 0){
                    return false;
                }
            }
        }
        if(missimilarity > 1)
            return false;

        return true;
    }

    int arrayChange(int[] inputArray) {
        int numOfMoves = 0;
        for (int i = 0; i < inputArray.length-1; i++){
            int temp = 0;
            if(!(inputArray[i] < inputArray[i+1])){
                temp = inputArray[i] + 1 - inputArray[i+1];
                inputArray[i+1] += temp;
                numOfMoves += temp;
            }
        }
        return numOfMoves;
    }

    boolean palindromeRearranging(String inputString) {
        int oddElements = 0;
        List<Character> charInputArr = inputString.chars().mapToObj(e -> (char)e).collect(Collectors.toList());
        List<Character> distinctChar = charInputArr.stream().distinct().collect(Collectors.toList());
        for(char c: distinctChar){
            if(charInputArr.stream().filter(character -> character.equals(c)).count() % 2 != 0){
                oddElements++;
            }
        }
        if(oddElements > 1){
            return false;
        }
        return true;
    }



    public static void main(String[] args) {

        ExploringWaters test = new ExploringWaters();

        String[] picture = {"abc", "ded"};
        test.addBorder(picture);

        int a[] = {832, 998, 148, 570, 533, 561, 894, 147, 455, 279}; //
        int b[] = {832, 570, 148, 998, 533, 561, 455, 147, 894, 279}; // //{1, 2, 3};
        test.areSimilar(a,b);

        int inputArray[] = {-1000, 0, -2, 0};
        test.arrayChange(inputArray);

        System.out.println(test.palindromeRearranging("abbcabb"));
    }
}
