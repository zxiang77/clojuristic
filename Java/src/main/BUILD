load("@rules_java//java:defs.bzl", "java_binary")

java_binary(
    name = "MainEntry",
    srcs = ["MainEntry.java"],
    main_class = "src.main.MainEntry",
    deps = [
        "@maven//:com_google_inject_guice",
        "@maven//:io_netty_netty_all"
    ],
)
# maven term: group:artifact:version, and  it will be converted to be delimited by _