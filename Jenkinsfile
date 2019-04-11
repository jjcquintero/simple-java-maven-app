pipeline {
    agent any
    stages {
        stage('Build') { 
            steps {
                sh "docker run -u root -v /var/jenkins_home/workspace/PipelineTFM/ZAP:/zap/wrk:rw -t owasp/zap2docker-weekly zap-baseline.py -t https://www.example.com -g gen.conf -r testreport.html"
		sh "find . "
  	    }
        }
    }
    post {
        always {

	    publishHTML target: [
            allowMissing: false,
            alwaysLinkToLastBuild: false,
            keepAll: true,
            reportDir: 'Report',
            reportFiles: 'jj.html',
            reportName: 'RCov Report'
          ]
        }
    }
}

