package example;

/**
 * 工具类
 * @author yanmiaomiao
 * 2018/6/14
 *
 */
public final class Util {
     
    /**
     * 字符数组排序的快速排序算法
     * @param a
     * @param left
     * @param right
     */
    public synchronized static void charQuickSort(char a[], int left, int right)
    {
    	int l, r;
        char temp;
        if (left < right)
        {
            l = left;
            r = right;
            temp = a[l]; 
            while (l < r)
            {
                while (a[r] > temp && l < r)
                {
                    r--;
                }
                if (l < r)
                {
                    a[l] = a[r];
                    l++;
                }
                while (a[l]<temp && l < r)
                {
                    l++;
                }
                if (l < r)
                {
                    a[r] = a[l];
                    r--;
                }
            }
            a[l] = temp;
            charQuickSort(a, left, l - 1);
            charQuickSort(a, l + 1, right);
        }
    }
}
