pipeline {
    agent any
    stages {
        stage('Build') { 
            steps {
		sh"
		echo $BUILD_NUMBER
                echo $BUILD_ID
                echo $BUILD_DISPLAY_NAME
                echo $JOB_NAME
                echo $JOB_BASE_NAME
                echo $BUILD_TAG
                echo $EXECUTOR_NUMBER
                echo $NODE_NAME
                echo $NODE_LABELS
                echo $WORKSPACE
                echo $JENKINS_HOME
                echo $JENKINS_URL
                echo $BUILD_URL
                echo $JOB_URL
		"
              	sh "docker run -u root -v /home/jjcquintero/v2JenkinsData/workspace/TestZAP:/zap/wrk:rw -t owasp/zap2docker-weekly zap-baseline.py -t https://www.example.com -g gen.conf -r jj2.html || true"
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
            reportFiles: '/var/jenkins_home/workspace/TestZAP/jj2.html',
            reportName: 'RCov Report'
          ]
        }
    }

}

