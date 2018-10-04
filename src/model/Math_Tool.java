/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wei Wang
 */
public class Math_Tool {

//    public static void main(String[] args) {
//        List<Float> list = new ArrayList();
//        for (int i = 1; i <= 99; i++) {
//            list.add(i + 0.0f);
//        }
//
//        System.out.println(findMedian(list));
//
//    }

    public static float findMedian(List<Float> list) {
        if (list == null || list.size() == 0) {
            return -1.0f;
        }

        if (list.size() % 2 == 1) {
            return partition(list, 0, list.size() - 1, list.size() / 2);
        } else {
            return (partition(list, 0, list.size() - 1, (list.size() - 1) / 2)
                    + partition(list, 0, list.size() - 1, list.size() / 2)) / 2;
        }

    }

    private static float partition(List<Float> list, int s, int e, int k) {
        if (s >= e) {
            return list.get(k);
        }
        int l = s, r = e;
        float pivot = list.get((l + r) / 2);

        while (l <= r) {
            while (l <= r && list.get(l) < pivot) {
                l++;
            }
            while (l <= r && list.get(r) > pivot) {
                r--;
            }
            if (l <= r) {
                float tmp = list.get(l);
                list.set(l, list.get(r));
                list.set(r, tmp);
                l++;
                r--;
            }

        }
        if (k <= r) {
            return partition(list, s, r, k);
        }
        if (k >= l) {
            return partition(list, l, e, k);
        }
        return list.get(k);
    }
}
