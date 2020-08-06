load("@rules_jvm_external//:defs.bzl", "maven_install")

def maven_deps(ns, artifact):
    maven_install(
        name = ns,
        artifacts = [
            artifact
        ],
        repositories = [
            "https://jcenter.bintray.com/",
            "https://repo1.maven.org/maven2",
        ],
        fetch_sources = True,
    )