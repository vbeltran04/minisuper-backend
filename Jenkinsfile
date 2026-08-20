pipeline {
    agent any

    tools {
        // El nombre debe coincidir exactamente con el que pusiste en Jenkins
        maven 'Maven3'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Descargando código desde GitHub...'
            }
        }

        stage('Build & Test') {
            steps {
                echo 'Compilando proyecto Spring Boot...'
                sh 'mvn clean package -DskipTests'
            }
        }
    }

    post {
        success {
            echo '¡El proyecto minisuper-backend se compiló exitosamente!'
        }
        failure {
            echo 'Ocurrió un error durante la compilación.'
        }
    }
}