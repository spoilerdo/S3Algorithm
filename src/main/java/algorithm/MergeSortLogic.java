package algorithm;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

//Source code inspired by: https://en.wikipedia.org/wiki/Merge_sort
public class MergeSortLogic {
    //Top-Down merge sort algorithm which recursively divides the input list into smaller sublists until the sublists
    //are trivially sorted, and then merges the sublists while return up the call chain.
    public List<Offer> TopDownMergeSort(List<Offer> offers, String compareMethodName, String getMethodName){
        //Base case. A list of zero or one elements is sorted, by definition.
        if(offers.size() <= 1){
            return offers;
        }

        //Recursive case. First, divide the list into equal-sized sublists
        //consisting of the first half and second half of the list.
        //This assumes lists start at index 0.
        List<Offer> left = new ArrayList<>();
        List<Offer> right = new ArrayList<>();
        for (int i = 0; i < offers.size(); i++){
            if(i < offers.size()/2){
                left.add(offers.get(i));
            }else{
                right.add(offers.get(i));
            }
        }

        //Recursively sort both sublists.
        left = TopDownMergeSort(left, compareMethodName, getMethodName);
        right = TopDownMergeSort(right, compareMethodName, getMethodName);

        //Then merge the now-sorted sublists.
        return Merge(left, right, compareMethodName, getMethodName);
    }

    private List<Offer>Merge(List<Offer> left, List<Offer> right, String compareMethodName, String getMethodName){
        List<Offer> results = new ArrayList<>();

        while(left.size() != 0 && right.size() != 0){

            try{
                Method leftMethod = left.get(0).getClass().getMethod(compareMethodName, String.class, String.class);
                Method leftValueMethod = left.get(0).getClass().getMethod(getMethodName);
                Method rightValueMethod = right.get(0).getClass().getMethod(getMethodName);
                String leftValue = String.valueOf(leftValueMethod.invoke(left.get(0)));
                String rightValue = String.valueOf(rightValueMethod.invoke(right.get(0)));
                if((boolean)leftMethod.invoke(left.get(0), new Object[]{leftValue, rightValue})){
                    results.add(left.get(0));
                    left.remove(0);
                }else{
                    results.add(right.get(0));
                    right.remove(0);
                }
            }catch (Exception e){System.out.println(e.getMessage());}
        }

        //Either left or right may have elements left; consume them.
        //(Only one of the following loops will actually be entered.)
        if(left.size() != 0){
            results.addAll(left);
            left.clear();
        }else{
            results.addAll(right);
            right.clear();
        }

        return results;
    }

    //Bottom-up merge sort algorithm which uses a small fixed size array of references to nodes, where array[i] is
    //either a reference to a list of size 2^i or 0.
    //Node is a reference or pointer to a node.
    //The merge() function would be similar to the one shown in the top-down merge.
    public List<Offer>BottomUpMergeSort(List<Offer> head){
        //return if empty list
        if(head == null){
            return null;
        }
        //TODO: finish this one
        return null;
    }
}
