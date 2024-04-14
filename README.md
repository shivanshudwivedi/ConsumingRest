# ConsumingRest Application ##
This is a Java-based Spring Boot application designed to consume RESTful services from the Quoters API. It demonstrates how to set up, configure, and deploy a REST client using Spring Boot, Docker, and Kubernetes.

# Prerequisites
Before you begin, ensure you have met the following requirements:

- Java JDK 21
- Gradle (compatible with your Java version)
- Docker
- Kubernetes
- Access to a Kubernetes cluster (e.g., minikube, Docker Desktop)
- Running Locally

## To run the ConsumingRest application locally, follow these steps:

- Clone the repository:

 ```
git clone https://github.com/shivanshudwivedi/ConsumingRest.git
```

- Navigate to the project directory:
````
cd ConsumingRest
````

- Build the application using Gradle:

````
./gradlew build
````

- Run the application:

````
./gradlew bootRun
````

The application will start on http://localhost:8080. It will automatically try to connect to the Quoters service at http://localhost:8080.

## Running with Docker

To containerize and run the application using Docker, follow these steps:

- Build the Docker image:

````
docker build -t yourusername/consumingrest .
````

- Run the Docker container:

````
docker run -p 8080:8080 yourusername/consumingrest
````

The application will now be accessible at http://localhost:8080. Ensure that the Quoters service is accessible to the Docker container, either by running it locally on Docker or by adjusting the network settings.

# Deploying to Kubernetes

To deploy the application on Kubernetes, follow these steps:

- Create a Kubernetes Deployment configuration (if not already created):

- Apply the deployment:

````
kubectl apply -f deployment.yaml
````

- Expose the deployment (optional):
``````
kubectl expose deployment consumingrest --type=LoadBalancer --name=consumingrest-service
``````

- Check the service:
``````
kubectl get services consumingrest-service
``````

- Check the logs to ensure the application is running correctly:

````
kubectl logs -f deployment/consumingrest
````

# Contributing
To contribute to ConsumingRest, follow these steps:

- Fork the repository.
  - Create a branch: 
  ``` git checkout -b <branch_name>. ```
  - Make your changes and commit them: 
  ```` git commit -m '<commit_message>'. ````
  - Push to the original branch: 
  ```git push origin <project_name>/<location>.```
  - Create the pull request.
    Alternatively, see the GitHub documentation oncreating a pull request.

# Contact
If you want to contact me, you can reach me at shivanshu.dwivedi@trincoll.edu.

# License
This project uses th MIT License.



