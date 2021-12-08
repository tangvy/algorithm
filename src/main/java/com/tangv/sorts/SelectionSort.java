package com.tangv.sorts;

import com.tangv.model.entity.BaseTestEntity;
import org.junit.Test;

/**
 * @author: tangwei
 * @Date: 2021/12/8 11:11
 * @Description: 选择排序
 */
public class SelectionSort extends BaseTestEntity {

    @Test
    public void sort() {
        //int[] arr = {10,43,2,434,56,76,5464,675,2,23,2344,43,56};
        sortAsc(arr);
        print(arr);
        sortDesc(arr);
        print(arr);

        /*int a = 20;
        int b = 8;
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a = " + a + ", b = " + b);*/
        int a = 20;
        int b = 8;
        swap(0, 1);
        print(arr);
        tempSwap(0,1);
        print(arr);
    }

    /**
     * 升序
     */
    private int[] sortAsc(int[] arr) {
        int len = arr.length;
        for (int i = 0;i < len - 1;i++) {
            //最小值
            int min = arr[i];
            //最小值的index
            int index = i;
            for (int j = i + 1;j < len;j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            arr[index] = arr[i];
            arr[i] = min;
        }
        return arr;
    }

    /**
     * 降序
     */
    public int[] sortDesc(int[] arr) {
        int len = arr.length;
        for (int i = 0;i < len - 1;i++) {
            int max = arr[i];
            int index = i;
            for (int j = i + 1;j < len;j++) {
                if (arr[j] > max) {
                    max = arr[j];
                    index = j;
                }
            }
            arr[index] = arr[i];
            arr[i] = max;
        }
        return arr;
    }


}