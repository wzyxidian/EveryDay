
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

	/* 
	 * 将结点插入到红黑树中
	 *
	 * 参数说明：
	 *     node 插入的结点        // 对应《算法导论》中的node
	 */
	public void insert(RBTNode<T> node){
		if(node == null)
			return;
		int cmp;
		RBTNode<T> y = null;
		RBTNode<T> x = this.mRoot;
		
		 // 1. 将红黑树当作一颗二叉查找树，将节点添加到二叉查找树中。
		while(x != null){
			y = x;
			cmp = node.key.compareTo(x.key);
			if(cmp < 0)
				x = x.left;
			else 
				x = x.right;
		}
		node.parent = y;
		if(y != null){
			cmp = node.key.compareTo(y.key);
			if(cmp < 0)
				y.left = node;
			else 
				y.right = node;
		}else
			this.mRoot = node;
		
		 // 2. 设置节点的颜色为红色
		node.color = RED;
		
		// 3. 将它重新修正为一颗二叉查找树
	    insertFixUp(node);
	}
	
	/*
	 * 得到节点的父亲节点
	 */
	private RBTNode<T> parentOf(RBTNode<T> node){
		return node!=null ? node.parent : null;
	}
	
	/*
	 * 判断节点是否是红色
	 */
	private boolean isRed(RBTNode<T> node){
		 return ((node!=null)&&(node.color==RED)) ? true : false;
	}
	
	/*
	 * 节点的颜色
	 */
	private boolean colorOf(RBTNode<T> node){
		return (node != null) ? node.color : null;
	}
	
	/*
	 * 判断节点是否是黑色
	 */
	private boolean isBlack(RBTNode<T> node){
		return ((node!=null)&&(node.color==BLACK)) ? true : false;
	}
	
	/*
	 * 设置节点颜色为黑色
	 */
	private void setBlack(RBTNode<T> node){
		if (node!=null)
			node.color = BLACK;
	}
	
	/*
	 * 设置节点颜色为红色
	 */
	private void setRed(RBTNode<T> node){
		 if (node!=null)
			node.color = RED;
	}
	
	/*
	 * 设置父亲节点
	 */
	private void setParent(RBTNode<T> node, RBTNode<T> parent){
		if(node != null) node.parent = parent;
	}
	/*
	 * 红黑树插入修正函数
	 *
	 * 在向红黑树中插入节点之后(失去平衡)，再调用该函数；
	 * 目的是将它重新塑造成一颗红黑树。
	 *
	 * 参数说明：
	 *     node 插入的结点        // 对应《算法导论》中的z
	 */
	public void insertFixUp(RBTNode<T> node){
		RBTNode parent, gparent;
		
		 // 若“父节点存在，并且父节点的颜色是红色”
		while((parent = parentOf(node)) != null && isRed(parent)){
			gparent = parentOf(parent);
			
			//若父节点是祖父节点的左孩子
			if(parent == gparent.left){
				// Case 1条件：叔叔节点是红色
				RBTNode<T> uncle = gparent.right;
				if(uncle != null && isRed(uncle)){
					setBlack(parent);//将父节点设置为黑色
					setBlack(uncle);//将叔叔节点设置为黑色
					setRed(gparent);//将祖父节点设置为红色
					node = gparent;//将祖父节点作为判断点继续进行操作
					continue;
				}
				
				// Case 2条件：叔叔是黑色，且当前节点是右孩子
				if(parent.right == node){
					RBTNode<T> tmp;
					leftRotate(parent);//对父节点进行左旋，然后以旋转之后的父节点作为判断点继续操作
					tmp = parent;
					parent = node;
					node = tmp;
				}
				
				 // Case 3条件：叔叔是黑色，且当前节点是左孩子。
				setBlack(parent);
				setRed(gparent);
				rightRotate(gparent);
			}else{
				//若“z的父节点”是“z的祖父节点的右孩子”
	            // Case 1条件：叔叔节点是红色
				RBTNode<T> uncle = gparent.left;
				if(uncle != null && uncle.color == RED){
					setBlack(parent);
					setBlack(uncle);
					setRed(gparent);
					node = gparent;
					continue;
				}
				
				// Case 2条件：叔叔是黑色，且当前节点是左孩子
				if(parent.left == node){
					RBTNode<T> tmp;
					rightRotate(parent);
					tmp = parent;
					parent = node;
					node = tmp;
				}
				
				// Case 3条件：叔叔是黑色，且当前节点是右孩子。
				setBlack(parent);
				setRed(gparent);
				leftRotate(gparent);
			}
		}
		 // 将根节点设为黑色
		setBlack(mRoot);
	}

	/* 
	 * 删除结点(node)，并返回被删除的结点
	 *
	 * 参数说明：
	 *     node 删除的结点
	 */
	public void remove(RBTNode<T> node){
		RBTNode<T> child, parent;
		boolean color;
		
		// 被删除节点的"左右孩子都不为空"的情况。
		if((node.left != null) && (node.right != null)){
			 // 被删节点的后继节点。(称为"取代节点")
	        // 用它来取代"被删节点"的位置，然后再将"被删节点"去掉。
			
			RBTNode<T> replace = node;
			//获取后继节点
			replace = replace.right;
			while(replace.left != null)
				replace = replace.left;
			 // "node节点"不是根节点(只有根节点不存在父节点)
			if(parentOf(node) != null){
				if(node.parent.left == node)
					node.parent.left = replace;
				else 
					node.parent.right = replace;
			}else{
				// "node节点"是根节点，更新根节点。
	            this.mRoot = replace;
			}
			
			// child是"取代节点"的右孩子，也是需要"调整的节点"。
	        // "取代节点"肯定不存在左孩子！因为它是一个后继节点。
			child = replace.right;
			parent = parentOf(replace);
			color = colorOf(replace);
			// "被删除节点"是"它的后继节点的父节点"
			if(parent == node){
				parent = replace;
			}else{
				if(child != null)
					setParent(child, parent);
				
				parent.left = child;
				replace.right = node.right;
				setParent(node.right, replace);
			}
			replace.parent = node.parent;
			replace.color = node.color;
			replace.left = node.left;
			replace.left.parent = replace;
			if(color = BLACK)
				removeFixUp(child, parent);
			node = null;
			return;
		}
		if(node.left != null){
			child = node.left;
		}else
			child = node.right;
		parent = node.parent;
		// 保存"取代节点"的颜色
		color = node.color;
		if(child != null)
			child.parent = parent;
		//node节点不是根节点
		if(parent != null){
			if(parent.left == node)
				parent.left = child;
			else
				parent.right = child;
		}else{
			this.mRoot = child;
		}
		if(color == BLACK)
			removeFixUp(child,parent);
		node = null;
	}

	/*
	 * 红黑树删除修正函数
	 *
	 * 在从红黑树中删除插入节点之后(红黑树失去平衡)，再调用该函数；
	 * 目的是将它重新塑造成一颗红黑树。
	 *
	 * 参数说明：
	 *     node 待修正的节点
	 */
	 private void removeFixUp(RBTNode<T> node, RBTNode<T> parent) {
		 RBTNode<T> other;
		
		 
	 }
}
