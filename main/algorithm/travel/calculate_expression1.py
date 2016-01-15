__author__ = 'teng.qian'


class Solution(object):

    @staticmethod
    def recurse(index, s, max_index, stack, is_start):
        if index >= max_index:
            return index, Solution.cal_stack(stack)
        c = s[index]
        if c == ' ':
            return Solution.recurse(index + 1, s, max_index, stack, is_start)
        if c == '(':
            if len(stack) == 0:
                return Solution.recurse(index + 1, s, max_index, stack, True)
            if (stack[len(stack) - 1]) == '+':
                return Solution.recurse(index + 1, s, max_index, stack, True)
            index, v = Solution.recurse(index + 1, s, max_index, [], is_start)
            stack.append(v)
            return Solution.recurse(index + 1, s, max_index, stack, is_start)
        elif c == ')':
            if is_start:
                return Solution.recurse(index + 1, s, max_index, stack, False)
            return index, Solution.cal_stack(stack)
        elif (c == '+') | (c == '-'):
            last = Solution.cal_stack(stack)
            stack.append(last)
            stack.append(c)
        else:
            temp = len(stack)
            if temp == 0:
                stack.append(int(c))
            else:
                later = stack[temp - 1]
                if (later == '+') | (later == '-'):
                    stack.append(int(c))
                else:
                    stack[temp - 1] = (later*10 + int(c))
        return Solution.recurse(index + 1, s, max_index, stack, is_start)



    @staticmethod
    def cal_stack(stack):
        if len(stack) >= 3:
            right = stack.pop()
            return Solution.count(stack.pop(), stack.pop(), right)
        return stack.pop()

    def calculate(self, s):
        if len(s) <= 1:
            return int(s)
        return Solution.recurse(0, s, len(s), [], False)[1]


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
    print(solution.calculate("2+4-1"))