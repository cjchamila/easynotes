pipeline {
    agent any 
    stages {
        stage('Build') { 
        echo 'Build stage'
           steps {
               withMaven(maven : 'Maven-3.6.3') {
				bat'mvn clean compile'
            }
        }
        } 
        stage('Test') {  
        echo 'Test stage'
		steps {
			withMaven(maven : 'Maven-3.6.3') {
			bat'mvn test'
			}
			}
               
            }
        
	stage('Deploy') {
	echo 'Deploy stage'
	steps{
	    withMaven(maven : 'Maven-3.6.3') {
			bat'mvn install'
           } 
        }
            }
            
}
}
