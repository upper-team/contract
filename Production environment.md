# Production environment

## Preparation for running

1. JDK >= 1.8 (Recommend 1.8 version)
2. Mysql >= 5.7.0 (Recommend 5.7 version)
3. Maven >= 3.0

## Running the contract management system

1. Go to `Github` webpage (https://github.com/upper-team/contract.git) to clone the project.

2.  Import the project into `IDEA`, click `File` -> `New` -> `Project from version control`, paste the URL to the textfield and select the working directory, then it can be imported successfully.

   `IDEA` will automatically load the `Maven` dependencies. The initial load will be slow (depending on your network).

3. Open the project and run `com. Ruoyi. RuoYiApplication. Java`, appear below said started successfully.

4. Open your browser and type: (http://localhost:8003) (default account/password cpt202/cpt202)

   If the login page can be displayed correctly, and the login can be successful, and the menu and page display is normal, it indicates that the environment is built successfully.

## Common Question

- If you are using Mac, you need to modify the `application.yml` file path `profile`