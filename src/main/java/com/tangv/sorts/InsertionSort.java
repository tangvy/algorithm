package com.tangv.sorts;

import com.tangv.model.entity.BaseTestEntity;
import org.junit.Test;

/**
 * @author: tangwei
 * @Date: 2021/12/8 19:35
 * @Description: 插入排序
 * 从第二个数开始，每次跟前面一个数比较大小，比前面小的话就和前面的数换个位置，一直比较到最左边，则当前位置往前都是有序的。
 * 然后第三个，第四个。。。也按这种方式比较
 */
public class InsertionSort extends BaseTestEntity {

    @Test
    public void sort() {
        print(sortAsc(arr));
        print(sortDesc(arr));
    }

    public int[] sortAsc(int[] arr) {
        int len = arr.length;
        for (int i = 0;i < len - 1;i++) {
            for (int j = i + 1;j > 0;j--) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        return arr;
    }

    public int[] sortDesc(int[] arr) {
        int len = arr.length;
        for (int i = 0;i < len - 1;i++) {
            for (int j = i + 1;j > 0;j--) {
                if (arr[j] > arr[j-1]) {
                    arr[j] = arr[j]^arr[j-1];
                    arr[j-1] = arr[j]^arr[j-1];
                    arr[j] = arr[j]^arr[j-1];
                }
            }
        }
        return arr;
    }

}