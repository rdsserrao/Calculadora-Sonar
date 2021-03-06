pipeline {
    agent any
            parameters {
                string(name: 'Imagem', defaultValue: 'jenkins1', description: 'Nome da imagem')
            }
            stages {
                stage('Clone') {
                    steps {
                        git url: 'https://github.com/rdsserrao/Calculadora-Sonar.git'
                    }
                }
                stage ('Criar .jar') {
                    steps {
                        sh 'javac *.java'
                        sh 'jar cfe calc.jar ./Calculadora-Sonar *.class'
                    }   
                }
                stage('SonarQube analysis') {
                        environment { scannerHome = tool 'sonarqube' }
                    steps {
                            withSonarQubeEnv('sonarqube') {
                                    sh "${scannerHome}/bin/sonar-scanner \
                                    -D sonar.login=f5f103028120cd31b483291025b64a8a640aa10c \
                                    -D sonar.projectKey=Teste \
                                    -D sonar.java.binaries=/var/jenkins_home/workspace/Calculadora-Sonar \
                                    -D sonar.java.source=11 \
                                    -D sonar.host.url=http://sonar:9000/"
                            }
                        }
                    }
        stage("Quality Gate") {
            steps {
			script {
                timeout(time: 1, unit: 'HOURS') {
					def qualitygate = waitForQualityGate()
					if (qualitygate.status != "OK") {
					error "Pipeline aborted due to quality gate coverage failure: ${qualitygate.status}"
					}
                }
            }
        }
    }
              /* stage ('Criar Imagem') {
                    steps {
                        sh 'docker rmi -f $Imagem'
                        sh 'docker build -t $Imagem .'
                    }   
                } 

                stage ('Enviar para o Nexus') {
                    steps {
                        withCredentials([usernamePassword(credentialsId: 'nexus', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh 'docker login -u $USER -p $PASS localhost:8082'
                        }
                        sh 'docker tag $Imagem localhost:8082/$Imagem:1.0'
                        sh 'docker push localhost:8082/$Imagem:1.0'
                    }   
                }
              */  stage ('Criar artefato no raw') {
                    steps {
                        withCredentials([usernamePassword(credentialsId: 'nexus', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh 'curl -v --user $USER:$PASS --upload-file calc.jar http://nexus:8081/repository/raw_repo/'
                        }
                    }   
                }
                stage('Clean') {
                    steps {
                        cleanWs()
                    }
                }
            }
}