__author__ = 'teng.qian'


class Solution(object):

    def grayCode(self, n):
        list_code = [0]
        if n == 0:
            return list_code

        return Solution.recurse(n, list_code, 0)

    @staticmethod
    def recurse(n, list_code, cur):
        if n == cur:
            return list_code
        else:
            length = pow(2, cur)
            while length > 0:
                length -= 1
                list_code.append(list_code[length] + pow(2, cur))
            return Solution.recurse(n, list_code, cur + 1)

if __name__ == '__main__':
    s = Solution()
    print(s.grayCode(2))