
(ns app.config )

(def cdn?
  (cond
    (exists? js/window) false
    (exists? js/process) (= "true" js/process.env.cdn)
    :else false))

(def dev?
  (let [debug? (do ^boolean js/goog.DEBUG)]
    (cond
      (exists? js/window) debug?
      (exists? js/process) (not= "true" js/process.env.release)
      :else true)))

(def site
  {:dev-ui "http://localhost:8100/main-fonts.css",
   :release-ui "http://cdn.tiye.me/favored-fonts/main-fonts.css",
   :cdn-url "http://cdn.tiye.me/locales-picker/",
   :cdn-folder "tiye.me:cdn/locales-picker",
   :title "Locales",
   :icon "http://cdn.tiye.me/logo/respo.png",
   :storage-key "locales-picker",
   :upload-folder "tiye.me:repo/chenyong/locales-picker/"})
