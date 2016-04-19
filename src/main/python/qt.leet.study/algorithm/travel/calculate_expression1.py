__author__ = 'teng.qian'


class Solution(object):

    @staticmethod
    def to_postfix(s):
        s = "(" + s + ")"
        result = []
        last = 0
        right = False
        temp = []
        for cur in s:
            if Solution.is_left_bracket(cur):
                temp.append(cur)
            elif Solution.is_right_bracket(cur):
                if not right:
                    result.append(last)
                    last = 0
                h = temp.pop()
                while h != '(':
                    result.append(h)
                    h = temp.pop()
                right = True
            elif Solution.is_operate(cur):
                if right:
                    right = False
                else:
                    result.append(last)
                    last = 0
                while len(temp) > 0:
                    last_symbol = temp.pop()
                    if last_symbol == '(':
                        temp.append(last_symbol)
                        break
                    result.append(last_symbol)
                temp.append(cur)
            elif Solution.is_number(cur):
                last = last * 10 + int(cur)
        return result

    def calculate(self, s):
        if len(s) <= 1:
            return int(s)
        prefix = Solution.to_postfix(s)
        stack = []
        for e in prefix:
            if Solution.is_operate(e):
                right = stack.pop()
                stack.append(Solution.count(e, stack.pop(), right))
            else:
                stack.append(e)
        return stack.pop()


    @staticmethod
    def count(label, left, right):
        if label == "+":
            return left + right
        if label == "-":
            return left - right
        if label == "*":
            return left * right
        if label == "/":
            return left / right

    @staticmethod
    def is_left_bracket(c):
        return c == '('
    @staticmethod
    def is_right_bracket(c):
        return c == ')'
    @staticmethod
    def is_number(c):
        return (c >= '0') & (c <= '9')
    @staticmethod
    def is_operate(c):
        return (c == '+') | (c == '-')



if __name__ == '__main__':
    solution = Solution()
    print(solution.calculate("(1)"))