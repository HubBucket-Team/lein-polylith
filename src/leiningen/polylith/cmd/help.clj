(ns leiningen.polylith.cmd.help
  (:require [leiningen.polylith.version :as v]
            [leiningen.polylith.cmd.help.add :as add]
            [leiningen.polylith.cmd.help.build :as build]
            [leiningen.polylith.cmd.help.changes :as changes]
            [leiningen.polylith.cmd.help.compile :as compile]
            [leiningen.polylith.cmd.help.create :as create]
            [leiningen.polylith.cmd.help.deps :as deps]
            [leiningen.polylith.cmd.help.diff :as diff]
            [leiningen.polylith.cmd.help.info :as info]
            [leiningen.polylith.cmd.help.settings :as settings]
            [leiningen.polylith.cmd.help.test :as test-cmd]))

(defn help []
  (println (str "Polylith " v/version " (" v/date ") - https://github.com/tengstrand/polylith"))
  (println)
  (println "  lein polylith CMD [ARGS]  - where CMD [ARGS] are:")
  (println)
  (println "    add C S              Adds a component to a system.")
  (println "    build N [A]          Build changed systems and create artifacts.")
  (println "    changes E [A]        List changed components, bases and systems.")
  (println "    compile [A]          Compile changed components, bases and systems.")
  (println "    create X N [A]       Creates component or workspace.")
  (println "    deps [f]             List dependencies.")
  (println "    diff [A] [F]         List all changes since a specific point in time.")
  (println "    info [A]             List interfaces, components, bases and systems.")
  (println "    settings             The polylith settings in current project.clj.")
  (println "    test [A]             Execute tests in changed components and bases.")
  (println)
  (println "  lein polylith [help]        Show this help.")
  (println "  lein polylith help CMD      Show help for a specific command.")
  (println "  lein polylith help project  Show valid project.clj settings.")
  (println)
  (println "  Examples:")
  (println "    lein polylith add mycomponent mysystem")
  (println "    lein polylith build")
  (println "    lein polylith build 1523649477000")
  (println "    lein polylith build mybookmark")
  (println "    lein polylith changes b")
  (println "    lein polylith changes c 1523649477000")
  (println "    lein polylith changes s mybookmark")
  (println "    lein polylith compile")
  (println "    lein polylith compile 1523649477000")
  (println "    lein polylith compile mybookmark")
  (println "    lein polylith create c mycomponent")
  (println "    lein polylith create c mycomponent myinterface")
  (println "    lein polylith create s mysystem")
  (println "    lein polylith create s mysystem mybase")
  (println "    lein polylith create w myworkspace com.my.company")
  (println "    lein polylith deps")
  (println "    lein polylith deps f")
  (println "    lein polylith diff")
  (println "    lein polylith diff 1523649477000")
  (println "    lein polylith diff mybookmark")
  (println "    lein polylith diff mybookmark +")
  (println "    lein polylith help info")
  (println "    lein polylith info")
  (println "    lein polylith info 1523649477000")
  (println "    lein polylith info mybookmark")
  (println "    lein polylith settings")
  (println "    lein polylith test")
  (println "    lein polylith test 1523649477000")
  (println "    lein polylith test mybookmark"))

(defn project []
  (println "  These are the valid settings of the :polylith section in the developments")
  (println "  project.clj file (the main development project if having more than one):")
  (println)
  (println "    :top-namespace x           x is the name of the top namespace. This namespaces is added")
  (println "                               to the interfaces project.clj and each component project.clj")
  (println "                               file (to add the correct Maven artifact namespace).")
  (println)
  (println "    :clojure-version x         x is the version of clojure used when creating components.")
  (println)
  (println "  Example of project.clj:")
  (println "    (defproject ...")
  (println "      ...")
  (println "      :polylith {:top-namespace \"com.mycompany\"")
  (println "                 :clojure-version \"1.9.0\"}")
  (println "      ...")
  (println "    )"))

(defn execute [[cmd]]
  (condp = cmd
    "add" (add/help)
    "build" (build/help)
    "changes" (changes/help)
    "compile" (compile/help)
    "create" (create/help)
    "deps" (deps/help)
    "diff" (diff/help)
    "info" (info/help)
    "project" (project)
    "settings" (settings/help)
    "test" (test-cmd/help)
    (help)))
