pipeline {
     environment {
          registry = "iraxus/maven-docker-test"
          DOCKERHUB_CREDENTIALS = credentials('docker-login-pwd')
      }
    agent {
        docker {
            image 'maven:3.8.6-amazoncorretto-17'
            args '-u root:root'
            args '-v /var/run/docker.sock:/var/run/docker.sock'
            args '-w /app'
        }
    }
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('Test') {
            steps {
                echo 'Testing'
                sh 'mvn test'
            }
        }
        stage('Build') {
            steps {
                echo 'Building'
                sh 'mvn clean install'
            }
        }
        stage("Build & Push Docker image") {
            steps {
                sh 'docker image build -t $registry:$BUILD_NUMBER .'
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u iraxus --password-stdin'
                sh 'docker image push $registry:$BUILD_NUMBER'
                sh "docker image rm $registry:$BUILD_NUMBER"
            }
        }

    }
}