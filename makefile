.PHONY: all update clean

all:
	mvn package -Dmaven.test.skip=true 

update:
	mvn versions:display-dependency-updates
	
clean:
	mvn clean

