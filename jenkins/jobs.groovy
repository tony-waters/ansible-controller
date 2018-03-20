pipelineJob('pingchecks') {
    definition {
        triggers {
            cron('*/2 * * * *')
        }
        cps {
            concurrentBuild(false)
            sandbox()
            script("""
                node {
                  stage('Run Pingchecks') {
                        sh '''
                            docker run --rm -v app-data:/root/roles/pingcheck/json ansible_controller ping.yml
                        '''
                  }
                }
              """.stripIndent()
            )
        }
    }
}
