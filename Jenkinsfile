pipeline {
    agent any
    stages {
        stage('Build') { 
            steps {
		sshagent(['zap-ssh']){
                	sh 'ssh jjcquintero@192.168.1.170 "touch /home/jjcquintero/pruebaDGI"'
		} 
  	    }
        }
    }
}

