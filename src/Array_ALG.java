public class Array_ALG {
    public static void main(String[] args) {

    }

    /*
    1.旋转数组
    给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
    示例 1:

    输入: [1,2,3,4,5,6,7] 和 k = 3
    输出: [5,6,7,1,2,3,4]
    解释:
    向右旋转 1 步: [7,1,2,3,4,5,6]
    向右旋转 2 步: [6,7,1,2,3,4,5]
    向右旋转 3 步: [5,6,7,1,2,3,4]
     */
    //原地逆转法
    public void rotate(int[] nums, int k) {
        //判断k，当k大于nums.length时，取余数
        k=k%nums.length;

        int tmp = 0;
        //逆转数组
        for (int i = 0; i <= nums.length - 1 - i; i++) {
            tmp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = tmp;
        }
      //逆转前k个
        for (int i = 0; i <= k - i - 1; i++) {
            tmp = nums[i];
            nums[i] = nums[k - 1 - i];
            nums[k - i - 1] = tmp;

        }
       //逆置k个之后的
        for (int i = 0; k + i <= nums.length - 1 - i; i++) {
            tmp = nums[k + i];
            nums[k + i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = tmp;
        }
    }

    //移动法,从后向前移动
    public void rotate2(int[] nums, int k)
    {
        //判断k，当k大于nums.length时，取余数
        k=k%nums.length;
        int tmp = 0;
        
        //循环移动k轮
        for (int i = 0; i < k ; i++) {
            //取出最后一个值
             tmp=nums[nums.length-1];
             //所有数向后移送一个单位
            for (int j = nums.length - 1; j >0; j--) {
                nums[j]=nums[j-1];
            }
            //给第一个元素赋值
            nums[0]=tmp;

        }
    }

    /*
    2.取唯一数值
    给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
    说明：
    你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
    示例 2:
    输入: [4,1,2,1,2]
    输出: 4
    考察逻辑运算符的使用
     */
    public int singleNumber(int[] nums) {


        int result=nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            result =result^nums[i];
        }
        return  result;
    }
}
