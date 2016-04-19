__author__ = 'teng.qian'


class Solution(object):

    def calculate(self, s):

        length = len(s)
        if length < 2:
            return int(s)
        stack = []
        need_cal = False
        for c in s:
            if (c == '*') | (c == '/'):
                if need_cal:
                    right = stack.pop()
                    stack.append(Solution.count(stack.pop(), stack.pop(), right))
                need_cal = True
                stack.append(c)
                continue
            if (c == '+') | (c == '-'):
                if need_cal:
                    right = stack.pop()
                    stack.append(Solution.count(stack.pop(), stack.pop(), right))
                    need_cal = False
                if len(stack) >= 3:
                    right = stack.pop()
                    stack.append(Solution.count(stack.pop(), stack.pop(), right))
                stack.append(c)
                continue
            stack_len = len(stack)
            if stack_len == 0:
                stack.append(c)
                continue
            last = stack[stack_len - 1]
            if (last == '+') | (last == '-') | (last == '*') | (last == '/'):
                stack.append(c)
                continue
            stack[stack_len - 1] = (last + c)
        if len(stack) == 1:
            return stack.pop()
        if need_cal:
            right = stack.pop()
            stack.append(Solution.count(stack.pop(), stack.pop(), right))
        if len(stack) >= 3:
            right = stack.pop()
            stack.append(Solution.count(stack.pop(), stack.pop(), right))
        return stack.pop()

    @staticmethod
    def count(label, left, right):
        if label == "+":
            return int(left) + int(right)
        if label == "-":
            return int(left) - int(right)
        if label == "*":
            return int(left) * int(right)
        if label == "/":
            return int(left) / int(right)


if __name__ == '__main__':
    solution = Solution()
    print(solution.calculate("21+3*21+50/20"))