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
                echo 'Compilando proyecto Spring Boot...'
                // Ejecuta la compilación omitiendo los tests temporales para validar el empaquetado JAR
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