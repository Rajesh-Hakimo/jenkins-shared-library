/* 
Default function for the Groovy file. Use this function as below
from your pipeline i.e., use the file's basename as a function
while calling it from your script.

    script {
        utils()
    }

*/
def call() {
    echo "This is the default function of the shared library 'Util.groovy'"
}

/*
This function should be called as below:

    script {
        utils.ping("google.com")
    }

i.e., the function should be prefixed with the file's basename.
*/

def ping(String host) {
    def cmd = "ping -c 3 " + host 
    sh cmd
}

def generateRandomNumber(range) {
	def random = new Random()
  	def randomNumber = random.nextInt(range) // Generates a number between 0 and 99
  	return randomNumber
}
def generateYaml(params) {
    return """
cloud:
  hosts:
    ${params.Tenant_ID}:
      ansible_host: localhost
      ansible_connection: local
      tenant_name: "${params.Tenant_Name}"
      tenant_id: "${params.Tenant_ID}"
      tenant_namespace: "motion-${params.Tenant_ID}"
      tenant_folder: "motion_${params.Tenant_ID}"
      location:
        name: "${params.Location_Name}"
        country: "${params.Location_Country}"
        state: "${params.Location_State}"
        city: "${params.Location_City}"
        timezone: "${params.Location_Timezone}"
        description: "${params.Location_Name}, ${params.Location_City}, ${params.Location_State}, ${params.Location_Country}"
"""
}
