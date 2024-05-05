//Kyle Morgan
//This code just loops over a for function and takes the input of THEBLIG and prints to two levels of numbers, THEBLIG x,y

public class SectionNumbers {
    public static void main(String[] args) {
        sections("THERBLIG", 2);
    }

    public static void sections(String prefix, int levels) {
        if (levels == 0) {
            System.out.println(prefix); // print the prefix once stop the function
        } else {
            for (int i = 1; i <= 3; i++) { // loop over 1 to 3
                String newPrefix = prefix + i + "."; // create a new prefix = prefix + level+.
                sections(newPrefix, levels - 1); // recursive call with the new prefix and levels - 1
            }
        }
    }
}