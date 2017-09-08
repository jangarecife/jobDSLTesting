package com.praqma.jobdsl

class JobSpecification {

    String jobName
    String solutionPath
    String buildMode
    Map msBuildOptions

    static def fromConfig(URL file) {
        def jobs = []
        def cfg = new ConfigSlurper().parse(file)
        cfg.each { jn, jc ->
            jobs << new JobSpecification(solutionPath: jc.solutionPath, buildMode: jc.buildMode, msBuildOptions: jc.msBuildOptions, jobName: jn)
        }
        return jobs
    }
}
