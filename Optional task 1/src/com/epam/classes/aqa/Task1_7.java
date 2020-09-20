package com.epam.classes.aqa;

import java.util.*;

public class Task1_7 {

    public static void solveTask1() {
        //1.     Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.

        System.out.print("Please enter desired number of values: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Please enter number: ");
            Scanner scanner2 = new Scanner(System.in);
            arr[i] = scanner.nextInt();
        }

        int shortest = arr[0];
        int indexOfShort = 0;

        int longest = arr[0];
        int indexOfLong = 0;

        for (int i = 0; i < arr.length; i++) {

            if (findLengthOfNumber(arr[i]) <= findLengthOfNumber(arr[indexOfShort])) {
                shortest = arr[i];
                indexOfShort = i;
            }
        }

        for (int i = 0; i < arr.length; i++) {

            if (findLengthOfNumber(arr[i]) >= findLengthOfNumber(arr[indexOfLong])) {
                longest = arr[i];
                indexOfLong = i;
            }
        }

        //System.out.println("Shortest: " + shortest + " length of short: " + findLength(indexOfShort, arr) + " longest: " + longest + " length of long: " + findLength(indexOfLong, arr));

        //2.     Вывести числа в порядке возрастания (убывания) значений их длины.

        int[] sortedArray = sortArray(arr);
        //printArray(sortedArray);
        // 3.     Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.

        ArrayList lessThatMedium = new ArrayList();
        lessThatMedium = findLessThanMedium(arr);
        //printList(lessThatMedium);
        //System.out.println(findMediumLength(arr));

        //4.     Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.
        int indexOfMinDif = 0;
        int minDifNumber = 0;
        for (int i = 0; i < arr.length; i++) {
            if (findMinDiffNum(arr[i]) < findMinDiffNum(arr[indexOfMinDif])) {
                indexOfMinDif = i;
                minDifNumber = arr[i];
            }
        }
        //System.out.println(minDifNumber);

        //5.     Найти количество чисел, содержащих только четные цифры, а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.
        int numberOfEven = 0;
        int counter = 0;
        ArrayList<Integer> newList = new ArrayList();


        for (int i = 0; i < arr.length; i++) {
            if (findOnlyEven(arr[i]) == true) {
                counter++;
            } else newList.add(arr[i]);
        }

        ArrayList<Integer> evenEqualToOdd = new ArrayList<>();

        for (int i = 0; i < newList.size(); i++) {
            if (findIfOddEqualToOdd(newList.get(i))) {
                evenEqualToOdd.add(newList.get(i));
            }
        }

        //printList(evenEqualToOdd);

        //6.     Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.

        ArrayList<Integer> listAscending = new ArrayList();

        for (int i = 0; i < arr.length; i++) {
            if(findIfAscending(arr[i])) {
                listAscending.add(arr[i]);
                break;
            }
        }

        //printList(listAscending);

       // 7.     Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.

        ArrayList<Integer> listContainsOnlyDifferents = new ArrayList();

        for (int i = 0; i < arr.length; i++) {
            if(findOnlyDiff(arr[i])) {
                listContainsOnlyDifferents.add(arr[i]);
                break;
            }
        }

        printList(listContainsOnlyDifferents);

    }

    public static int findLengthOfNumber(int x) {
        return String.valueOf(Math.abs(x)).length();
    }

    public static String createStringFromNumber(int x) {
        return String.valueOf(Math.abs(x));
    }

    public static int[] sortArray(int[] arr) {


        for (int i = 0; i < arr.length; i++) {

            int min = arr[i];
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++)
                if (findLengthOfNumber(arr[j]) < findLengthOfNumber(arr[minIndex])) {

                    min = arr[j];
                    minIndex = j;
                }

            if (i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void printList(ArrayList arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }

    public static double findMediumLength(int[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + findLengthOfNumber(arr[i]);
        }
        return sum / arr.length;
    }

    public static ArrayList findLessThanMedium(int[] arr) {
        ArrayList newList = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            if (findLengthOfNumber(arr[i]) < findMediumLength(arr)) {
                newList.add(arr[i]);
            }
        }
        return newList;
    }

    public static int findMinDiffNum(int x) {
        HashSet<Character> newSet = new HashSet<>();
        int length = findLengthOfNumber(x);
        String numberToString = createStringFromNumber(x);

        for (int i = 0; i < length; i++) {
            newSet.add(numberToString.charAt(i));
        }
        return newSet.size();
    }

    public static boolean findOnlyEven(int x) {
        String stringToNumber = createStringFromNumber(x);
        int length = findLengthOfNumber(x);

        for (int i = 0; i < length; i++) {
            if (stringToNumber.charAt(i) % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    public static int findNumberOfEven(int x) {
        String stringToNumber = createStringFromNumber(x);
        int length = findLengthOfNumber(x);
        int counter = 0;

        for (int i = 0; i < length; i++) {
            if (stringToNumber.charAt(i) % 2 == 0) {
                counter++;
            }
        }
        return counter;
    }

    public static int findNumberOfOdd(int x) {
        String stringToNumber = createStringFromNumber(x);
        int length = findLengthOfNumber(x);
        int counter = 0;

        for (int i = 0; i < length; i++) {
            if (stringToNumber.charAt(i) % 2 != 0) {
                counter++;
            }
        }
        return counter;
    }

    public static boolean findIfOddEqualToOdd(int x) {

        if (findNumberOfEven(x) == findNumberOfOdd(x)) {
            return true;
        }
        return false;

    }

    public static List<Integer> getDigits(int x) {
        List<Integer> newList = new ArrayList<>();
        x = Math.abs(x);
        do {
            int digit = x % 10;
            x = x / 10;
            newList.add(digit);
        } while (x != 0);
        return newList;
    }

    public static boolean findIfAscending(int x) {
       var newList = getDigits(x);

       for (int i = 1; i < newList.size(); i++) {
           if(newList.get(i - 1) <= newList.get(i)) {
               return false; // 3 2 1
           }
       }
       return true;
    }

    public static boolean findOnlyDiff(int x) {
        List<Integer> newList = getDigits(x);
        x = Math.abs(x);
        int length = findLengthOfNumber(x);
        HashSet<Integer> newSet = new HashSet<>();

        for (int i = 0; i < length; i++) {
           newSet.add(newList.get(i));
        }

        if (newSet.size() == newList.size()){
            return true;
        }
        return false;
    }
}
