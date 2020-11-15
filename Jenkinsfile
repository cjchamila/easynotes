pipeline {
    agent any 
    stages {
        stage('Build') { 
            steps {
               echo 'Building step1...'
               echo 'Building step2...'
            }
        }
        stage('Test') { 
            steps {
               echo 'Testing step 1...'
               echo 'Testing step 2...'
               echo 'Testing step 3...'  
               echo 'Testing step 4...' 
            }
        }
        stage('Deploy') { 
            steps {
                 echo 'Deploying stage...'
                 
            }
        }
    }
}