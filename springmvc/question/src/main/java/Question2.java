import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @version V1.0
 * @Project question
 * @Package PACKAGE_NAME
 * @Description:
 * @Date 2022/6/17 00:48
 */

public class Question2 {
    public static void result2(int n, List<Integer> list){
        List<Integer> collect = list.stream().sorted((Integer n1, Integer n2) -> n1 - n2).collect(Collectors.toList());
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addAll(collect);
        System.err.println(linkedList);
        System.err.println(collect.toString());
        List<Double> list1 = new ArrayList<>();
        double step = 2000 / (float)n;
        for (int i = 0; i < n; i++) {
            list1.add(step*(i+1));
        }
        List<String> result = new ArrayList<>();
         int left = 0;
         int right = n-1;
        result = getResult(collect, list1, left, right, result);
        System.err.println(result);
        System.err.println(list1);
    }
    public static boolean checkLeft(List<Integer> list1,List<Double> list2,int left){
        if (list1.get(left)<list2.get(left)){
            if (list1.get(left+1)>list2.get(left)){
                return true;
            }
        } else if (list1.get(left)>=list2.get(left)) {
            return true;
        }
        return false;
    }
    public static boolean checkRight(List<Integer> list1,List<Double> list2,int right){
        if (list1.get(right)>list2.get(right)){
            if (list1.get(right-1)<list2.get(right)){
                return true;
            }
        } else if (list1.get(right)<=list2.get(right)) {
            return true;
        }
        return false;
    }
    public static List<String> getResult(List<Integer> list1,List<Double> list2,int left,int right,List<String> result1){
        List<Integer> result = new ArrayList<>();
        while (left<=right){
            if (checkLeft(list1,list2,left)){
                result.add(++left);
                result1.add(result.toString());
            }
            if (checkRight(list1, list2, right)) {
                result.add(right+1);
                right--;
                result1.add(result.toString());
            }
        }

        return result1;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1000);
        list.add(600);
        list.add(700);
        list.add(50);
        result2(4,list);
    }
}
