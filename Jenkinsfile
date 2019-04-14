pipeline {
    agent any
    stages {
        stage('Build') { 
            steps {
              	sh "ssh jjcquintero@192.168.1.170 \"docker run -u root -v /home/jjcquintero/v2JenkinsData/jobs/$JOB_NAME/builds/$BUILD_NUMBER/htmlreports/OWASP_20ZAP:/zap/wrk:rw -t owasp/zap2docker-weekly zap-baseline.py -t https://www.example.com -g gen.conf -r owaspzap.html\" || true"
  	    }
        }
    }

    post {
        always {

	    publishHTML target: [
            allowMissing: false,
            alwaysLinkToLastBuild: false,
            keepAll: true,
            reportDir: '$JENKINS_HOME/jobs/$JOB_NAME/builds/$BUILD_NUMBER',
            reportFiles: 'owaspzap.html',
            reportName: 'OWASP ZAP'
          ]
        }
    }

}

