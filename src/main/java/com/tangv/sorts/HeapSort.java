package com.tangv.sorts;

import com.tangv.model.entity.BaseTestEntity;
import org.junit.Test;

/**
 * @author: tangwei
 * @Date: 2021/12/20 19:46
 * @Description: 堆排序
 */
public class HeapSort extends BaseTestEntity {

    @Test
    public void sort() {
        heapSortAsc(arr);
        print(arr);
    }

    public void heapSortAsc(int[] arr) {
        int len = arr.length;
        if (arr == null || len < 2) {
            return;
        }
        for (int i = 0;i < len;i++) {
            //每个元素做堆化，最后得到一个大顶堆
            heapInsert(arr, i);
        }
        //将大顶堆的第一个数和最后一个数交换位置，即最大的数被换到最后，--len之后堆最后一位被抹去
        doSwap(arr, 0, --len);
        //现在数组又不是堆了，需要再次堆化
        while (len > 0) {
            heapify(arr, 0, len);
            doSwap(arr, 0, --len);
        }

    }

    /**
     * 自下往上，和父节点比较大小，如果比父节点大就上浮，否则跳出循环
     */
    private void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1)/2]) {
            doSwap(arr, index, (index - 1)/2);
            index = (index - 1)/2;
        }
    }

    /**
     * 自上而下，和最大子节点比较，如果比最大子节点还要大，则下沉，否则跳出循环
     */
    private void heapify(int[] arr, int index, int len) {
        int left = 2 * index + 1;
        while (left < len) {
            //如果存在右节点并且右节点大于左节点，那么选取右节点为最大节点；否则选取左节点为最大节点
            int largest = (left + 1) < len && arr[left + 1] > arr[left] ? (left + 1) : left;
            //如果上一步的最大节点比index节点大，则该节点是最终最大节点；否则index节点是最大节点
            largest = arr[largest] > arr[index] ? largest : index;
            //如果当前节点就是最大节点退出循环
            if (largest == index) {
                break;
            }
            //如果有一个子节点是最大节点，则index节点下沉
            doSwap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private void doSwap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}