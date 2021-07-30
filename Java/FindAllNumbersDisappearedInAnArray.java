public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        for(int num : nums) {
            int val = Math.abs(num) - 1;
                nums[val] = nums[val] > 0 ? -1 * nums[val] : nums[val];
        }
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
        
    }
}
