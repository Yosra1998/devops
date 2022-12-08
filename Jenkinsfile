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
     }}