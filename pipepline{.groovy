pipepline{
    agent any
    {stages
        stage("Build"){
            steps{
                echo "Building"
            }
            post{
                success{
                    mail to:"ddlammperd@gmail.com",
                    subject: "Build Status Email",
                    body:"Build was successful"
                }
            }
        }    
    }
}