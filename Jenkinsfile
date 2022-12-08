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
                                   nexusArtifactUploader artifacts:
                                    [[artifactId: 'demo', classifier: '', file: 'target/demo-1.0.0.jar', type: 'jar', type: 'jar']],
                                    credentialsId: 'nexus-auth',
                                    groupId: 'com.insat',
                                    nexusUrl: 'localhost:8081',
                                    nexusVersion: 'nexus3',
                                    protocol: 'http',
                                    repository: 'demoapp-release',
                                    version: '1.0.0'
                                }
                           }
                   }
     }}