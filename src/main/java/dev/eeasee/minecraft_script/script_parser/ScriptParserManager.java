package dev.eeasee.minecraft_script.script_parser;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ScriptParserManager {
    public static void tryRunScript() {
        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("JavaScript");
        /*
        try {
            scriptEngine.eval(new FileReader("mscripts/test.mcs.js"));
        } catch (ScriptException | FileNotFoundException e) {
            e.printStackTrace();
        }

         */

        try {
            String script = ScriptInterpreter.handleScriptFile(new FileReader("mscripts/test.mcs.js"));
            System.out.println(script);
            System.out.println("==============");
            scriptEngine.eval(script);
        } catch (FileNotFoundException | ScriptException e) {
            e.printStackTrace();
        }
    }
}
