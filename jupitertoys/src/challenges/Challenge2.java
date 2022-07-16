package challenges;

public class Challenge2 {
	
    public static void main(String[] args) {
        String s="Character";
        System.out.println("Most occurring character is " + maxOccuringChar(s));

    }

	public static char maxOccuringChar(String s) {
	
		int ascii=256;
		int count[]=new int[ascii];
		int length=s.length();
		int max=-1;
		char result=0;
		s=s.toLowerCase();

		for(int i=0; i<length; i++) {
			count[s.charAt(i)]++;
		}
		
		for(int i=0; i<length; i++) {
			if(max<count[s.charAt(i)]) {
				max=count[s.charAt(i)];
				result=s.charAt(i);
			}
		}
		return result;	
	}
}