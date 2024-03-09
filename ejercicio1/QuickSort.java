package ejercicio1;
public class QuickSort {
    
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    //aqui se ponen los valores para la lista y el quicksprt y se ordena de menor a mayor
    public static void main(String[] args) {
        int[] arr = {47, 82, 11, 26, 6};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Listado ordenado:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}