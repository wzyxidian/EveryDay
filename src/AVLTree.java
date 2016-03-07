
//平衡二叉树
public class AVLTree<T extends Comparable<T>> {

	private AVLTreeNode<T> mRoot;
	
	//定义节点
	class AVLTreeNode<T extends Comparable<T>>{
		T key;
		int height;
		AVLTreeNode<T> left;
		AVLTreeNode<T> right;
		public AVLTreeNode(T key, AVLTreeNode<T> left, AVLTreeNode<T> right){
			this.key = key;
			this.left = left;
			this.right = right;
			this.height = 0;
		}
	}

	//获取树的高度
	private int height(AVLTreeNode<T> tree){
		if(tree != null)
			return tree.height;
		return 0;
	}
	
	//比较两个值的大小
	private int max(int a, int b){
		return a>b ? a : b;
	}
	
	//LL的旋转，左右左右
	private AVLTreeNode<T> leftLeftRotation(AVLTreeNode<T> k2){
		AVLTreeNode<T> k1;
		k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = max(height(k2.left),height(k2.right)) + 1;
		k1.height = max(height(k1.left), height(k1.right)) + 1;
		return k1;
	}

	//RR的旋转，右左右左
	private AVLTreeNode<T> rightRightRotation(AVLTreeNode<T> k2){
		AVLTreeNode<T> k1;
		k1 = k2.right;
		k2.right = k1.left;
		k1.left = k2;
		
		k2.height = max(height(k2.left),height(k2.right)) + 1;
		k1.height = max(height(k1.left),height(k1.left)) + 1;
		
		return k1;
	}

	//LR的旋转，右左右左，左右左右
	private AVLTreeNode<T> leftRightRotation(AVLTreeNode<T> k3){
		k3.left = rightRightRotation(k3.left);
		return leftLeftRotation(k3);
	}
	
	//RL的旋转，左右左右，右左右左
	private AVLTreeNode<T> rightLeftRotation(AVLTreeNode<T> k3){
		k3.right = leftLeftRotation(k3.right);
		return rightRightRotation(k3);
	}

	/* 
	 * 将结点插入到AVL树中，并返回根节点
	 *
	 * 参数说明：
	 *     tree AVL树的根结点
	 *     key 插入的结点的键值
	 * 返回值：
	 *     根节点
	 */
	private AVLTreeNode<T> insertAVLTree(AVLTreeNode<T> tree, T key){
		if(tree == null){
			tree = new AVLTreeNode<T>(key,null,null);
			if(tree == null)
				System.out.println("fail to insert the tree");
			return null;
		}else{
			int com = key.compareTo(tree.key);
			if(com < 0){
				tree.left = insertAVLTree(tree.left, key);
				if(height(tree.left) - height(tree.right) == 2){
					if(key.compareTo(tree.left.key) < 0)
						tree = leftLeftRotation(tree);
					else 
						tree =  leftRightRotation(tree);
				}
			}else if(com > 0){
				tree.right = insertAVLTree(tree.right, key);
				if(height(tree.right) - height(tree.left) == 2){
					if(key.compareTo(tree.right.key) > 0)
						tree = rightRightRotation(tree);
					else
						tree = rightLeftRotation(tree);
				}
			}else{
				System.out.println("fail");
			}
		}
		tree.height = max(height(tree.left),height(tree.right)) + 1;
		return tree;
	}
	
	/* 
	 * 删除结点(z)，返回根节点
	 *
	 * 参数说明：
	 *     tree AVL树的根结点
	 *     z 待删除的结点
	 * 返回值：
	 *     根节点
	 */
	private AVLTreeNode<T> deleteAVLTree(AVLTreeNode<T> tree, AVLTreeNode<T> z){
		// 根为空 或者 没有要删除的节点，直接返回null。
		if(tree == null || z == null)
			return null;
		int com = z.key.compareTo(tree.key);
		if(com < 0){// 待删除的节点在"tree的左子树"中
			tree.left = deleteAVLTree(tree.left, z);
			// 删除节点后，若AVL树失去平衡，则进行相应的调节。
			if(height(tree.right) - height(tree.left) == 2){
				AVLTreeNode<T> r = tree.right;
				if(height(r.left) > height(r.right))
					tree = rightLeftRotation(tree);
				else
					tree = rightRightRotation(tree);
			}
		}else if(com > 0){// 待删除的节点在"tree的右子树"中
			tree.right = deleteAVLTree(tree.right, z);
			// 删除节点后，若AVL树失去平衡，则进行相应的调节。
			if(height(tree.left) - height(tree.right) == 2){
				AVLTreeNode<T> l = tree.left;
				if(height(l.left) > height(l.right))
					tree = leftLeftRotation(tree);
				else
					tree = leftRightRotation(tree);
			}
		}else{// tree是对应要删除的节点。
			// tree的左右孩子都非空
			if(tree.left != null && tree.right != null){
				if(height(tree.left) > height(tree.right)){
					// 如果tree的左子树比右子树高；
	                // 则(01)找出tree的左子树中的最大节点
	                //   (02)将该最大节点的值赋值给tree。
	                //   (03)删除该最大节点。
	                // 这类似于用"tree的左子树中最大节点"做"tree"的替身；
	                // 采用这种方式的好处是：删除"tree的左子树中最大节点"之后，AVL树仍然是平衡的。
					AVLTreeNode<T> max = maximun(tree.left);
					tree.key = max.key;
					tree.left = deleteAVLTree(tree.left,max);
				}else{
					// 如果tree的左子树不比右子树高(即它们相等，或右子树比左子树高1)
					// 则(01)找出tree的右子树中的最小节点
					//   (02)将该最小节点的值赋值给tree。
				    //   (03)删除该最小节点。
					// 这类似于用"tree的右子树中最小节点"做"tree"的替身；
					// 采用这种方式的好处是：删除"tree的右子树中最小节点"之后，AVL树仍然是平衡的。
					AVLTreeNode<T> min = minimun(tree.right);
					tree.key = min.key;
					tree.right = deleteAVLTree(tree.right, min);
				}
			}else{
				AVLTreeNode<T> temp = tree;
				tree = (tree.left != null) ? tree.right : tree.left;
				temp = null;
			}
		}
		return tree;
	}
	
	private AVLTreeNode<T> maximun(AVLTreeNode<T> node){
		if(node == null)
			return null;
		while(node.right != null)
			node = node.right;
		return node;
	}
	
	private AVLTreeNode<T> minimun(AVLTreeNode<T> node){
		if(node != null)
			return null;
		while(node.left != null)
			node = node.left;
		return node;
	}
}
