pipeline {
    agent any 
    stages {
        stage('Build') { 
           steps {
                bat 'make' 
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true 
            }
        }
        stage('Test') { 
            steps {
              bat 'make check || true'
              junit '**/target/*.xml'

                   }
               }
               
                stage('Deploy') {
            when {
              expression {
                currentBuild.result == null || currentBuild.result == 'SUCCESS' 
              }
            }
            steps {
                bat 'make publish'
            }
        }
        

            }
        

            }
            

