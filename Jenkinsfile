def gv
pipeline {
    agent any
    tools {
        maven 'maven-3.8.7'
    }
    stages {
        stage('init'){
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage('build jar') {
            steps {
                script {
                    gv.build

                }
            }
        }
        stage('build image') {
            steps {
                script {
                    echo "Building the image..."
                    sh 'docker build -t coilhere/java-maven-app:2.0 .'
                }
            }
        }
        stage('push image') {
            steps {
                script {
                    echo "Pushing the image..."
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh "docker push coilhere/java-maven-app:2.0"
                    }

                }
            }
        }
    }
}
