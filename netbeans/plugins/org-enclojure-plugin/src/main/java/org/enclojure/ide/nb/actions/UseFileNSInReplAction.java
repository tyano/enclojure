/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.enclojure.ide.nb.actions;

import org.openide.cookies.EditorCookie;
import org.openide.nodes.Node;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;
import org.openide.util.actions.CookieAction;
import clojure.lang.RT;
import clojure.lang.Var;
import org.openide.util.Exceptions;

public final class UseFileNSInReplAction extends CookieAction {

    static {
        SourceLoader.loadActionHandler();
    }

    static final Var loadNamespaceFn = RT.var("org.enclojure.ide.nb.actions.action-handler", "require-file-ns-action");

    @Override
    protected void performAction(Node[] activatedNodes) {
        try {
            loadNamespaceFn.invoke(activatedNodes);
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    @Override
    protected int mode() {
        return CookieAction.MODE_EXACTLY_ONE;
    }

    @Override
    public String getName() {
        return NbBundle.getMessage(ChangeReplNamespaceAction.class, "CTL_UseFileNSInReplAction");
    }

    @Override
    protected Class[] cookieClasses() {
        return new Class<?>[]{EditorCookie.class};
    }

    @Override
    protected void initialize() {
        super.initialize();
        // see org.openide.util.actions.SystemAction.iconResource() Javadoc for more details
        putValue("noIconInMenu", Boolean.TRUE);
    }

    @Override
    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }

    @Override
    protected boolean asynchronous() {
        return false;
    }
}

