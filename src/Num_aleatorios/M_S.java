/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Num_aleatorios;

import java.io.IOException;
import javax.script.ScriptException;
import javax.swing.JTextArea;

/**
 *
 * @author Ccast
 */
public class M_S {

    private Double x0;
    private Double u;
    private int n;
    private String f_x;
    private String f_y;
    private MathJS engine;

    public M_S() throws ScriptException, IOException {
        this.x0 = 0.0;
        this.u = 0.0;
        this.n = 0;
        this.f_x = "";
        this.f_y = "";
        this.engine = new MathJS();
    }

    public void getNumbers(Double x0, int n, String f1, String f2, JTextArea XR, JTextArea UR) throws ScriptException {
        this.x0 = x0;
        this.n = n;
        this.f_x = f1;
        this.f_y = f2;
        XR.setText("X0: " + x0 + "\n");
        UR.setText("\n");

        for (int i = 0; i < n; i++) {
            engine.put("x = " + x0);
            x0 = Double.parseDouble(engine.put(f1));
            XR.setText(XR.getText() + "X" + (i + 1) + ": " + x0 + "\n");

            engine.put("x = " + x0);
            u = Double.parseDouble(engine.put(f2));
            UR.setText(UR.getText() + "U" + (i + 1) + ": " + u + "\n");
        }
    }

}
