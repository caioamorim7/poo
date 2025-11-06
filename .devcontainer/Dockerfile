FROM mcr.microsoft.com/devcontainers/base:ubuntu-24.04

# Instala dependências e Git LFS
RUN apt-get update && \
    apt-get install -y curl zip unzip git-lfs && \
    git lfs install

RUN apt-get update && apt-get install -y \
    libfreetype6 \
    libfreetype6-dev \
    libfontconfig1 \
    graphviz

RUN wget -O /usr/local/bin/plantuml.jar https://github.com/plantuml/plantuml/releases/download/v1.2025.10/plantuml-1.2025.10.jar

# Instala SDKMAN e configura no .bashrc
USER vscode

ENV SDKMAN_DIR="/home/vscode/.sdkman"

RUN curl -s "https://get.sdkman.io" | bash && \
    echo "source $HOME/.sdkman/bin/sdkman-init.sh" >> $HOME/.bashrc

RUN echo 'alias plantuml="java -jar /usr/local/bin/plantuml.jar"' >> $HOME/.bashrc

# Shell como bash para comandos com SDKMAN
SHELL ["bash", "-c"]

# Instala Java 21 via SDKMAN
RUN source "$HOME/.sdkman/bin/sdkman-init.sh" && \
    sdk install java 21.0.2-open

CMD ["bash"]
