BuildSrc {
    solutionPath = "MyProduct.sln"
    buildMode = "Debug"
    msBuildOptions = [Configuration: "x86"]
    url = "git@github.com:MyOrg/MyProduct.git"
}

BuildTest {
    solutionPath = "MyProductTest.sln"
    buildMode = "Debug"
    msBuildOptions = [Configuration: "x86"]
    url = "git@github.com:MyOrg/MyProduct.git"
}