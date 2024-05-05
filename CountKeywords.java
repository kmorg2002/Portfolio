//Kyle Morgan
//This code counts keywords that are not in comments or string.
//However this code does not double count keywords. I changed the list to set to avoid this.

import java.util.*;
import java.io.*;

public class CountKeywords {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Java source file (e.g. src/CountKeywords.java): ");
        String filename = input.nextLine();
        input.close();

        File file = new File(filename);
        if (file.exists()) {
            System.out.println("The number of keywords in " + filename + " is " + countKeywords(file));
        } else {
            System.out.println("File " + filename + " does not exist");
        }
    }

    public static int countKeywords(File file) throws Exception {
        String[] keywordString = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class",
                "const", "continue", "default", "do", "double", "else", "enum", "extends", "for", "final", "finally",
                "float", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native",
                "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super",
                "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while",
                "true", "false", "null"};
        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
        Set<String> countedKeywords = new HashSet<>();

        try (Scanner input = new Scanner(file)) {
            String content = input.useDelimiter("\\A").next();
            content = content.replaceAll("//.*|(\"(?:\\\\[^\"]|\\\\\"|.)*?\")|(?s)/\\*.*?\\*/", "");

            try (Scanner contentScanner = new Scanner(content)) {
                while (contentScanner.hasNext()) {
                    String word = contentScanner.next();
                    if (keywordSet.contains(word)) {
                        countedKeywords.add(word);
                    }
                }
            }
        }
        return countedKeywords.size();
    }
}