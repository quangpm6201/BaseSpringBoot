pipeline {
    agent any
    stages {
        stage('Clone') {
            steps {
                git 'https://github.com/quangpm6201/BaseSpringBoot.git'
            }
        }

         stage('Build') {
            steps {
                withDockerRegistry(credentialsId: 'spring-base', url: 'https://index.docker.io/v1/') {
                     sh 'docker build -t quangpm/baseSpringBoot'
                     sh 'docker push quangpm/baseSpringBoot'
                }
            }
         }
    }
}