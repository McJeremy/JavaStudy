package com.xuzz.study.algorithm.sorts;

/**
 * Created by win10 on 2017/5/12.
 */
public class QuickSort extends SortBase {
    /**
     * 快速排序
     */

    @Override
    protected void doSort() {
        sort(toSortArray,0,toSortArray.length-1);
    }

    private static void sort(int[] arr, int low, int height)
    {
        int tmpLow=low,tmpHeight=height;
        if(low<height)
        {
            int key = arr[low];
            while(low<height)
            {
                //从右边开始找小于基准的数，直到找到位置
                while(low<height && arr[height]>=key)
                {
                 //   arr[height--]=key;
                    height--;
                }
                arr[low]=arr[height];

                //从左边找大于基准的数，直到找到为止
                while(low<height && arr[low]<=key)
                {
                    low++;
                }
                arr[height]=arr[low];
            }
            arr[low]=key;

            //经过这轮后，low左边的都是小于基准的数，右边都是大于基准的数
            sort(arr,tmpLow,low-1);
            sort(arr,low+1,tmpHeight);
        }


    }
}
