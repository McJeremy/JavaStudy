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

		//另外一种写法：
		for(int k=1;k<arr.length;k++)
        {
            if(arr[k]<arr[k-1])   //如果k>=k-1,那就不用排，直接进行下一个元素
            {
                int m = k-1;
                int x = arr[k];   //把需要排序的存起来
                while(m>=0 && x<arr[m])   //如果已排序的表中元素比x大,那么就挪位置
                {
                    arr[m+1]=arr[m];
                    m--;
                }
                arr[m+1]=x;
            }
        }
    }
}
