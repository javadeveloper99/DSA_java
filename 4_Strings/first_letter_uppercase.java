public class first_letter_uppercase {
  public static StringBuilder toUppercase(String str){
    StringBuilder sb=new StringBuilder();
    char ch = Character.toUpperCase(str.charAt(0));
    sb.append(ch);

    for(int i=1;i<str.length();i++){
      if (i<str.length()-1 && str.charAt(i)==' ') {
          sb.append(str.charAt(i));
          i++;
          sb.append(Character.toUpperCase(str.charAt(i)));
      }else{
        sb.append(str.charAt(i));
      }

    }
    return sb;
}
  public static void main(String[] args) {
    String str="hi, my name is vivek!";
    System.out.println(toUppercase(str));
  }
}
