import com.praqma.jobdsl.JobSpecification

def buildJobs = JobSpecification.fromConfig(this.getClass().getResource("productionJobsList.groovy"))

buildJobs.each { buildJob ->
    job("${buildJob.jobName}") {
        description("This is the description for the $it.name job")
        scm {
            git(buildJob.url)
        }
        wrappers {
            environmentVariables {
                env("MSB_OPTIONS", buildJob.msBuildOptions.collect { "/property:${it.key}=${it.value}" }.join(" "))
            }
        }
        steps {
            batchFile("build.bat")
        }
    }
}
