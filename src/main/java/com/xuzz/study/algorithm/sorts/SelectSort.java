package com.xuzz.study.algorithm.sorts;

/**
 * Created by win10 on 2017/5/12.
 */
public class SelectSort extends SortBase {

    @Override
    protected void doSort() {
        /**
         * 选择排序（已知位置元素）
         */


        int i=0;
        while(i<toSortArray.length)
        {
            int min = toSortArray[i];
            int position=i;
            for(int j=i+1;j<toSortArray.length;j++)
            {
                if(toSortArray[j]<min)
                {
                    min=toSortArray[j];
                    position=j;
                }
            }
            toSortArray[position]=toSortArray[i];
            toSortArray[i]=min;
            i++;
        }
    }
}
