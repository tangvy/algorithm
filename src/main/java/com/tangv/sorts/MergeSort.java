package com.tangv.sorts;

import com.tangv.model.entity.BaseTestEntity;
import org.junit.Test;

/**
 * @author: tangwei
 * @Date: 2021/12/10 17:06
 * @Description: 归并排序
 */
public class MergeSort extends BaseTestEntity {

    @Test
    public void sort() {
        print(sortAsc(arr));
        print(sortDesc(arr));
    }

    public int[] sortAsc(int[] arr) {
        int len = arr.length;
        int[] temp = new int[len];
        //将数组作拆分动作
        dividedAsc(arr, 0, len - 1, temp);
        return arr;
    }

    public void dividedAsc(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int middle = (right + left) >> 1;
            dividedAsc(arr, left, middle, temp);
            dividedAsc(arr, middle + 1, right, temp);
            mergeAsc(arr,left, middle, right, temp);
        }
    }

    public void mergeAsc(int[] arr, int left, int middle, int right, int[] temp) {
        //左指针
        int i = left;
        //右指针
        int j = middle + 1;
        //临时存储数据的指针
        int t = 0;
        //当左右两部分数据的指针都未越界时，比较指针所指对象的值，小的，放在临时数组；被选择的小的指针右移，知道左右有一部分移完了
        while (i <= middle && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        //仅左边剩余未比较
        while (i <= middle) {
            temp[t++] = arr[i++];
        }
        //仅右边剩余未比较
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

    public int[] sortDesc(int[] arr) {
        int len = arr.length;
        int[] temp = new int[len];
        dividedDesc(arr, 0, len - 1, temp);
        return arr;
    }

    public void dividedDesc(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int middle = (left + right) >> 1;
            dividedDesc(arr, 0, middle, temp);
            dividedDesc(arr, middle + 1, right, temp);
            mergeDesc(arr, left, middle, right, temp);
        }
    }

    public void mergeDesc(int[] arr, int left, int middle, int right, int[] temp) {
        //左指针
        int i = left;
        //右指针
        int j = middle + 1;
        //临时指针
        int t = 0;
        while (i <= middle && j <= right) {
            if (arr[i] >= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= middle) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

}