import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivingDeeper {

    int[] extractEachKth(int[] inputArray, int k) {
        List<Integer> temp = new ArrayList<>();
        if(k > inputArray.length){
            return inputArray;
        }else{
            for(int i = 0; i < inputArray.length; i++){
                if((i+1)%k!=0)
                    temp.add(inputArray[i]);
            }
        }
        int[] result = new int[temp.size()];
        result = temp.stream().mapToInt(i->(int) i).toArray();
        return result;
    }

    public static void main(String[] args) {
        DivingDeeper test = new DivingDeeper();
        int[] inputArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        test.extractEachKth(inputArray,12);
    }
}
