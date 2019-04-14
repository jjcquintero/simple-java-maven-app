pipeline {
    agent any
    stages {
        stage('Build') { 
            steps {
                sh "echo BUILD_NUMBER  $BUILD_NUMBER"
                sh "echo BUILD_ID  $BUILD_ID"
                sh "echo BUILD_DISPLAY_NAME  $BUILD_DISPLAY_NAME"
                sh "echo JOB_NAME  $JOB_NAME"
                sh "echo JOB_BASE_NAME  $JOB_BASE_NAME"
                sh "echo BUILD_TAG  $BUILD_TAG"
                sh "echo EXECUTOR_NUMBER  $EXECUTOR_NUMBER"
                sh "echo NODE_NAME  $NODE_NAME"
                sh "echo NODE_LABELS  $NODE_LABELS"
                sh "echo WORKSPACE  $WORKSPACE"
                sh "echo JENKINS_HOME  $JENKINS_HOME"
                sh "echo JENKINS_URL  $JENKINS_URL"
                sh "echo BUILD_URL  $BUILD_URL"
                sh "echo JOB_URL  $JOB_URL"
              	sh "docker run -u root -v $JENKINS_HOME/jobs/$JOB_NAME/$BUILD_NUMBER:/zap/wrk:rw -t owasp/zap2docker-weekly zap-baseline.py -t https://www.example.com -g gen.conf -r jj2.html || true"
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

