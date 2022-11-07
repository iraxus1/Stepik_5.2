pipeline {
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
                sh 'mvn build'
            }
        }

    }
}