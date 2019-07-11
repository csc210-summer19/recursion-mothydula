//Author: Tim Lukau
/**
 * Complete the seven methods methods in this file using recursion, no loops.
 * Also complete these three methods inside LinkedList<E>: get(int) removeAll(E)
 * duplicateAll(E)
 * 
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 * findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will be using this
 * same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Tim Lukau
 */
public class RecursionFun {

	// Complete recursive method combinations that returns from n choose k.
	// This method is described in 17_SimpleRecursion.pptx.
	public int combinations(int n, int k) {
		if (k < 0 || k > n) {
			return 0;
		} else if (k == 0 || n == k) {
			return 1;
		} else {
			return combinations(n - 1, k) + combinations(n - 1, k - 1);
		}
	}

	// Complete recursive method intWithCommas that returns the argument as a String
	// with commas in the correct places.
	//
	// intWithCommas(999) returns "999"
	// intWithCommas(1234) returns "1,234"
	// intWithCommas(1007) returns "1,007"
	// intWithCommas(1023004567) returns "1,023,004,567"
	//
	// Precondition: n >= 0
	public String intWithCommas(int n) {
		String stringN = String.valueOf(n);
		return intWithCommas(0, stringN);
	}

	private String intWithCommas(int i, String n) {
		if (n.length() <= 3) {
			return n;
		} else if (n.length() == 1) {
			return n;
		} else {
			if ((n.length() - i - 1) % 3 == 0) {
				return n.substring(0, 1) + "," + intWithCommas(i + 1, n.substring(1, n.length()));
			} else {
				return n.substring(0, 1) + intWithCommas(i + 1, n.substring(1, n.length()));
			}
		}
	}

	// Write recursive method reverseArray that reverses the array elements in a
	// filled array of ints. Use recursion; do not use a loop. The following
	// assertions must pass:
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// Precondition: x.length > 0
	public void reverseArray(int[] x) {
		// You need a private helper that needs additional arguments.
		// like x and x.length to keep track of array the indexes
		// with no loop. Here is an example with the private helper
		// immediately below.
		reverseArray(x, 0, x.length);
	}

	private void reverseArray(int[] x, int index, int len) {
		if (index == len - 1 && len % 2 != 0) {
			int oldIndex = x[index];
			int oldLen = x[len - 1];
			x[index] = oldLen;
			x[len - 1] = oldIndex;
		} else if (index != len - 1 && index != len) {
			int oldIndex = x[index];
			int oldLen = x[len - 1];
			x[index] = oldLen;
			x[len - 1] = oldIndex;
			reverseArray(x, index + 1, len - 1);
		}
	}

	// Write recursive method arrayRange that returns the maximum
	// integer minus the minimum integer in the filled array of
	// integers, Use recursion; do not use a loop.
	// Precondition: a.length > 0
	public int arrayRange(int[] a) {
		int max = findMax(a, 0, a[0]);
		int min = findMin(a, 0, a[0]);
		return max - min;
	}

	private int findMin(int[] a, int i, int min) {
		if (i == a.length - 1) {
			if (a[i] < min) {
				min = a[i];
			}
			return min;
		} else {
			if (a[i] < min) {
				min = a[i];
			}
			return findMin(a, i + 1, min);
		}
	}

	private int findMax(int[] a, int i, int max) {
		if (i == a.length - 1) {
			if (a[i] > max) {
				max = a[i];
			}
			return max;
		} else {
			if (a[i] > max) {
				max = a[i];
			}
			return findMax(a, i + 1, max);
		}
	}

	// Return true if nums has all int elements in ascending order.
	// If not isSorted, return false.
	public boolean isSorted(int[] nums) {
		return isSorted(nums, 1);
	}

	private boolean isSorted(int[] nums, int i) {
		if (nums.length == 1 || nums.length == 0) {
			return true;
		} else if (i == nums.length - 1) {
			if (nums[i] < nums[i - 1]) {
				return false;
			} else {
				return true;
			}
		} else {
			if (nums[i] < nums[i - 1]) {
				return false;
			} else {
				return isSorted(nums, i + 1);
			}
		}
	}

	// Complete method found to return true if search is found in strs.
	// If not found, return false. Use equals, not ==.
	public boolean found(String search, String[] strs) {
		return found(search, strs, 0);
	}

	private boolean found(String search, String[] strs, int i) {
		if (strs.length == 0) {
			return false;
		} else if (i == strs.length - 1) {
			if (strs[i].equals(search)) {
				return true;
			} else {
				return false;
			}
		} else {
			if (strs[i].equals(search)) {
				return true;
			} else {
				return found(search, strs, i + 1);
			}
		}
	}
}
