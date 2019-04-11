pipeline {
    agent any
    stages {
        stage('Build') { 
            steps {
		sh "find . | grep -i testreport.html"
                sh "docker run -u root -v /var/jenkins_home/workspace/PipelineTFM/ZAP:/zap/wrk:rw -t owasp/zap2docker-weekly zap-baseline.py -t https://www.example.com -g gen.conf -r testreport.html" 
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

