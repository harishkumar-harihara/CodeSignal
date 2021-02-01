import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import static java.util.Arrays.stream;

public class RainsOfReason {

    int[] arrayReplace(int[] inputArray, int elemToReplace, int substitutionElem) {
        return Arrays.stream(inputArray).map(i -> (i==elemToReplace)?substitutionElem:i).toArray();
    }

    boolean evenDigitsOnly(int n) {
        return Integer.toString(n).chars().map(i -> i % 2).reduce((left, right) -> left + right).getAsInt() <= 0;
    }

    boolean variableName(String name) {
        String regex1 = "[a-zA-Z_]";
        String regex2 = "[a-zA-Z_0-9]*";
        if(Pattern.matches(regex1,Character.toString(name.charAt(0)))){
            if(name.length() > 1) {
                if(Pattern.matches(regex2, name.substring(1, name.length() - 1))) {
                    return true;
                }
            }
        }
        return false;
    }

    String alphabeticShift(String inputString) {
        String shifted = "";

        for(int i = 0; i < inputString.length(); i++){
            int ascii = (int)(inputString.charAt(i)+1);
            if(!(ascii >= 97 && ascii <= 122)){
                ascii = ascii - 123 + 97;
            }
            shifted = shifted.concat(Character.toString(ascii));
            // efficient way, just to handle A-Z boundary conditons, above way is chosen
//            System.out.println(String.valueOf( (char) (inputString.charAt(i) + 1)));
        }
        return shifted;
    }

    boolean chessBoardCellColor(String cell1, String cell2) {
        int cell1X = (int) cell1.charAt(0) - 64;
        int cell2X = (int) cell2.charAt(0) - 64;
        int cell1Y = Integer.parseInt(Character.toString(cell1.charAt(1)));
        int cell2Y = Integer.parseInt(Character.toString(cell2.charAt(1)));

        if((cell1X%2==0 && cell2X%2==0) || ((cell1X%2!=0 && cell2X%2!=0))){
            if((cell1Y%2==0 && cell2Y%2==0) ||(cell1Y%2!=0 && cell2Y%2!=0)){
                return true;
            }
        }
        else if((cell1X%2!=0 && cell2X%2==0) || (cell1X%2==0 && cell2X%2!=0)){
            if((cell1Y%2==0 && cell2Y%2!=0) || (cell1Y%2!=0 && cell2Y%2==0)){
                return true;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        RainsOfReason test = new RainsOfReason();
        int[] inputArray = {1, 2, 1};
        int[] out = test.arrayReplace(inputArray,1,3);
        test.evenDigitsOnly(248622);
        test.variableName("var_1__Int");
        test.alphabeticShift("aaaabbbccd");
        System.out.println(test.chessBoardCellColor("A1","C3"));
    }

}
