pipeline {
    agent {
        docker {
            image 'sonarqube' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
    stages {
        stage('SonarQube analysis') {
            steps {
                // requires SonarQube Scanner for Maven 3.2+
                sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar'
            }
        }
        stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package' 
            }
        }
    }
}

