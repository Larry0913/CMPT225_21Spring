package com.company;

public class SortSystem {
    private int merge_times;
    private int quick_times;


    public SortSystem() {
        merge_times = 0;
        quick_times = 0;
    }

    public int getMerge_times(){
        return merge_times;
    }

    public int getQuick_times(){
        return quick_times;
    }

    public void mergeSort(int arr[]) {
        merge_times = 0;
        mergeSort(arr, 0, arr.length - 1);
    }

    public void mergeSort(int arr[], int start, int end) {
        if (start < end) {
            int mid = start + (end - start)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private void merge(int arr[], int start, int mid, int end) {
        int startLength = mid - start + 1;
        int endLength = end - mid;
        int s[] = new int[startLength];
        int e[] = new int[endLength];
        for (int i = 0; i < startLength; ++i) {
            s[i] = arr[start + i];
        }
        for (int i = 0; i < endLength; ++i) {
            e[i] = arr[mid + 1 + i];
        }
        int i = 0;
        int j = 0;
        int k = start;
        while (i < startLength && j < endLength) {
            merge_times ++;
            if (s[i] <= e[j]) {
                arr[k] = s[i];
                i++;
            }
            else {
                arr[k] = e[j];
                j++;
            }
            k++;
        }
        while (i < startLength) {
            arr[k] = s[i];
            i++;
            k++;
        }
        while (j < endLength) {
            arr[k] = e[j];
            j++;
            k++;
        }
    }

    public void quickSort(int arr[]) {
        quick_times = 0;
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int arr[], int smaller, int greater) {
        if (smaller < greater) {
            int pIndex = partition(arr, smaller, greater);
            quickSort(arr, smaller, pIndex - 1);
            quickSort(arr, pIndex + 1, greater);
        }
    }

    private int partition(int[] arr, int smaller, int greater) {
        int pivot = arr[greater];
        int index = smaller - 1;
        for (int j = smaller; j <= greater; j++) {
            if (arr[j] < pivot) {
                index++;
                swap(arr, index, j);
            }
            quick_times++;
        }
        swap(arr, index + 1, greater);
        return index + 1;
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}

