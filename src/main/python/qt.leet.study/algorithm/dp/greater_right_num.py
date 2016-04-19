__author__ = 'teng.qian'


class Solution(object):

    @staticmethod
    def insert_sorted_arr(sorted_arr, num):
        index = Solution.found_index(sorted_arr, num)
        sorted_arr.insert(index, num)

    @staticmethod
    def found_index(sorted_arr, num):
        arr_length = len(sorted_arr)
        if arr_length < 1:
            return 0
        elif num <= sorted_arr[0]:
            return 0
        elif num > sorted_arr[arr_length - 1]:
            return arr_length
        return Solution.recurse_found_index(sorted_arr, 0, arr_length - 1, num)

    @staticmethod
    def recurse_found_index(sorted_arr, left, right, num):
        if left >= right:
            return left if sorted_arr[left] >= num else left + 1
        mid = (left + right) / 2

        if sorted_arr[mid] >= num:
            return Solution.recurse_found_index(sorted_arr, left, mid - 1, num)
        else:
            return Solution.recurse_found_index(sorted_arr, mid + 1, right, num)

    def countSmaller(self, nums):
        length = len(nums)
        result = [0]*length
        if length < 2:
            return result
        pos = length - 1
        sorted_arr = [nums[pos]]
        while pos > 0:
            pos -= 1
            index = Solution.found_index(sorted_arr, nums[pos])
            result[pos] = index
            sorted_arr.insert(index, nums[pos])
        return result



if __name__ == '__main__':
    solution = Solution()
    test = [5, 2, 6, 1]
    print(solution.countSmaller(test))