package com.seneshore

class Parallel implements Serializable {
    def call(String[] names) {
        return exec(names)
    }

    def exec(String[] names) {
        for(String name in names) {
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