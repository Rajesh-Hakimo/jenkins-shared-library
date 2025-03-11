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
def generateYaml(parameters) {
    return """
cloud:
  hosts:
    ${parameters.Tenant_ID}:
      ansible_host: localhost
      ansible_connection: local
      tenant_name: "${parameters.Tenant_Name}"
      tenant_id: "${parameters.Tenant_ID}"
      tenant_namespace: "motion-${parameters.Tenant_ID}"
      tenant_folder: "motion_${parameters.Tenant_ID}"
      location:
        name: "${parameters.Location_Name}"
        country: "${parameters.Location_Country}"
        state: "${parameters.Location_State}"
        city: "${parameters.Location_City}"
        timezone: "${parameters.Location_Timezone}"
        description: "${parameters.Location_Description"
"""
}
