package sort;

import java.util.Arrays;

public class Sort {
    public void test(){
        System.out.println("lw");
    }

    /**快速排序，升序
     * 思想：取一个基准值，从数组两边开始扫描比较;
     * 经过一趟排序，将序列以基准值分为有序;
     * 然后再分别对此区域进行同样的排序;
     * 直到没有可以拆分比较的为止,即两边扫描指示位相遇(相等)
     */
    public int oneSort(int[] arr,int beg,int end){
        //以arr[beg]位置为索引位
        int base=arr[beg];
        //进行扫描
        while (beg<end){
            //从后向前扫描,找到一个小于基准值的位置，让它覆盖基准值位置值
            //这里为大于等于，否则当等于时会陷入死循环
            while(arr[end]>=base && end>beg){
                --end;
            }
            arr[beg]=arr[end];
            //接下来从前向后扫描，找到一个大于基准值的位置，让它移到指示位end的地方。
            while(arr[beg]<=base && beg<end){
                ++beg;
            }
            arr[end]=arr[beg];
        }
        //将基准値放到beg或者end因为此时它们两相等
        arr[end]=base;
        return end;
    }
    public void quickSort(int[] arr, int beg, int end){
        //如果开始指示位大于等于结束指示位，则不做任何操作返回。
        if(beg>=end){
            return;
        }
        //传入arr,beg,end，这样beg、end以形参方式进入oneSort，并不会改变quickSort中的beg和end值
        int  basepos=oneSort(arr,beg,end);
        quickSort(arr,beg,basepos-1);
        quickSort(arr,basepos+1,end);
    }
    /**冒泡排序，升序
     * 从左往右扫描发现左边值大于右边值则交换，重复扫描，直到没有交换为止。
     * 至多n趟，因为每趟至少让一个数有序。
     */
    public void bubbleSort(int[] arr){
        boolean flag=true;
        int cal=0;
        //这里可以换成for至多n趟，这样就不用标记了
        while(flag){
            ++cal;
            flag=false;
            for (int i=1;i<arr.length;++i){
                if(arr[i-1]>arr[i]){
                    int tmp=arr[i];
                    arr[i]=arr[i-1];
                    arr[i-1]=tmp;
                    flag=true;
                }
            }
        }
        //System.out.println(cal);
    }
    /**
     * 插入排序,升序
     * 先将第一个元素看作有序的序列，然后将其它元素插入。通过比较找到合适的位置，并从最后向后移动一位的元素，找到合适位置并插入。
     */
    public void insertSort(int[] arr){
        //第一个元素作为有序的序列
        for(int i=1;i<arr.length;++i){
            int tmp=arr[i];
            //标记前面有序序列的末尾索引
            int j=i-1;
            //从有序列尾部比较找到一个合适的位置，把比该数大的往后挪一位
            while(j>=0 && tmp<arr[j]){
                arr[j+1]=arr[j];
                --j;
            }
            //由于--j了所以在赋值的时要加上1,表示找到的要插入元素的位置。
            arr[j+1]=tmp;
        }
    }
    public void binInsertSort(int[] arr){
        //升序
        for(int i=1;i<arr.length;++i){
            int tmp=arr[i];
            int pos=findInsertPos(arr,i-1,arr[i]);
            int j=i-1;
            while (j>=pos){
                arr[j+1]=arr[j];
                --j;
            }
            arr[j+1]=tmp;
        }
    }
    public int findInsertPos(int[] arr,int n,int val){
        int down=0;
        int up=n;
        int mid;
        while(down<=up){
            mid=(down+up)/2;
            if(arr[mid]>val){
                up=mid-1;
            }
            else {
                down=mid+1;
            }
        }
        //返回插入位置
        return down;
    }
    /**希尔排序
     *
     */
    public void shellSort(int[] arr){
        //升序
        int gap=arr.length/2;
        //分组
        while (gap>=1){
            for(int i=gap;i<arr.length;++i){
                //插入排序
                int j=i-gap;
                int tmp=arr[i];
                while(j>=0 && tmp < arr[j]){
                    arr[j+gap]=arr[j];
                    j=j-gap;
                }
                arr[j+gap]=tmp;
            }
            gap=gap/2;
        }
    }
    /**堆排序
     * 分为建堆，调整堆，移动堆项到数组末尾。
     * 注意数组下标从0开始，所以堆的左孩子为2i+1,右孩子为2i+2。
     * 注意需要调整堆的左孩子与右孩子也满足堆。
     * 升序，用大顶堆。
     */
    public void heapSort(int[] arr){
        buildHeap(arr);
        for(int i=arr.length-1;i>=0;--i){
            int tmp=arr[i];
            arr[i]=arr[0];
            arr[0]=tmp;
            adjustHeap(arr,0,i-1);
        }
    }
    public void buildHeap(int[] arr){
        for(int i=(arr.length-1)/2;i>=0;--i){
            adjustHeap(arr,i,arr.length-1);
        }
    }
    public void adjustHeap(int[] arr,int head,int tail){
        int lchild= head*2+1;
        int rchild= head*2+2;
        int maxPos=head;
        //如果head是叶节点就结束
        if(head<=tail/2){
            if(lchild <= tail && arr[maxPos]<arr[lchild]){
                maxPos=lchild;
            }
            if(rchild <= tail && arr[maxPos] <arr[rchild]){
                maxPos=rchild;
            }
            if(maxPos!=head){
                int tmp=arr[head];
                arr[head]=arr[maxPos];
                arr[maxPos]=tmp;
                adjustHeap(arr,maxPos,tail);
            }
        }
    }
    /**归并排序据说速度最快哟
     * 稳定，nlog2n，o(n)
     */
    public void mergeSort(int[] arr){
        int[] tmp=new int[arr.length];
        mSort(arr,0,arr.length-1,tmp);
    }
    public void mSort(int[] arr,int left, int right,int[] tmp){
        if(left<right){
            int mid=(left+right)/2;
            mSort(arr,left,mid,tmp);
            mSort(arr,mid+1,right,tmp);
            merge(arr,left,mid,right,tmp);
        }
    }
    public void merge(int[] arr,int left,int mid, int right,int[] tmp){
        int i=left;
        int j=mid+1;
        int t=left;
        while (i<=mid && j<=right){
            if(arr[i]<arr[j]){
                tmp[t++]=arr[i];
                ++i;
            }else {
                tmp[t++]=arr[j];
                ++j;
            }
        }
        //将左边剩余元素放入tmp
        while (i<=mid){
            tmp[t++]=arr[i++];
        }
        //将右边剩余元素放入tmp
        while (j<=right){
            tmp[t++]=arr[j++];
        }
        //将元素放回原来数组
        for(int k=left;k<=right;++k){
            arr[k]=tmp[k];
        }
    }
    /**计数排序
     * 最快的排序
     */
    public void countSort(int[] arr){
        int[] tmp=new int[(int)1e8];
        for(int i=0;i<arr.length;++i){
            ++tmp[arr[i]];
        }
        int k=0;
        for(int i=0;i<tmp.length;++i){
            while(tmp[i]>0){
                arr[k++]=i;
                --tmp[i];
            }
        }
    }
    /**
     * 基数排序，将每位数进行计数排序，每位取值为0-9
     */
    public void radixSort(int[] arr){
        //用作计数区存储数
        int[] tmp=new int[arr.length];
        int[] count=new int[10];
        // 按照从低位到高位的顺序执行排序过程
        for (int d = 0; d <= 8; d++) {
            //置空计数统计
            for(int i=0;i<count.length;++i){
                count[i]=0;
            }
            //统计各个计数区需要容纳的数字
            for(int i=0;i<arr.length;++i){
                ++count[(arr[i]/(int)Math.pow(10,d))%10];
            }
            //计录边界索引,count[i]表示第i个计数区右边界
            for(int i=1;i<count.length;++i){
                count[i]=count[i]+count[i-1];
            }
            //计数排序
            //注意这里写法，从后往前，因为存储计数的时候是从后往前存的，所以这样子，否则是逆序
            for(int i=arr.length-1;i>=0;--i){
//            for(int i=0;i<arr.length;++i){
                int n=(arr[i]/(int)Math.pow(10,d))%10;
                --count[n];
                tmp[count[n]]=arr[i];

            }
            //有序化，降序
            for(int i=0;i<arr.length;++i){
                arr[i]=tmp[i];
//                arr[i]=tmp[arr.length-1-i];
            }
        }
    }

}
