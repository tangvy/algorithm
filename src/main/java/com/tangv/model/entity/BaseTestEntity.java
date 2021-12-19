package com.tangv.model.entity;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author: tangwei
 * @Date: 2021/6/26 10:36
 * @Description:
 */
@SpringBootTest
@WebAppConfiguration
//@RunWith(SpringRunner.class)
@Slf4j
public class BaseTestEntity {

    public int[] arr = {10,43,2,78,56,76,108,67,2,23,244,43,98};

    @Before
    public void init() {
        log.debug("=====开始测试=====");
    }

    public void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }

    public void swap(int a, int b) {
        arr[a] = arr[a]^arr[b];
        arr[b] = arr[a]^arr[b];
        arr[a] = arr[a]^arr[b];
    }

    public void tempSwap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}