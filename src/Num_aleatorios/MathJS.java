/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Num_aleatorios;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author Hasty
 */
public class MathJS {
    protected static String MATHJS_URL  
            = "http://cdnjs.cloudflare.com/ajax/libs/mathjs/1.0.1/math.js";

    protected ScriptEngine engine;

    public MathJS() throws MalformedURLException, ScriptException, IOException {
        ScriptEngineManager manager = new ScriptEngineManager();
        engine = manager.getEngineByName("js");

        engine.eval(new InputStreamReader(new URL(MATHJS_URL).openStream()));
        engine.eval("var parser = math.parser();");
        engine.eval("var precision = 14;");
        
    }

    public String put(String expr) throws ScriptException {
        String script = "math.format(parser.eval('" + expr + "'), precision);";
        return (String) engine.eval(script);
    }
}
