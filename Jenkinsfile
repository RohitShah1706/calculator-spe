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

        stage("Deploy via ansible") {
            steps {
                ansiblePlaybook(
                    installation: 'Ansible',
                    inventory: 'inventory/inventory.ini',
                    playbook: 'playbook/deploy.yml',
                )
            }
        }
    }

    post {
        always {
            // send email notficiation with build status
            script {
                def jobName = env.JOB_NAME
                def buildNumber = env.BUILD_NUMBER
                def pipelineStatus = currentBuild.result ?: 'UNKNOWN'
                def bannerColor = pipelineStatus.toUpperCase() == 'SUCCESS' ? 'green' : 'red'

                def body = """
                    <html>
                        <body>
                            <div style="border: 4px solid ${bannerColor}; padding: 10px;">
                                <h2>${jobName} - Build ${buildNumber}</h2>
                                <div style="background-color: ${bannerColor}; padding: 10px;">
                                    <h3 style="color: white;">
                                        Pipeline Status: ${pipelineStatus.toUpperCase()}
                                    </h3>
                                </div>
                                <p>
                                    Check the <a href="${BUILD_URL}/console">console output</a>
                                </p>
                            </div>    
                        </body>
                    </html>
                """

                emailext(
                    subject: "${jobName} - Build ${buildNumber} - ${pipelineStatus.toUpperCase()}",
                    body: body,
                    to: "rlshah03@gmail.com",
                    from: "rlshah03@gmail.com",
                    replyTo: "rlshah03@gmail.com",
                    mimeType: 'text/html'
                )
            }
        }
    }
}
