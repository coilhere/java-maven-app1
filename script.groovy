def buildJar() {
    echo 'Building the app...'
    sh 'mvn package'
}

def buildImage() {
    echo 'Building the image...'
    sh 'docker build -t coilhere/java-maven-app:2.0 .'
}

def pushImage() {
    echo 'Pushing the image...'
    withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh "docker push coilhere/java-maven-app:2.0"
    }
}

def deployApp() {
    echo 'Deploying the app...'
}

return this