pipeline {
    agent none

    stages {
        stage('Sonarqube') {
            environment {
                scannerHome = tool 'SonarQubeScannerTFM'
            }
            steps {
                withSonarQubeEnv('sonarqube') {
                    sh "${scannerHome}/bin/sonar-scanner"
                }
                timeout(time: 10, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }
}


