__author__ = 'teng.qian'

from tree_node import TreeNode


def hello():
    return "hello world"

if __name__ == '__main__':
    left = TreeNode(0)
    root = TreeNode(1)
    root.left = left
    print(TreeNode.is_mirror(root, left))
