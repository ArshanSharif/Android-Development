
import java.io.*;
import java.util.*;

public class LeetCode {
    //Leet code #13
    public int romanToInt(String s) {

        HashMap<Character,Integer> roman = new HashMap<>();
        roman.put('I',1);
        roman.put('V',5);
        roman.put('X',10);
        roman.put('L',50);
        roman.put('C',100);
        roman.put('D',500);
        roman.put('M',1000);
        int sum =roman.get(s.charAt(s.length()-1));

        for(int i =(s.length())-2;i>=0;i--){
            if(roman.get(s.charAt(i+1)) <= roman.get(s.charAt(i))){
                sum+=roman.get(s.charAt(i));


            }
            else{
                sum -= roman.get(s.charAt(i));
            }

        }
        return sum;
    }
    //LeetCode #1
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i =0; i<nums.length;i++){
            int pair = target - nums[i];
            if(map.containsKey(pair)){
                return new int[]{map.get(pair),i};

            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("no match found");
    }
    //LeetCode # 9
    public boolean isPalindrome(int x) {

        String reverse_int = new StringBuilder(Integer.toString(x)).reverse().toString();
        if(reverse_int.equals(Integer.toString(x))){
            return true;
        }
        else{
            return false;
        }
    }
    //LeetCode #14
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        int count = 0;
        boolean switch1 = true;
        String temp = "";
        while (switch1){

            try{
                for(int i = 0;i<strs.length;i++){
                    temp += strs[i].charAt(count);
                }
            }
            catch(Exception e){
                return prefix;
            }


            if(temp.equals(Character.toString(strs[0].charAt(count)).repeat(strs.length))){
                prefix +=strs[0].charAt(count);
                temp = "";
            }
            else{
                return prefix;
            }




            count+=1;
        }



        return prefix;
    }
    //LeetCode #20
    public boolean isValid(String s) {
        Stack<Character> left = new Stack<Character>();
        for(char c:s.toCharArray()){
            if (c=='(' || c=='{' || c == '['){
                left.add(c);
            }
            else if(c==')'  && !left.isEmpty() &&  left.peek() == '('){
                left.pop();

            }
            else if(c=='}' && !left.isEmpty() &&  left.peek() == '{' ){
                left.pop();

            }
            else if(c==']' && !left.isEmpty() &&  left.peek() == '[' ){
                left.pop();

            }
            else{
                return false;
            }
        }
        return left.isEmpty();
    }
    //LeetCode #21
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode(0);
        ListNode curr = temp;

        while(list1 !=null && list2!=null){
            if(list1.val < list2.val){
                curr.next = list1;
                list1 = list1.next;
            }
            else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if(list1 !=null){
            curr.next = list1;
            list1 = list1.next;
        }
        if(list2 !=null){
            curr.next = list2;
            list2 = list2.next;
        }
        return temp.next;
    }
}


