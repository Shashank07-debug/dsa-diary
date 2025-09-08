import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverLappingIntervals {

    //Brute Force Approach TC -> O(N ^ 2) + O(NLogN) SC -> O(N) + O(1)
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1)[1]) {
                continue;
            }

            for (int j = i + 1; j < n; j++) {
                if (intervals[j][0] <= end) {
                    end = Math.max(end, intervals[j][1]);
                } else {
                    break;
                }
            }

            ans.add(new int[]{start, end});
        }

        return ans.toArray(new int[ans.size()][]);
    }

    //Optimized Code TC - > O(NLogN) SC -> O(N)
    public int[][] merge2(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(ans.isEmpty() || intervals[i][0] > ans.get(ans.size() - 1)[1]){
                ans.add(intervals[i]);
            }else{
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], intervals[i][1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        MergeOverLappingIntervals obj = new MergeOverLappingIntervals();

        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}, {17, 20}};
        int[][] result = obj.merge(intervals);

        System.out.println("Merged Intervals:");
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
