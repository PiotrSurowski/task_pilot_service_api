pipeline {
    agent any
    environment {
        DOCKER_BUILDKIT = 1
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build JAR') {
            steps {
                sh './mvnw clean package -DskipTests'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("task-pilot")
                }
            }
        }
        stage('Run Docker Containers') {
            steps {
                script {
                    sh 'docker-compose up -d --build'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    // Wykonaj testy, jeśli to konieczne
                }
            }
        }
    }
}
