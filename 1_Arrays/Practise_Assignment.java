package DSA_java.Arrays;

public class Practise_Assignment {

  public static boolean question_1(int nums[]) {
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] == nums[j]) {
          return true;

        }
        break;
      }

    }
    return false;
  }

  public static void main(String[] args) {
    int nums[] = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
    System.out.println(question_1(nums));
  }
}
