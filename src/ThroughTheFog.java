import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ThroughTheFog {

    int circleOfNumbers(int n, int firstNumber) {
        int angleEachElement = 360/n;
        int oppositeElement = firstNumber + (180/angleEachElement);
        return (oppositeElement >= n) ? (oppositeElement-n):(oppositeElement);
    }

    int depositProfit(int deposit, int rate, int threshold) {
        float increaseFactor = (float) rate/100;
        float sum = deposit;
        int noOfYears = 0;
        while (sum < threshold){
            sum = sum + (increaseFactor*sum);
            noOfYears++;
        }
        return noOfYears;
    }

    int absoluteValuesSumMinimization(int[] a) {
        int minValue = Integer.MAX_VALUE;
        int minElement = 0;
        int temp = 0;

        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a.length; j++){
                temp += Math.abs(a[i]-a[j]);
            }
            if(temp < minValue){
                minValue = temp;
                minElement = a[i];
            }else if(temp == minValue){
                minElement = Math.min(minElement, a[i]);
            }
            temp = 0;
        }
        return minElement;
    }

    boolean stringsRearrangement(String[] inputArray) {

        List<String> inputList = Arrays.stream(inputArray).collect(Collectors.toList());

        Collections.sort(inputList);
        for(int i = 0; i < inputList.size()-1; i++){
            List<Character> c1 = inputList.get(i).chars().mapToObj(e->(char)e).collect(Collectors.toList());
                List<Character> c2 =  inputList.get(i+1).chars().mapToObj(e->(char)e).collect(Collectors.toList());
                for(int list_it = 0; list_it < c1.size(); list_it++){
                    for(int j = 0; j < c2.size(); j++){
                        if(c1.get(list_it) == c2.get(j)){
                            c2.remove(j);
                            j++;
                        }
                    }
                }
                if(c2.size()!=1)
                    return false;
        }
        return true;
    }

    public static void main(String[] args) {

        ThroughTheFog test = new ThroughTheFog();
        test.circleOfNumbers(6,3);
        test.depositProfit(20,20,50);
        int a[] = {2, 3};
        test.absoluteValuesSumMinimization(a);

        String[] inputArray = {"abc",
                "abx",
                "axx",
                "abx",
                "abc"};
        System.out.println(test.stringsRearrangement(inputArray));
    }
}
