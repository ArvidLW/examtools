import java.util.Queue;

public class TreeOp {
    /**
     * 前序遍历
     */
    class Tree{
        int data;
        Tree lchild;
        Tree rchild;
    }
    public void preOrder(Tree t){
        if(t!=null){
            System.out.println(t.data);
            preOrder(t.lchild);
            preOrder(t.rchild);
        }
    }
    public void midOrder(Tree t){
        if(t!=null){
            midOrder(t.lchild);
            System.out.println(t.data);
            midOrder(t.rchild);
        }
    }
    public void postOrder(Tree t){
        if(t!=null){
            postOrder(t.lchild);
            postOrder(t.rchild);
            System.out.println(t.data);
        }
    }
    /**
     * 已知前序和中序输出后序
     *
     */
    int[] tree={0,1,2,3,4,5,6};
    int[] pre={0,1,3,4,2,5,6};
    int[] mid={3,1,4,0,5,2,6};
    //注意root表示的是pre中的位置，而start,end表示mid中的位置。
    public void getPost(int root,int start,int end){
        if(start>end){
            return;
        }
        int h=start;
        while(h<end && mid[h]!=pre[root]){
            ++h;
        }
        //左边
        getPost(root+1,start,h-1);
        //右边
        getPost(h+1,h+1,end);
        System.out.println(mid[h]);
    }
    /**
     * 已知前序后中序恢复树
     *
     */
    /**
     * 已知后序后中序恢复树
     *
     */
    /**
     * 层次遍历
     */
    public void levelTraverse(Tree t){

    }

}
