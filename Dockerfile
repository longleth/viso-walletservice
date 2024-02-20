#############################
#    VISO WALLET SERVICE    #
#       Docker File         #
#############################

FROM        amazoncorretto:17.0.9-alpine
LABEL       authors="longle"

ADD         target/walletservice-0.0.1-SNAPSHOT.jar /walletservice-0.0.1-SNAPSHOT.jar

ENTRYPOINT  ["java", "-jar", "walletservice-0.0.1-SNAPSHOT.jar"]
