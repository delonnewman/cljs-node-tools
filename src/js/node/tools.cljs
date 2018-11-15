(ns js.node.tools
  (:require ["fs" :as fs]
            ["path" :as path]
            ["child_process" :as cp]))

(defn file-exists?
  "Tests if a file exists"
  [path]
  (.exitsSsync fs path))

(defn mkdir [path]
  (.mkdir fs path))

(defn sh
  "Execute a shell command"
  [cmd & args]
  (.execSync cp cmd (into-array args)))

(defn exec [cmd & args]
  (.spawnSync cp cmd (into-array args)))

(def
  ^{:doc "An alias for process.abort() on Node.js"
    :platforms #{:nodejs}
    :added "1.0"}
  abort (.-abort js/process))

(def
  ^{:doc "An alias for process.chdir() on Node.js"
    :arglists '([directory])
    :platforms #{:nodejs}
    :added "1.0"}
  chdir (.-chdir js/process))

(def
  ^{:doc "An alias for process.cwd() on Node.js"
    :arglists '([])
    :platforms #{:nodejs}
    :added "1.0"}
  cwd (.-cwd js/process))

(def
  ^{:doc "An alias for process.exit() on Node.js"
    :arglists '([] [code])
    :platforms #{:nodejs}
    :added "1.0"}
  exit (.-exit js/process))

; TODO: make promisify function, and maybe our own Promise implementation

(defn slurp
  "Read entire contents of `file` to a string"
  ^{:added "1.0"}
  [file & opts]
  (.readFileSync fs file))

(defn spit
  "Write `data` to `file`. Data can be a String, Buffer, or Uint8Array."
  ^{:added "1.0"}
  [file data]
  (.writeFileSync fs file data))

(def
  ^{:doc "An alias for path.basename() on Node.js"
    :arglists '([path] [path ext])
    :platforms #{:nodejs}
    :added "1.0"}
  basename (.-basename path))

(def
  ^{:doc "An alias for path.dirname() on Node.js"
    :arglists '([path] [path ext])
    :platforms #{:nodejs}
    :added "1.0"}
  dirname (.-dirname path))

(def
  ^{:doc "An alias for path.extname() on Node.js"
    :arglists '([path] [path ext])
    :platforms #{:nodejs}
    :added "1.0"}
  extname (.-extname path))
