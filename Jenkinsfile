pipeline {
    agent any
    tools {
        maven 'maven-3.8.7'
    }
    stages {
        stage('build jar') {
            steps {
                script {
                    echo "Building the application..."
                    sh 'mvn package'
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
                    withCredentials([
                        usernamePassword(credentials: 'dockerhub-credentials', usernameVariable: USERNAME, passwordVariable: PASSWORD)
                    ]) {
                        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
                        sh 'docker push coilhere/java-maven-app:2.0'
                    }
                }
            }
        }
    }
}
