__author__ = 'teng.qian'


class Solution(object):
    def lengthOfLIS(self, nums):
        length = len(nums)
        if length < 2:
            return length
        nums_dp = [1]
        max_index = 0
        min_index = 0
        index = 1
        while index < length:
            temp_max = 1
            i = 0
            if nums[index] <= nums[min_index]:
                min_index = index
            elif nums[index] > nums[max_index]:
                temp_max = nums_dp[max_index] + 1
                max_index = index
            else:
                while i < index:
                    if nums[i] < nums[index]:
                        temp_max = nums_dp[i] + 1 if nums_dp[i] + 1 > temp_max else temp_max
                    i += 1
            nums_dp.append(temp_max)
            max_index = index if temp_max > nums_dp[max_index] else max_index
            index += 1
        return nums_dp[max_index]
if __name__ == '__main__':
    solution = Solution()
    print(solution.lengthOfLIS([1, 3, 5, 2, 4, 8, 9]))