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
                    gv.buildJar
                }
            }
        }
        stage('build image') {
            steps {
                script {
                    gv.buildImage
                }
            }
        }
        stage('push image') {
            steps {
                script {
                    gv.pushImage
                }
            }
        }
        stage('deploy app') {
            steps {
                script {
                    gv.deployApp
                }
            }
        }
    }
}
