

public class oneDimensionalArray {

    public static void printArray(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

    public static int[] removeEven(int[] arr){
        int oddCount = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 != 0)
                oddCount++;
        }
        int[] result = new int[oddCount];
        int index = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 != 0){
                result[index] = arr[i];
                index++;
            }
        }
        return result;

    }


    public static int[] reverseArray(int arr[], int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }


    public static int findMinimun(int[] arr){
        int min = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    public static int findMaximun(int [] arr){
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max)
            max = arr[i];
        }
        return max;
    }

    public static int findSecondMax(int[] arr){
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                secondMax = max;
                max = arr[i];
            }
            else if(arr[i] > secondMax && arr[i] != max){
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    public static void moveZeros(int [] arr, int n){
        int j = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] != 0 && arr[j] == 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if(arr[j] != 0)
                j++;
        }
    }

    public static void arrayDemo(){
        int[] arr = {1,3,6,8,2,4,7};
        System.out.println(findMissingNumber(arr));
        
    }

    public int[] resizeArray(int[] arr, int capacity){
        int[] temp = new int [capacity];
        for(int i = 0; i < arr.length; i++)
            temp[i] = arr[i];
        arr = temp;
        return arr;
    }

    public static int findMissingNumber(int[] arr){
        int n = arr.length+1;
        int sum = (n * (n + 1)) / 2;
        for(int num : arr){
            sum = sum - num;
        }
        return sum;
    }

    public boolean isPalindrome(String word){
        char[] charArray = word.toCharArray();
        int start = 0;
        int end = word.length()-1;
        while(start < end){
            if(charArray[start] != charArray[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }





    public static void main(String[] args) {
        // oneDimensionalArray array = new oneDimensionalArray();
        // int[] arr = {3,2,0,4,7,10,6,0,5};
        // int[] original = new int[] {5,1,2,9,10};
        // printArray(arr);
        // int[] result = removeEven(arr);
        // printArray(result);
        // int[] reverse = reverseArray(arr,0,arr.length-1);
        // printArray(reverse);
        // System.out.println(findMinimun(arr)); 
        // System.out.println(findMaximun(arr));
        // System.out.println(findSecondMax(arr));
        arrayDemo();
        // original = array.resizeArray(original, 20);
        // System.out.println("The size of original array after rezise: " + original.length);

        oneDimensionalArray string = new oneDimensionalArray();
        if(string.isPalindrome("malayalam")){
            System.out.println("The string is palindrome");
        }
        else{
            System.out.println("The string is not a palindrome");
        }
        
        
    }


}