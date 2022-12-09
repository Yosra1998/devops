pipeline{

    agent any

    stages {

        stage('Git Checkout'){

            steps{

                script{

                    git branch: 'main', url: 'https://github.com/Yosra1998/devops.git'

                    }
                }
            }


        stage('UNIT testing'){

                    steps{

                        script{

                            bat 'mvn test'
                        }
                    }
            }
          stage('Integration testing'){

                     steps{

                         script{

                             bat 'mvn verify -DskipUnitTests'
                         }
                     }
                 }

        stage('Maven build'){

                    steps{

                        script{

                            bat 'mvn clean install'
                        }
                    }
                }
        stage('Static code analysis'){

                    steps{

                        script{

                            withSonarQubeEnv(credentialsId: 'sonar-api') {

                                bat 'mvn clean package sonar:sonar'
                            }
                           }

                        }
                    }
                    stage('Quality Gate Status'){

                        steps{

                            script{

                                waitForQualityGate abortPipeline: false, credentialsId: 'sonar-api'
                            }
                        }
                    }
                    stage('import file to nexus'){

                           steps{

                               script{
                                   def readPomVersion = readMavenPom file :'pom.xml'
                                   def nexusRepo = readPomVersion.version.endsWith("SNAPSHOT") ? "demoapp-snapshot" : "demoapp-release"
                                   nexusArtifactUploader artifacts:
                                    [[artifactId: 'demo', classifier: '', file: 'target/demo-1.0.1-SNAPSHOT.jar', type: 'jar', type: 'jar']],
                                    credentialsId: 'nexus-auth',
                                    groupId: 'com.insat',
                                    nexusUrl: 'localhost:8081',
                                    nexusVersion: 'nexus3',
                                    protocol: 'http',
                                    repository: nexusRepo,
                                    version: "${readPomVersion.version}"
                                }
                           }
                   }
                   stage('Docker Image Build'){
                    steps{
                        bat 'docker image build -t DemoApplication:v1.29'
                        bat 'docker image tag $DemoApplication:v1.29 yosra112/DemoApplication:v1.29'
                        bat 'docker image tag DemoApplication:v1.29 yosra112/DemoApplication:latest'
                    }
                   }
     }}