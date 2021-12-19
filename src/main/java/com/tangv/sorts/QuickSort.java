package com.tangv.sorts;

import com.tangv.model.entity.BaseTestEntity;
import org.junit.Test;

/**
 * author:   tangwei
 * Date:     2021/12/19 17:25
 * Description: 快速排序   2343 555 6789 5
 */
public class QuickSort extends BaseTestEntity {

    @Test
    public void sort() {
        quickSortAsc(arr, 0, (arr.length - 1));
        print(arr);
        quickSortDesc(arr, 0, (arr.length - 1));
        print(arr);
    }

    private void doSwap(int[] arrs, int left,int right) {
        int temp = arrs[left];
        arrs[left] = arrs[right];
        arrs[right] = temp;
    }

    public void quickSortAsc(int[] arr, int left, int right) {
        if (left < right) {
            //1.随机选一个数和最右边交换，作为比较标准
            doSwap(arr, (left + (int)(Math.random()*(right - left + 1))), right);
            //2.分区，小于标准的排在左边，等于标准的在中间，大于标准的在右边;把分界索引返回
            int[] p = partitionAsc(arr, left, right);
            //3.小于部分和大于部分再排序
            quickSortAsc(arr, left, p[0]);
            quickSortAsc(arr, p[1], right);
        }
    }

    private int[] partitionAsc(int[] arr, int left, int right) {
        //小于区域的指针
        int less = left - 1;
        //大于区域的指针
        int more = right;
        while (left < more) {
            if (arr[left] < arr[right]) {
                doSwap(arr, ++less, left++);
            } else if (arr[left] > arr[right]) {
                doSwap(arr, --more, left);
            } else {
                left++;
            }
        }
        doSwap(arr, more, right);
        return new int[]{less, more + 1};
    }

    public void quickSortDesc(int[] arr, int left, int right) {
        if (left < right) {
            //选一个随机数
            doSwap(arr, (left + (int)(Math.random()*(right - left + 1))), right);
            //分区
            int[] p = partitionDesc(arr, left, right);
            quickSortDesc(arr, left, p[0]);
            quickSortDesc(arr, p[1], right);
        }
    }

    private int[] partitionDesc(int[] arr, int left, int right) {
        int less = left - 1;
        int more = right;
        while (left < more) {
            if (arr[left] > arr[right]) {
                doSwap(arr, ++less, left++);
            } else if (arr[left] < arr[right]) {
                doSwap(arr, --more, left);
            } else {
                left++;
            }
        }
        doSwap(arr, more, right);
        return new int[]{less, more + 1};
    }

}