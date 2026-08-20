pipeline {
    agent any

    tools {
        // Asegúrate de que el nombre coincida con el JDK/Maven configurado en Jenkins o usa los comandos del sistema
        maven 'M3' // Si no tienes Maven global configurado en Jenkins, este paso se adapta
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Descargando código desde GitHub...'
            }
        }

        stage('Build & Test') {
            steps {
                echo 'Compilando proyecto Spring Boot con Maven...'
                // Ejecuta la compilación y pruebas de Spring Boot
                sh './mvnw clean package' 
                // Nota: En Windows dentro del contenedor Jenkins suele usarse sh 'mvn clean package' o './mvnw clean package'
            }
        }
    }

    post {
        success {
            echo '¡El proyecto minisuper-backend se compiló exitosamente!'
        }
        failure {
            echo 'Ocurrió un error durante la compilación o ejecución de pruebas.'
        }
    }
}