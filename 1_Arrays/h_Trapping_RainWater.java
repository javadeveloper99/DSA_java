// Total Time Complexity = O(n)
// Total Space Complexity = O(n)



public class h_Trapping_RainWater {

  public static void calculateTrappedWater(int[] height) {
    int n = height.length;

    if (n == 0)
      return;

    // left max array
    int[] leftMax = new int[n];
    leftMax[0] = height[0];
    for (int i = 1; i < n; i++) {
      leftMax[i] = Math.max(height[i], leftMax[i - 1]);
    }

    // right max array
    int[] rightMax = new int[n];
    rightMax[n - 1] = height[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      rightMax[i] = Math.max(height[i], rightMax[i + 1]);
    }

    // Calculate trapped water
    int totalWater = 0;
    for (int i = 0; i < n; i++) {
      int waterLevel = Math.min(leftMax[i], rightMax[i]);
      totalWater += waterLevel - height[i];
    }

    System.out.println("Rain Water Stored in the bar is: " + totalWater);
  }

  public static void main(String[] args) {
    int height[] = {4,5,3,2,6,4,5,6};
    calculateTrappedWater(height);
  }
}
