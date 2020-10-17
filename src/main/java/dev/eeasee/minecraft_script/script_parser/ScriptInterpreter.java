package dev.eeasee.minecraft_script.script_parser;

import org.jetbrains.annotations.NotNull;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ScriptInterpreter {

    private static final char[] addedChars = "print(\"ADDED\");\n".toCharArray();

    public static String handleScriptFile(Reader scriptSource) {
        char[] sourceChars;
        try {
            sourceChars = reader2Chars(scriptSource);
        } catch (IOException e) {
            e.printStackTrace();
            sourceChars = new char[0];
        }
        char[] target = new char[addedChars.length + sourceChars.length];
        System.arraycopy(addedChars, 0, target, 0, addedChars.length);
        System.arraycopy(sourceChars, 0, target, addedChars.length, sourceChars.length);
        return new String(target);
    }

    private static char[] reader2Chars(Reader reader) throws IOException {
        char[] arr = new char[8192];
        StringBuilder sb = new StringBuilder();

        int numChars;
        try (Reader closableReader = reader) {
            while ((numChars = closableReader.read(arr, 0, arr.length)) > 0) {
                sb.append(arr, 0, numChars);
            }
        }

        return sb.toString().toCharArray();
    }

}
