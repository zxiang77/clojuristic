load("@rules_java//java:defs.bzl", "java_binary")

java_binary(
    name = "MainEntry",
    srcs = ["MainEntry.java"],
    main_class = "src.main.MainEntry",
    deps = [
        "@maven//:com_google_inject_guice",
        "@netty_deps//:io_netty_netty_all",
        "@maven//:org_mongodb_mongodb_driver",
        "@javax//:javax_inject_javax_inject",
        "@graphql//:com_graphql_java_graphql_java"
    ],
)
# maven term: group:artifact:version, and  it will be converted to be delimited by _