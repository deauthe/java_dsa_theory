public class CWMWoptimized {
    public static int maxWaterStored(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int maxWater = 0;
        while (l < r) {
            int currentWater = Math.min(heights[l], heights[r]) * (r - l - 1);
            if (currentWater > maxWater) {
                maxWater = currentWater;
            }
            if (heights[l] > heights[r]) {
                r--;
            } else if (heights[l] < heights[r]) {
                l++;
            } else if (heights[l] == heights[r]) {
                l++;
                r--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        int heights[] = { 1, 8, 6, 2, 5, 4, 8, 5, 7 };
        System.out.println(maxWaterStored(heights));
    }
}
