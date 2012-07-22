class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?" {
            constraints {
            }
        }

        "/preUpload"(controller: "file", action: "preUpload")

        "/"(view: "/listUplodFile", controller: "file", action: "index")

        "500"(view: '/error')
    }
}
