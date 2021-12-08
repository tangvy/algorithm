package com.tangv.sorts;

import com.tangv.model.entity.BaseTestEntity;
import org.junit.Test;

/**
 * @author: tangwei
 * @Date: 2021/12/8 14:35
 * @Description: 冒泡排序
 * 依次比较前面数和后面数的大小，把大的放后面；最终最大的数会放在最后；最后一个数不需要动了
 * 前面的数再次重复以上操作，不停的把大数放在最右边
 */
public class BubbleSort extends BaseTestEntity {

    @Test
    public void sort() {
        print(sortAsc(arr));
        print(sortDesc(arr));
    }

    public int[] sortAsc(int[] arr) {
        int len = arr.length;
        for (int i = 0;i < len - 1;i++) {
            for (int j = 0;j < len - i - 1;j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    public int[] sortDesc(int[] arr) {
        int len = arr.length;
        for (int i = 0;i < len - 1;i++) {
            for (int j = 0;j < len - i - 1;j++) {
                if (arr[j] < arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

}