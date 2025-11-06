FROM mcr.microsoft.com/devcontainers/base:ubuntu-24.04

# Instala dependências e Git LFS
RUN apt-get update && \
    apt-get install -y curl zip unzip git-lfs && \
    git lfs install

# Instala SDKMAN e configura no .bashrc
RUN curl -s "https://get.sdkman.io" | bash && \
    echo "source $HOME/.sdkman/bin/sdkman-init.sh" >> $HOME/.bashrc

# Shell como bash para comandos com SDKMAN
SHELL ["bash", "-c"]

# Instala Java 21 via SDKMAN
RUN source "$HOME/.sdkman/bin/sdkman-init.sh" && \
    sdk install java 21.0.2-open

CMD ["bash"]
