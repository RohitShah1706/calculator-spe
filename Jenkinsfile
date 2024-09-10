pipeline {
    agent any

    environment {
        IMAGE_NAME = 'rohitshah1706/calculator'
    }

    stages {

        stage('Check tools') {
            steps {
                echo 'Checking Docker and Docker Compose versions...'
                sh '''
                docker version
                docker compose version
                '''
            }
        }

        stage('Run tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                echo 'Building Docker image...'
                script {
                    docker.build("${IMAGE_NAME}:latest")
                }
            }
        }

        stage('Login to DockerHub') {
            steps {
                echo 'Logging in to DockerHub...'
                script {
                    docker.withRegistry('https://index.docker.io/v1/', 'registry_creds') {
                        // Docker registry login happens here
                    }
                }
            }
        }

        stage('Push Docker Image to Registry') {
            steps {
                echo 'Pushing Docker image to DockerHub...'
                script {
                    docker.withRegistry('https://index.docker.io/v1/', 'registry_creds') {
                        docker.image("${IMAGE_NAME}:latest").push()
                    }
                }
            }
        }
    }
}
