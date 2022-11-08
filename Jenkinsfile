pipeline {
     environment {
          registry = "iraxus/maven-docker-test"
          DOCKERHUB_CREDENTIALS = credentials('docker-login-pwd')
      }
    agent {
        docker {
            image 'mmiotkug/node-curl'
            args '-p 3000:3000'
            args '-w /app'
            args '-v /var/run/docker.sock:/var/run/docker.sock'
        }
    }
    options {
        skipStagesAfterUnstable()
    }
    stages {
        agent {
            docker{
                        image 'maven:3.8.6-amazoncorretto-17'
                        args '-w /app'
                    }
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

        stage('Build Docker Image') {
            steps {
                echo 'Building Docker Image'
                sh 'docker image build -t $registry .'
                sh 'docker login -u $DOCKERHUB_CREDENTIALS_USR -p $DOCKERHUB_CREDENTIALS_PSW'
                sh 'docker image push $registry'
                sh 'docker image rm $registry'
            }
        }
    }
}