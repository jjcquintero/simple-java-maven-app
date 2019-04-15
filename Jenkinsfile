pipeline {
    agent any
    stages {
        stage('Build') { 
            steps {
		sh "docker rm zapcontainer"
		sh "docker run --name zapcontainer -u root -v $PWD:/zap/wrk -t owasp/zap2docker-weekly zap-baseline.py -t  https://www.forocoches.com/ -g gen.conf -r owaspzap.html || true"
		sh "docker cp zapcontainer:/zap/wrk/owaspzap.html /$JENKINS_HOME/jobs/$JOB_NAME/builds/$BUILD_NUMBER/htmlreports/OWASP_20ZAP"
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

