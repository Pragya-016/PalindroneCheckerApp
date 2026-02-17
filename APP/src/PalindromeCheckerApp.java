public class PalindromeCheckerApp {
    public static void main(String[] args){
        System.out.println("Welcome to palindrome checker app management system");
        String input="madam";
        boolean isPalindrome=true;
        for(int i=0;i<input.length()/2;i++){
             if(input.charAt(i)!=input.charAt(input.length()-1-i)){
                 isPalindrome=false;
                 break;
             }
         }
        if(isPalindrome){
            System.out.println("it is a palindrome");
        }else{
            System.out.println("not a palindrome");
        }
    }
}
