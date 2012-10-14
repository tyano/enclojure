/*
*******************************************************************************
*    Copyright (c) Tsutomu YANO. All rights reserved.
*    The use and distribution terms for this software are covered by the
*    GNU General Public License, version 2
*    (http://www.gnu.org/licenses/old-licenses/gpl-2.0.html) with classpath
*    exception (http://www.gnu.org/software/classpath/license.html)
*    which can be found in the file GPL-2.0+ClasspathException.txt at the root
*    of this distribution.
*    By using this software in any fashion, you are agreeing to be bound by
*    the terms of this license.
*    You must not remove this notice, or any other, from this software.
*******************************************************************************
*    Author: Tsutomu YANO
*******************************************************************************
*/
package org.enclojure.ide.nb.actions;

import clojure.lang.RT;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Tsutomu YANO
 */
public final class SourceLoader {
    private static final Set<String> loadedSet = new HashSet<String>();

    private SourceLoader() {
    }

    public static void loadClojureCore() {
        load("clojure/core.clj");
    }

    public static void loadActionHandler() {
        load("org/enclojure/ide/nb/actions/action_handler.clj");
    }

    public static void loadTokenNav() {
        load("org/enclojure/ide/navigator/token_nav.clj");
    }

    public static void loadReplWin() {
        load("org/enclojure/ide/nb/editor/repl_win.clj");
    }

    public static void loadJdi() {
        load("org/enclojure/ide/debugger/jdi.clj");
    }

    public static void loadJdiEval() {
        load("org/enclojure/ide/debugger/jdi_eval.clj");
    }

    public static void loadNavigatorPanel() {
        load("org/enclojure/ide/navigator/views/navigator_panel.clj");
    }

    public static void loadSettingsUtils() {
        load("org/enclojure/ide/settings/utils.clj");
    }

    public static void loadCljComment() {
        load("org/enclojure/ide/nb/actions/CljComment.clj");
    }

    public static void loadProjectCreate() {
        load("org/enclojure/ide/nb/clojure/project/create.clj");
    }

    public static void loadFoldingManager() {
        load("org/enclojure/ide/nb/editor/folding/manager.clj");
    }

    public static void loadDataObjectListener() {
        load("org/enclojure/ide/nb/editor/data_object_listener.clj");
    }

    public static void loadHyperLinks() {
        load("org/enclojure/ide/nb/editor/hyperlinks.clj");
    }

    public static void loadClassPathsListener() {
        load("org/enclojure/ide/nb/classpaths/listeners.clj");
    }

    public static void loadReplManager() {
        load("org/enclojure/ide/repl/repl_manager.clj");
    }

    public static void loadCompletionTask() {
        load("org/enclojure/ide/nb/editor/completion/completion_task.clj");
    }

    public static void loadCompletionProvider() {
        load("org/enclojure/ide/nb/editor/completion/completion_provider.clj");
    }

    public static void loadCljCodeCompletion() {
        load("org/enclojure/ide/nb/editor/completion/cljcodecompletion.clj");
    }

    public static void loadClassPathUtils() {
        load("org/enclojure/ide/common/classpath_utils.clj");
    }

    public static void loadAddFile() {
        load("org/enclojure/ide/nb/source/add_file.clj");
    }

    public static void loadEnclojureOptionsCategory() {
        load("org/enclojure/ide/preferences/enclojure_options_category.clj");
    }

    public static void loadPlatformOptions() {
        load("org/enclojure/ide/preferences/platform_options.clj");
    }

    private static void load(String path) {
        assert path != null;
        assert !path.isEmpty();

        if(!loadedSet.contains(path)) {
            try {
                RT.loadResourceScript(path);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            loadedSet.add(path);
        }
    }
}
