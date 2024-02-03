pipeline {
    agent any
    environment {
        BRANCH = 'Release'
    }
    stages {
        stage('Step1') {
            steps {
                sh 'printenv'
            }
        }
        stage('Step2') {
            when {
                expression { 
                    BRANCH == 'Master' || BRANCH == 'Hotfix'           
                 }
            }
            steps {
                echo 'Step2'
            }
        }
        stage('Step3') {
            when {
                expression {   
                    BRANCH == 'Release' 
                }   
            }
            steps {
                echo 'Step3'
            }
        }
    }
}

