-include .env.make
export

MARIO_SIMULATOR_PROJECT = "MarioAI4J"
MARIO_COEVOLUTION_PROJECT = "MarioDoubleEvolution"

GRADLE_VERSION = "6.4.1"

get-gradle-wrapper:
	gradle wrapper --gradle-version $(GRADLE_VERSION)

jar: get-gradle-wrapper
	./gradlew $(MARIO_SIMULATOR_PROJECT):jar
	./gradlew $(MARIO_COEVOLUTION_PROJECT):jar

test: get-gradle-wrapper
	./gradlew $(MARIO_COEVOLUTION_PROJECT):test

run-coev: jar
	# TODO: make custom gradle command to build coevolution jar
	java -jar ./MarioDoubleEvolution/build/libs/MarioDoubleEvolution.jar 

changes-simulator:
	git difftool 5ab3f ./MarioAI4J/

changes-neat:
	git difftool c69ab ./MarioDoubleEvolution/src/main/java/com/evo/NEAT

documentation:
	./gradlew $(MARIO_COEVOLUTION_PROJECT):dokka
