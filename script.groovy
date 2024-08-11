def buildJar(){
    echo "Building the jar file..."
    sh "mvn clean package"
}

def buildImage(){
    echo "Building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]){
        sh "docker build -t korngsamnang/demo-app:jma-2.0 ."
        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
        sh "docker push korngsamnang/demo-app:jma-2.0"
    }
}

def deployApp(){
    echo "Deploying the application..."
}

return this;