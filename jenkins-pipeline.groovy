pipeline{
    agent any

    stages{
        stage('Git Checkout'){
            steps{
                git branch: 'main', credentialsId: 'git', url: 'https://github.com/suneeltejaas/docker.git'
            }
        }
        stage('Terraform Init'){
            steps{
                sh 'echo terraform init'
                sh 'terraform init'
            }
        }
        stage('Terraform Plan'){
            steps{
                sh 'echo terraform plan'
                sh 'terraform plan'
            }
        }
        stage('Terraform Apply'){
            steps{
                sh 'echo terraform apply'
                sh 'terraform apply --auto-approve'
            }
        }

    }
}
