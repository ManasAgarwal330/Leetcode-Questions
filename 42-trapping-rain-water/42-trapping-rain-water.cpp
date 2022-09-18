class Solution {
public:
    int trap(vector<int>& height) {
        int ans = 0, n = height.size();
        // dp1[i]: the max height of bar from the left till position i
        // dp2[i]: the max height of bar from the right till position i
        vector<int> dp1(n), dp2(n);
        // let's build dp1 first
        dp1[0] = height[0];
        // for each position i, 
        // if the current height is greater than the max height, then dp1[i] will be height[i]
        // else dp1[i] will be taking the previous result, i.e. dp1[i - 1]
        for (int i = 1; i < n; i++) dp1[i] = max(dp1[i - 1], height[i]);
        // build dp2 in a similar way
        dp2[n - 1] = height[n - 1];
        // for each position i, 
        // if the current height is greater than the max height, 
        // then dp2[i] will be height[i]
        // else dp2[i] will be taking the previous result, i.e. dp2[i + 1]
        for (int i = n - 2; i >= 0; i--) dp2[i] = max(dp2[i + 1], height[i]);
        // then iterate the heights and take the minimum of dp1[i] and dp2[i]
        // why minimum? because that is the max height a bar can hold. (water will overflow)
        // then we substract height[i] from the min
        // if min(dp1[i], dp2[i]) is 2 and height[i] is 2, then no water is being trapped
        // if min(dp1[i], dp2[i]) is 2 and height[i] is 0, then 2 units of water are being trapped
        for (int i = 1; i < n - 1; i++) ans += min(dp1[i], dp2[i]) - height[i];
        return ans;
    }
};