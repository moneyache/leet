__author__ = 'teng.qian'


class Solution(object):

    def grayCode(self, n):
        list_code = []
        Solution.recurse(n, list_code, 0)
        return list_code

    @staticmethod
    def recurse(n, list_code, cur):
        if n == 0:
            list_code.append(cur)
        else:
            Solution.recurse(n - 1, list_code, cur)
            Solution.recurse(n - 1, list_code, cur + pow(2, n - 1))

if __name__ == '__main__':
    s = Solution()
    print(s.grayCode(0))