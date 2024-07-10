package com.array;

public class RangeSum1D {

	public static void main(String[] args) {

		NumArray numArray = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});
		

		numArray.sumRange(0, 2);
		
	}

}
class NumArray {
    int[] temp;

    public NumArray(int[] nums) {
        temp = nums;
        for (int i = 1; i < temp.length; i++) {
            temp[i] += temp[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return temp[right];
        }
        return temp[right] - temp[left - 1];
    }
}
