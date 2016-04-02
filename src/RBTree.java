
/**
 * @author zhiyong wang
 * 红黑树的实现
 */
public class RBTree<T extends Comparable<T>> {
	private RBTNode<T> mRoot;//根节点
	private static final boolean RED = false;
	private static final boolean BLACK = true;
	
	class RBTNode<T extends Comparable<T>>{
		boolean color;//颜色
		T key;//关键字
		RBTNode left;
		RBTNode right;
		RBTNode parent;
		
		public RBTNode(boolean color, T key, RBTNode<T> parent, RBTNode<T> left, RBTNode<T> right){
			this.color = color ;
			this.key = key;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}
	}
	
	/* 
	 * 对红黑树的节点(x)进行左旋转
	 *
	 * 左旋示意图(对节点x进行左旋)：
	 *      px                              px
	 *     /                               /
	 *    x                               y                
	 *   /  \      --(左旋)-.           / \                #
	 *  lx   y                          x  ry     
	 *     /   \                       /  \
	 *    ly   ry                     lx  ly  
	 * RLRL 右左右左，将右孩子的左孩子，作为父亲节点的右孩子，父亲节点作为右孩子的左孩子
	 *
	 */
	public void leftRotate(RBTNode<T> x){
		//设置x的右孩子为y
		RBTNode<T> y = x.right;
		x.right = y.left;//将y的左孩子作为x的右孩子
		if(y.left != null)//如果左孩子非空，将x设为y的左孩子的父亲
			y.left.parent = x;
		y.parent = x.parent; //将x的父节点设为y的父节点
		if(x.parent == null)
			this.mRoot = y; //如果父节点为空，y为根节点
		else{
			if(x == x.parent.left) //如果x是它父节点的左孩子，设y为x的父节点的左孩子
				x.parent.left = y;
			else
				x.parent.right = y;//如果x是它父节点的右孩子，设y为x的父节电的右孩子
		}
		y.left = x;  //将x设为y的左孩子
		x.parent = y; //将x的父节电设为y
	}
	/* 
	 * 对红黑树的节点(y)进行右旋转
	 *
	 * 右旋示意图(对节点y进行左旋)：
	 *            py                               py
	 *           /                                /
	 *          y                                x                  
	 *         /  \      --(右旋)-.            /  \                     #
	 *        x   ry                           lx   y  
	 *       / \                                   / \                   #
	 *      lx  rx                                rx  ry
	 * 
	 * LRLR 将左孩子的右孩子作为父亲节点的左孩子，父亲节点作为孩子的右孩子
	 */
	public void rightRotate(RBTNode<T> x){
		//设y为x的左孩子
		RBTNode<T> y = x.left;
		x.left = y.right;
		if(y.right != null)
			y.right.parent = x;
		y.parent = x.parent;
		if(x.parent == null)
			this.mRoot = y;
		else{
			if(x.parent.left == x)
				x.parent.left = y;
			else
				x.parent.right = y;
		}
		y.right = x;
		x.parent = y;
	}

	

}
