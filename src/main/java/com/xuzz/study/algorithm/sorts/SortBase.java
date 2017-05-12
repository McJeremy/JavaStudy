package com.xuzz.study.algorithm.sorts;

/**
 * Created by win10 on 2017/5/12.
 */
public abstract class SortBase {
    protected static int[] toSortArray=new int[]{49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};

    public void run()
    {
        System.out.println("未排序时：");
        for(int i=0;i<toSortArray.length;i++) {
            System.out.print(toSortArray[i]+" ");
        }
        doSort();
//        sort(toSortArray,0,toSortArray.length-1);
        System.out.println("排序后：");
        for(int i=0;i<toSortArray.length;i++) {
            System.out.print(toSortArray[i] +" ");
        }
    }

    protected abstract void doSort();
}
