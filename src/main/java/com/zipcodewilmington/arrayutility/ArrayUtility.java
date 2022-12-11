package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.Arrays.copyOf;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    T[] genArr;

    public ArrayUtility(T[] genArr) {
        this.genArr = genArr;
    }

    public int countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate){
        return getNumberOfOccurrences(mergeArrays(arrayToMerge, genArr), valueToEvaluate);}

    public T getMostCommonFromMerge(T[] arrayToMerge){
        ArrayList<T> newArr = mergeArrays(genArr, arrayToMerge);
        int highestOcc = 0;
        T mostComElem = newArr.get(0);

        for (T element : newArr){
            if (getNumberOfOccurrences(newArr, element) > highestOcc){
                highestOcc = getNumberOfOccurrences(newArr, element);
                mostComElem = element;
            }
        }
        return mostComElem;}

    public int getNumberOfOccurrences(T valueToEvaluate){
        int counter = 0;
        for (T value : genArr){if (valueToEvaluate.equals(value)){counter++;}}
        return counter;}

    public int getNumberOfOccurrences(ArrayList<T> arrList, T valueToEvaluate){
        int counter = 0;
        for (T value : arrList){if (valueToEvaluate.equals(value)){counter++;}}
        return counter;}

    public T[] removeValue(T valueToRemove) {
        ArrayList<T> elemToKeep = new ArrayList<>();

        for (T element : genArr){if (!element.equals(valueToRemove)){elemToKeep.add(element);}}

        T[] result = Arrays.copyOf(genArr, elemToKeep.size());
        for (int i = 0; i < elemToKeep.size(); i++){
            result[i] = elemToKeep.get(i);
        }

        return result;}

    public ArrayList<T> mergeArrays(T[] arr1, T[] arr2) {
        ArrayList<T> mergedArr = new ArrayList<>();
        mergedArr.addAll(List.of(arr1));
        mergedArr.addAll(List.of(arr2));
        return mergedArr;
    }


}
