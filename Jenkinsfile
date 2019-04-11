pipeline {
    agent any
    stages {
        stage('Build') { 
            steps {
                docker run -v /var/jenkins/home/simple-java-maven-app/ZAP:/zap/wrk -t owasp/zap2docker-weekly zap-baseline.py -t https://www.example.com -g gen.conf -r testreport.html
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

