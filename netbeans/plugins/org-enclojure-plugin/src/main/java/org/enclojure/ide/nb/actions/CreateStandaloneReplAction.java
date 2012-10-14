/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.enclojure.ide.nb.actions;

import clojure.lang.IFn;
import clojure.lang.RT;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.util.Exceptions;

public final class CreateStandaloneReplAction implements ActionListener {
    static {
        SourceLoader.loadReplWin();
    }
    IFn startNonProjectREPLFn = RT.var("org.enclojure.ide.nb.editor.repl-win","start-stand-alone-repl-action");

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            startNonProjectREPLFn.invoke(e);
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}
