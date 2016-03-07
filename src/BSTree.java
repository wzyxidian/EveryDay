
//二叉查找树的定义，查询，插入，删除
public class BSTree<T extends Comparable<T>>{

	private BSTNode<T> mRoot;//定义根节点
	//定义节点
	private class BSTNode<T extends Comparable<T>>{
		T key;
		BSTNode<T> left; //左节点
		BSTNode<T> right; //右节点
		BSTNode<T> parent; //父母节点
		
		public BSTNode(T key, BSTNode<T> left, BSTNode<T> right, BSTNode<T> parent){
			this.key = key;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
	}

	//递归来遍历二叉查找树
	public BSTNode<T> recursionBSTSearch(BSTNode<T> x, T key){
		if(x == null) return x;
		
		int compare = key.compareTo(x.key);
		if(compare < 0)
			return recursionBSTSearch(x.left, key);
		else if(compare > 0)
			return recursionBSTSearch(x.right, key);
		else
			return x;
	}
	
	//迭代来遍历二叉查找树
	public BSTNode<T> iteratorBSTSearch(BSTNode<T> x, T key){
		while(x != null){
			int compare = key.compareTo(x.key);
			if(compare < 0) 
				x = x.left;
			else if(compare > 0)
				x = x.right;
			else 
				return x;
		}
		return x;
	}

	//查找二叉树的最大值
	public BSTNode<T> maximun(BSTNode<T> x){
		if(x == null) return null;
		while(x.right != null)
			x = x.right;
		return x;
	}
	
	//查找二叉树的最小值
	public BSTNode<T> minimun(BSTNode<T> x){
		if(x == null) return null;
		while(x.left != null)
			x = x.left;
		return x;
	}

	//查找二叉树中的某节点的前驱节点
	public BSTNode<T> predecessor(BSTNode<T> x){
		if(x == null) return null;
		/* 
		 * 找结点(x)的前驱结点。即，查找"二叉树中数据值小于该结点"的"最大结点"。
		 */
		// 如果x存在左孩子，则"x的前驱结点"为 "以其左孩子为根的子树的最大结点"。
		while(x.left != null)
			return maximun(x.left);
		// 如果x没有左孩子。则x有以下两种可能：
	    // (01) x是"一个右孩子"，则"x的前驱结点"为 "它的父结点"。
	    // (01) x是"一个左孩子"，则查找"x的最低的父结点，并且该父结点要具有右孩子"，找到的这个"最低的父结点"就是"x的前驱结点"。
		BSTNode<T> parent = x.parent;
		while(parent != null && x == parent.left){
			x =  parent;
			parent = parent.parent;
		}
		return parent;
	}

	//查找二叉树中的某节点的后继节点
	public BSTNode<T> successor(BSTNode<T> x){
		/* 
		 * 找结点(x)的后继结点。即，查找"二叉树中数据值大于该结点"的"最小结点"。
		 */
		if(x == null) return null;
		// 如果x存在右孩子，则"x的后继结点"为 "以其右孩子为根的子树的最小结点"。
		while(x.right != null)
			return minimun(x.right);
		// 如果x没有右孩子。则x有以下两种可能：
	    // (01) x是"一个左孩子"，则"x的后继结点"为 "它的父结点"。
	    // (02) x是"一个右孩子"，则查找"x的最低的父结点，并且该父结点要具有左孩子"，找到的这个"最低的父结点"就是"x的后继结点"。
		BSTNode<T> parent = x.parent;
		while(parent != null && x == parent.right){
			x = parent;
			parent = parent.parent;
		}
		return parent;
	}

	//插入节点
	public void insertBSTNode(BSTree<T> tree, BSTNode<T> x){
		int compare;
		BSTNode<T> y = null;
		BSTNode<T> node = tree.mRoot;
		while(node != null){
			y = node;
			compare = x.key.compareTo(node.key);
			if(compare > 0)
				node = node.right;
			else
				node = node.left;
		}
		x.parent = y;
		if(y == null)
			tree.mRoot = x;
		else{
			compare = x.key.compareTo(y.key);
			if(compare > 0)
				y.right =  x;
			else 
				y.left = x;
		}
	}

	//删除节点
	public void removeBSTNode(BSTree<T> bst, BSTNode<T> z){
		BSTNode<T> x = null;
		BSTNode<T> y = null;
		if(z.left == null || z.right ==  null)
			y =  z;
		else
			y = successor(z);
		
		if(y.left != null)
			x = y.left;
		else 
			x = y.right;
		
		if(x != null)
			x.parent = y.parent;
		
		if(y.parent == null)
			bst.mRoot = x;
		else if(y == y.parent.left)
			y.parent.left = x;
		else
			y.parent.right = x;
		
		if(y != z)
			z.key = y.key;
	}
	
	/*
	 * 打印"二叉查找树"
	 *
	 * key        -- 节点的键值 
	 * direction  --  0，表示该节点是根节点;
	 *               -1，表示该节点是它的父结点的左孩子;
	 *                1，表示该节点是它的父结点的右孩子。
	 */
	public void print(BSTNode<T> tree, T key, int direction){
		if(tree == null) return ;
		if(direction == 0)
			System.out.println(key +" is root'value");
		else{
			String s = direction== 1 ? "right" : "left";
			System.out.println(key + " is " + s);
		}
		print(tree.left, tree.key,-1);
		print(tree.right,tree.key,1);
	}

	//销毁树
	public void destroy(BSTNode<T> tree){
		if(tree == null) return ;
		if(tree.left != null)
			destroy(tree.left);
		if(tree.right != null)
			destroy(tree.right);
		tree = null;
	}
}
