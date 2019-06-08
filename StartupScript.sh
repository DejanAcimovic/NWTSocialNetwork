java -jar -Xmx128m ./servicediscovery/target/servicediscovery-0.0.1-SNAPSHOT.jar &
sleep 10 &
java -jar -Xmx128m ./apigateway/target/apigateway-0.0.1-SNAPSHOT.jar &
java -jar -Xmx128m ./PictureMicroservice/target/picturemodel-0.0.1-SNAPSHOT.jar &
java -jar -Xmx128m ./PostModule/target/PostModule-0.0.1-SNAPSHOT.jar &
java -jar -Xmx128m ./UserMicroservice/target/usermodule-0.0.1-SNAPSHOT.jar

