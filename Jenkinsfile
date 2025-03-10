/*
The line below defines the library path. The above refers to the settings
created on the Jenkins.
Optionally you may also pin it to specific version like
    @Library("shared-lib@v1.0.0") _
The _ (underscore) at the end denotes that we would like to import
all the Globals under `var` directory.
*/
@Library("shared-lib") _

// Import the library
import com.seneshore.Hello

// Create an object of the Class Hello
def Hello = new Hello()

pipeline {
    agent any 
    options {
        timestamps ()
    }
    stages {
        stage("utill Default") {
            steps {
                script {
                    utils()
                }
            }
        }
        stage("util ping") {
            steps {
                script {
                    utils.ping("google.com")
                }
            }
        }
        stage("print random number") {
            steps {
                script {
                    def randomNumber = utils.generateRandomNumber(50)
                    println randomNumber
                }
            }
        }            
        stage("Hello") {
            steps {
                script {
                    // This uses the default method 'call' of the Class Hello
                    Hello(this, "Prakritish")
                    // Explicitly calling Public method `exec` of the Class Hello
                    Hello.exec(this, "Mr. Sen Eshore")
                }
            }
        }
    }
}
