pipeline {
    agent any
    environment {
        // specifying variables
        NAME = "Daniel Lamperd"
        DIRECTORY_PATH = '"C:/ProgramData/Jenkins/.jenkins/jobs/ProjectBeetRoot"'
        TESTING_ENVIRONMENT = 'TestingServer'
        
        // production environment refers to the NAME variable
        PRODUCTION_ENVIRONMENT = "${env.NAME}"
    }
    
    stages {
        stage('Build') {
            steps {
                echo 'fetch the source code from the directory path specified by the environment variable'
                echo 'compile the code and generate and necessary artifacts'
            }
        }
        
        stage('Test') {
            steps {
                echo 'units tests'
                echo 'integration tests'
            }
        }
        
        stage('Code Quality Check') {
            steps {
                echo 'check the quality of the code'
            }
        }
        
        stage('Deploy') {
            steps {
                echo 'deployt the application to a testing environment specified by the environment variable'
            }
        }
        
        stage('Approval') {
            steps {
            //waiting 10 seconds to simulate manual approval
                sleep(time: 10, unit: 'SECONDS')
            }
        }
        
        stage('Deploy to Production') {
            steps {
                echo "${env.NAME}, deploying to production..."
                echo "deploying code to ${env.PRODUCTION_ENVIRONMENT}"
            }
        }
    }
}
