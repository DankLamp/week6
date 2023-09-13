pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building code using Maven'
                sleep(time: 0.5, unit: 'SECONDS')
                echo 'Cleaning project'
                sleep(time: 0.5, unit: 'SECONDS')
                echo 'Compiling project'
                sleep(time: 0.5, unit: 'SECONDS')
            }
        }

        stage('Unit and Integration tests') {
            steps {
                echo 'Running integration tests using JUnit'
                sleep(time: 0.5, unit: 'SECONDS')
                echo 'Executing Code'
                sleep(time: 0.5, unit: 'SECONDS')
                echo 'Testing Assertions'
                sleep(time: 0.5, unit: 'SECONDS')
            }
        }

        stage('Code Analysis') {
            steps {
                echo 'Running code analysis using SonarQube'
                sleep(time: 0.5, unit: 'SECONDS')
                echo 'Scanning Code'
                sleep(time: 0.5, unit: 'SECONDS')
                echo 'Evaluating Code against quality gate'
                sleep(time: 0.5, unit: 'SECONDS')
            }
        }

        stage('Security Scan') {
            steps {
                echo 'Running Security Scan using Nessus'
                sleep(time: 0.5, unit: 'SECONDS')
                echo 'Scanning for Vulnerabilities'
                sleep(time: 0.5, unit: 'SECONDS')
            }
            post {
                success {
                    // Send a success notification email with logs as attachments
                    emailext subject: 'Security Scan finished',
                        body: 'Security scan has succeeded.',
                        attachLog: true,
                        to: 'a.abkenar@deakin.edu.au'
                }
                failure {
                    // Send a failure notification email with logs as attachments
                    emailext subject: 'Security Scan Failed',
                        body: 'Security scan has failed. Please check the logs for details.',
                        attachLog: true,
                        to: 'a.abkenar@deakin.edu.au'
                }
            }
        }

        stage('Integration tests on staging') {
            steps {
                echo 'Running Integration tests on staging environment'
                sleep(time: 0.5, unit: 'SECONDS')
                // Include actual steps for integration tests on staging here
            }
        }

        stage('Deploy to Production') {
            steps {
                echo 'Deploying to production via AWS EC2 instance'
                sleep(time: 0.5, unit: 'SECONDS')
                // Include actual deployment steps here
            }
        }
    }
}

