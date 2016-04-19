package study.leet.tree;


public  class GetNumKLevel<E> {

	public  int getNum(TreeNode<E> current,int level) {
		if (current==null) {
			return 0;
		}
		if (level==0) {
			return 0;
		}
		if (level==1) {
			return 1;
		}
		return getNum(current.leftChild, level-1)+getNum(current.rightChild, level-1);
	}
}
