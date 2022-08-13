package com.yjzs.gold.nouse;

public class WSo {

    /**
     * 快速排序
     * 要排序的数组和左下标和右下标
     * @param arr
     * @param left
     * @param right
     */
    public static void mysort(int[] arr, int left, int right) {
        // 左下标比右下标还大就不可能
        if(left > right) {
            return;
        }
        int i = left;
        int j = right;
        // 记录中心轴的值，这里记录左下标对应的值key。
        int key = arr[left];
        // 临时存放
        int temp;
        while(i < j) {
            while(arr[j] >= key && i < j) {
                j--;
            }
            while(arr[i] <= key && i < j) {
                i++;
            }
            if(i < j) {
                temp = arr[i];
                arr[i] = arr[j];
                // 这里只是交换下位置
                arr[j] = temp;
            }
        }
        // 此时的arr[i]是一次循环的中轴，但是在循环中变为了中轴值了。
        arr[left] = arr[i];
        // 将原本的中轴值放到对应的地方。这个arr左右就是俩个子序列。
        arr[i] = key;
        mysort(arr, i + 1, right);
        mysort(arr, left, i - 1);
    }


    public static void main(String[] args) {
       /* int[] test_arr = new int[50];
        for(int i = 0; i < test_arr.length; i++) {
            //取随机数0-100给数组赋值
            test_arr[i] = (int)(Math.random() * 100);
        }
        System.out.println("排序前");
        //排序前数组输出
        for(int i: test_arr) {
            System.out.print(i + " ");
        }
        //换行
        System.out.println();
        System.out.println("排序后");
        mysort(test_arr, 0, test_arr.length - 1);
        //排序后数组输出
        for(int i: test_arr) {
            System.out.print(i + " ");
        }*/


        int [] arr = {1,3,5,2,6,4,32};
        WSo.mysort(arr,0,arr.length-1);
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j]+" ");
        }
    }
}
