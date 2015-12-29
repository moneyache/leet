__author__ = 'teng.qian'


class TreeNode(object):
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

    def depth(self):
        if self is None:
            return
        if self.left is None:
            left_depth = 0
        else:
            left_depth = self.left.depth() + 1
        if self.right is None:
            right_depth = 0
        else:
            right_depth = self.right.depth() + 1

        if left_depth > right_depth:
            return left_depth
        return right_depth

    @staticmethod
    def is_mirror(one, other):
        if one is None:
            if other is None:
                return True
            else:
                return False
        else:
            if other is None:
                return False
            else:
                return TreeNode.is_mirror(one.left, other.left) & TreeNode.is_mirror(one.right, other.right)