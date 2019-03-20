pipeline {
    agent {
        docker {
            image 'sonarqube' 
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

