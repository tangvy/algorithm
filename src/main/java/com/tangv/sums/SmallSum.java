package com.tangv.sums;

import com.tangv.model.entity.BaseTestEntity;
import org.junit.Test;

/**
 * @author: tangwei
 * @Date: 2021/12/18 15:40
 * @Description: 求小和
 * 小和问题
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组
 * 的小和。求一个数组 的小和。
 * 例子:[1,3,4,2,5] 1左边比1小的数，没有; 3左边比3小的数，1; 4左
 * 边比4小的数，1、3; 2左边比2小的数，1; 5左边比5小的数，1、3、4、
 * 2; 所以小和为1+1+3+1+1+3+4+2=16
 */
public class SmallSum extends BaseTestEntity {

    @Test
    public void sort() {
        System.out.println(sortAsc(arr));
        print(arr);
    }

    public int sortAsc(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int lenth = arr.length;
        return dividedAsc(arr, 0, lenth - 1);
    }

    public int dividedAsc(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int middle = left + ((right - left) >> 1);
        return dividedAsc(arr, 0, middle)
                + dividedAsc(arr, middle + 1, right)
                + merge(arr, left, middle, right);
    }

    public int merge(int[] arr, int left, int middle, int right) {
        int[] temp = new int[right - left + 1];
        int t = 0;
        //左指针
        int i = left;
        //右指针
        int j = middle + 1;
        int res = 0;
        while (i <= middle && j <= right) {
            if (arr[i] < arr[j]) {
                res += (right - j + 1) * arr[i];
                temp[t++] = arr[i++];
            } else {
                res += 0;
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
        return res;
    }
}