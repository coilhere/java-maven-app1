#!/usr/bin/env groovy

pipeline {
    agent none
    stages {
        stage('test') {
            steps {
                script {
                    echo "Testing the application..."
                    echo "Executing pipeline for branch $BRANCHNAME"
                }
            }
        }
        stage('build') {
            when {
                expression {
                    BRANCHNAME == "master"
                }
            }
            steps {
                script {
                    echo "Building the application..."
                }
            }
        }
        stage('deploy') {
            when {
                expression {
                    BRANCHNAME == "master"
                }
            }
            steps {
                script {
                    echo "Deploying the application..."
                }
            }
        }
    }
}
