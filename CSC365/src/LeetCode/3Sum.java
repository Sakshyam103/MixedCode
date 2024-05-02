class 3Sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int j = nums.length-2;
        int k = nums.length-1;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0 ; i < nums.length; i++){
            if(i == 0 || (i > 0 && (nums[i] != nums[i-1]))){
                int target = 0 - nums[i];
                int left = i + 1;
                int right = nums.length - 1;
                while(left < right){
                    if(nums[left]+nums[right] == target){
                        List<Integer> x = new ArrayList<Integer>();
                        x.add(nums[i]);
                        x.add(nums[left]);
                        x.add(nums[right]);
                        result.add(x);
                        while(left < right && nums[left] == nums[left+1]){
                            left++;
                        }
                        while(left < right && nums[right] == nums[right-1]){
                            right--;
                        }
                        left++;
                        right--;
                    }
                    else if(nums[left] + nums[right] > target){
                        right--;
                    }
                    else{
                        left++;
                    }
                }
            }
        }


//         for(int i = 0; i < nums.length; i++){
//            if(nums[i] < nums[j]+nums[k]){
//             i++;
//            }
//            while(nums[k]>=0 && k>j){
//             if(j==i){
//                 k--;
//                 j = k-1;
//   }
//            if(nums[i]+nums[j]+nums[k] == 0){
//               x.add(nums[i]);
//               x.add(nums[j]);
//               x.add(nums[k]);
//               result.add(x);
//            }
//            else{
//             j--;
//            }
//            }
//         }
        //     for(int i = 0; i< nums.length; i++){
        //     while(j!=nums.length){
        //     while(i<j && i<k && j<k){
        //     if(nums[i]+nums[j]+nums[k] == 0){
        //
        //     }else{
        //         k++;
        //     }
        //     }
        //     }
        // }

        return result;
    }
}