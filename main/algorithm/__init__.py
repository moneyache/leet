__author__ = 'teng.qian'


class Solution(object):

    def grayCode(self, n):
        list_code = []
        if n == 0:
            return list_code
        if n == 1:
            return [0, 1]
        return Solution.recurse(n, [0, 1], 1)

    @staticmethod
    def recurse(n, list_code, cur):
        if n == cur:
            return list_code
        else:
            length = 2 * cur
            while length > 0:
                length -= 1
                list_code.append(list_code[length] + pow(2, cur))
            return Solution.recurse(n, list_code, cur + 1)

if __name__ == '__main__':
    s = Solution()
    print(s.grayCode(2))