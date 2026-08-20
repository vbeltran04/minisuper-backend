pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    stages {
        stage('Checkout') {
            steps {
                echo '=== Descargando código desde GitHub ==='
                checkout scm
            }
        }

        stage('Compile') {
            steps {
                echo '=== Compilando el código fuente ==='
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo '=== Ejecutando Pruebas Unitarias ==='
                // Corre las pruebas de JUnit sin empaquetar aún
                sh 'mvn test'
            }
            post {
                always {
                    // Publica los resultados de JUnit en la interfaz de Jenkins
                    junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Package') {
            steps {
                echo '=== Empaquetando Aplicación (JAR) ==='
                // Omitimos los tests aquí porque ya los corrimos en la etapa anterior
                sh 'mvn package -DskipTests'
            }
            post {
                success {
                    // Guarda el JAR resultante como artefacto construible dentro de Jenkins
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }
        }
    }

    post {
        success {
            echo '¡Pipeline de miniSuper Backend completado con éxito!'
        }
        failure {
            echo 'Error en la canalización. Revisa los logs para más detalles.'
        }
    }
}