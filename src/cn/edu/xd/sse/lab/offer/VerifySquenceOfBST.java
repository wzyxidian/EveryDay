package cn.edu.xd.sse.lab.offer;

/**
 * @author zhiyong wang
 * 题目：二叉搜索树的后序遍历序列
 * 题目描述：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。 
 */
public class VerifySquenceOfBST {

	public static void main(String[] args) {
		VerifySquenceOfBST vs = new VerifySquenceOfBST();
		System.out.println(vs.verifySquenceOfBST(new int[]{4, 8, 6, 12, 16, 14, 10}));
	}
	
	/**
	 * 用递归方式来进行求解，因为是后续遍历的结果，所以每次把最后一个值拿出来，然后将前边部分分成左右两部分，然后在分别判断是否是后续遍历
	 * @param sequence
	 * @return
	 */
	public boolean verifySquenceOfBST(int[] sequence){
		if(sequence == null || sequence.length <= 0)
			return false;
		int len = sequence.length;
		int root = sequence[len - 1];
		int i = 0;
		for(;i < len - 1; i++){
			if(sequence[i] > root)
				break;
		}

		int j = i;
		for(;j < len - 1; j++){
			if(sequence[j] < root)
				return false;
		}
		int[] leftArray = new int[i];
		int[] rightArray = new int[len - i - 1];
		System.arraycopy(sequence, 0, leftArray, 0, i);
		System.arraycopy(sequence, i, rightArray, 0, len - i - 1);
		boolean left = true;
		boolean right = true;
		if(i > 0){
			left = verifySquenceOfBST(leftArray);
		}
		if(j < len - 1){
			right = verifySquenceOfBST(rightArray);
		}
		return left && right;
    }
	
}
