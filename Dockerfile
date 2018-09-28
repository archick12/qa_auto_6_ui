FROM circleci/buildpack-deps:14.04-browsers

RUN sudo apt-key update -y
RUN sudo apt-get update && sudo apt-get upgrade -y
RUN sudo apt-get install -y software-properties-common
RUN sudo add-apt-repository ppa:andrei-pozolotin/maven3 
RUN sudo apt-get update
RUN sudo apt-get install -y maven3


CMD tail -f /dev/null 
