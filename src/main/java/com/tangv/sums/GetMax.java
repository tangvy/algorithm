package com.tangv.sums;

import com.tangv.model.entity.BaseTestEntity;
import org.junit.Test;

/**
 * author:   tangwei
 * Date:     2021/12/19 15:48
 * Description: 求数组中最大值
 */
public class GetMax extends BaseTestEntity {

    @Test
    public void sort() {
        System.out.println(getMax());
    }


    private int getMax() {
        int len = arr.length;
        return process(arr, 0, len - 1);
    }

    private int process(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }
        int middle = left + ((right - left) >> 1);
        int p0 = process(arr, 0, left);
        int p1 = process(arr, left + 1, right);
        return p0 >= p1 ?p0 : p1;
    }
}