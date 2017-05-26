package com.xuzz.study.algorithm.sorts;

/**
 * Created by win10 on 2017/5/12.
 */
public class InsertSort extends SortBase {

    /**
     * 直接插入排序(已知元素从已排序片段中找位置)
     */
    @Override
    protected void doSort() {
        for(int i=1;i<toSortArray.length;i++)
        {
            int j=i-1;
            int tmp = toSortArray[i];
            for(;j>=0&&tmp<toSortArray[j];j--)
            {
                toSortArray[j+1]=toSortArray[j];
            }
            toSortArray[j+1]=tmp;
        }
    }
}
