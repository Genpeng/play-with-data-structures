package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * A utility class about file operations.
 *
 * @author  Genpeng Xu
 * @date    2018/09/19
 */
public class FileUtil {
    /**
     * The encoding type
     */
    private static final String ENCODING = "UTF-8";

    /**
     * Return all the words in the file whose directory is {@code pathname}.
     *
     * @param pathname String, the directory of the file
     * @return a list of strings, all the words in the file
     */
    public static List<String> getAllWords(String pathname) {
        if (pathname == null) {
            throw new NullPointerException("The pathname of the file is null!!!");
        }

        return getAllWords(new File(pathname));
    }

    /**
     * Sequentially return all the words in the file.
     *
     * @param file File, the file to get
     * @return a list of strings, all the words in the file
     */
    public static List<String> getAllWords(File file) {
        List<String> words = new ArrayList<>();

        Scanner scanner = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            scanner = new Scanner(new BufferedInputStream(fis), ENCODING);
            scanner.useLocale(Locale.ENGLISH);

            if (scanner.hasNextLine()) {
                String contents = scanner.useDelimiter("\\A").next();

                int start = firstCharacterIndex(contents, 0);
                for (int i = start + 1; i <= contents.length(); ) {
                    if (i == contents.length() || !Character.isLetter(contents.charAt(i))) {
                        String word = contents.substring(start, i).toLowerCase();
                        words.add(word);
                        start = firstCharacterIndex(contents, i);
                        i = start + 1;
                    } else {
                        i++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist or the path is not correct!!!");
            System.exit(-1);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        return words;
    }

    /**
     * Return the first character starting from {@code start} in the string {@code s}.
     *
     * @param s     String, the string to search
     * @param start int, the start index
     * @return int, the index of that character
     */
    private static int firstCharacterIndex(String s, int start) {
        for (int i = start; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                return i;
            }
        }
        return s.length();
    }
}