pipeline {
    agent any
    
    tools {
        maven 'M3'
    }
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("spring-boot-demo:${env.BUILD_ID}")
                }
            }
        }
        
        stage('Deploy') {
            steps {
                script {
                    sh 'docker stop spring-boot-app || true'
                    sh 'docker rm spring-boot-app || true'
                    sh 'docker run -d -p 8081:8081 --name spring-boot-app spring-boot-demo:${env.BUILD_ID}'
                }
            }
        }
    }
    
    post {
        always {
            echo 'Pipeline completed!'
        }
    }
}
