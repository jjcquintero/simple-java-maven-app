pipeline {
    agent any
    stages {
        stage('Build') { 
            steps {
		sshagent(['zap-ssh'){
                	sh "(cd /home/jjcquintero/v2JenkinsData/workspace/TestZAP && docker run -u root -v /var/jenkins_home/workspace/PipelineTFM/Report:/zap/wrk:rw -t owasp/zap2docker-weekly zap-baseline.py -t https://www.example.com -g gen.conf -r jj2.html) || true"
		} 
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
            reportFiles: 'jj2.html',
            reportName: 'RCov Report'
          ]
        }
    }
}

