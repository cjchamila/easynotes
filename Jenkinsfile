pipeline {
    agent any 
    stages {
        stage('Build') { 
           steps {
               withMaven(maven : 'Maven-3.6.3') {
				bat'mvn clean compile'
            }
        }
        }
        stage('Test') { 
			            steps {
			withMaven(maven : 'Maven-3.6.3') {
			bat'mvn install'
			}
			}
               
            }
        
	stage('Deploy') {
            when {
              expression {
                currentBuild.result == null || currentBuild.result == 'SUCCESS' 
              }
            }
            
        }
            }
            
}

