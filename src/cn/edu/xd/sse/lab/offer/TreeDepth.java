package cn.edu.xd.sse.lab.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhiyongwang on 2016/5/17.
 * the depth of the tree
 */
public class TreeDepth {

    /**
     * recursive to calculate the depth of the tree
     *
     * @param pRoot root of the tree
     * @return the depth of the tree
     */
    public int treeDepth(TreeNode pRoot) {
        if (pRoot == null)
            return 0;
        if (pRoot.left == null && pRoot.right == null)
            return 1;
        int left = treeDepth(pRoot.left);
        int right = treeDepth(pRoot.right);

        return left > right ? left + 1 : right + 1;
    }


    /**
     * circle to calculate the depth of the tree
     * note:
     * define three variable:
     * depth: 树的深度
     * length: 树每一层节点的个数
     * count: 用来统计队列中弹出节点的个数
     * idea：每求一次深度，把该层中所有的节点都要弹出来，然后把弹出来的每个节点存在的左右节点放到队列中
     *
     * @param pRoot root of the tree
     * @return the depth of the tree
     */
    public int treeDepthCirculate(TreeNode pRoot) {
        if (pRoot == null)
            return 0;
        if (pRoot.left == null && pRoot.right == null)
            return 1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(pRoot);
        int depth = 0;
        while (!queue.isEmpty()) {
            ++depth;
            int length = queue.size();  //the number treeNode of every layer
            int count = 0;
            while (count < length) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                count++;
            }
        }
        return depth;
    }

}
