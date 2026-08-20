pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Descargando código desde GitHub...'
            }
        }

        stage('Build & Test') {
            steps {
                echo 'Compilando proyecto Spring Boot con Maven Wrapper...'
                // Damos permisos de ejecución al script mvnw por si acaso y compilamos
                sh 'chmod +x mvnw'
                sh './mvnw clean package -DskipTests'
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