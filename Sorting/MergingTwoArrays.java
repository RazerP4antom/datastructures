public class MergingTwoArrays {

    public void printArray(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public int[] merge(int[] arr1, int[] arr2, int n, int m){
        int[] result = new int[n + m];
        int i = 0, j = 0, k = 0;

        while(i < n && j < m){

            if(arr1[i] < arr2[j]){
             result[k] = arr1[i]; 
             i++;
            }
            else{
                result[k] = arr2[j];
                j++;
            }
            k++;           
        }

        while(i < n){
            result[k] = arr1[i];
            i++;k++;
        }

        while(j < m){
            result[k] = arr2[j];
            j++;k++;
        }

        return result;
    }



    public static void main(String[] args) {
        int[] arr1 = new int[] {2,5,7};
        int[] arr2 = new int[] {3,4,9};

        MergingTwoArrays mta = new MergingTwoArrays();
        mta.printArray(arr1);
        mta.printArray(arr2);
        mta.printArray(mta.merge(arr1, arr2, arr1.length, arr2.length));
    }
    
}
