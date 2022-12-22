import java.util.*;

public class LC347 {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(topKFrequent(new int[] {1}, 1)));

    }

    //Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
    //
    //
    //
    //Example 1:
    //
    //Input: nums = [1,1,1,2,2,3], k = 2
    //Output: [1,2]
    //Example 2:
    //
    //Input: nums = [1], k = 1
    //Output: [1]
    //
    //
    //Constraints:
    //
    //1 <= nums.length <= 105
    //-104 <= nums[i] <= 104
    //k is in the range [1, the number of unique elements in the array].
    //It is guaranteed that the answer is unique.

    //Time Complexity O(n)
    //Space Complexity O(n)

    public static int[] topKFrequent(int[] nums, int k) {
        //Store our frequencies
        Map<Integer, Integer> map = new HashMap<>();
        //Bucket Sort- List of int[]
        List<Integer>[] bucket = new List[nums.length+1];

        //Mapping our frequencies
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        //Here we fill up our bucket with the frequencies and the correpsponding elements
        for(int key: map.keySet()){
            if(bucket[map.get(key)] == null){
                bucket[map.get(key)] = new ArrayList<>();
            }
            bucket[map.get(key)].add(key);
        }

        List<Integer> tempAns = new ArrayList<>();

        //Filter through the end of the bucket to get our k most frequent elements
        //add them to our tempArray
        for(int i = bucket.length-1;i>=0 && tempAns.size()<k;i--){
            if(bucket[i] != null){
                tempAns.addAll(bucket[i]);
            }
        }
        //Turning our arrayList into int[] to satisfy the return value of the method
        int[] ans = new int[k];
        for(int i = 0;i<tempAns.size();i++){
            ans[i] = tempAns.get(i);
        }
        //return our int[] final answer
        return ans;
    }
}
