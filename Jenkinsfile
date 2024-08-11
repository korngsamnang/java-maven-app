def gv

pipeline{
    agent any
    tools{
        maven "maven-3.9"
    }

    stages {

    stage("init"){
        steps{
            script{
                gv = load "script.groovy"
            }
        }



        stage("build jar"){
            steps{
               script{
                   gv.buildJar()
               }
            }
        }
          stage("build image"){
                   steps{
                      script{
                            echo "Building the docker image..."
                            withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]){

                                sh "docker build -t korngsamnang/demo-app:jma-2.0 ."
                                sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
                                sh "docker push korngsamnang/demo-app:jma-2.0"

                            }
                      }
                   }
               }
        stage("deploy"){
            steps{
                echo "Deploying the application..."
            }
        }
    }
}