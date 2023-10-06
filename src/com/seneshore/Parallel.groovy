package com.seneshore

Class Parallel implements Serializable {
    def call(Sting[] names) {
        return exec(names)
    }

    def exec(String[] names) {
        names.each { name ->
            parallel {
                pipeline {
                    agent any
                    stages {
                        stage("Hello") {
                            steps {
                                echo "Hello ${name}"
                            }
                        }
                    }
                }
            }
        }
    }
}