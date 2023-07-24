## Run with maven profile

Maven profile 'h2' is specified in pom.xml. In order to run the application using this profile:

1. Go to 'Maven' tab and select Profiles -> h2.
2. Press the button 'Reload all maven Projects'
3. Run like this: mvn -V -P h2 spring-boot:run or by setting the -Dspring.profiles.active