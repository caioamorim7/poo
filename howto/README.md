Finalizada as devidas introduções, vamos seguir para a instalação das ferramentas com os passos abaixo:
* Instalação do OpenJDK 21 no Linux via apt
    * (opcional) Instalação manual do OpenJDK 21 no Linux
    * (opcional) Instalação do OpenJDK 21 no Linux via SDKMAN!
* Instalação do VS Code no Linux via apt
    * (opcional) Instalação manual do VS Code no Linux
* Instalação do Git
* Instalação do Github Cli
* Instalação dos seguintes plugins no VS Code
    * Java Platform Extension for Visual Code
    * Extension Pack for Java
    * Git
    * GitHub


### 🛠️ Configuração do ambiente

<details>
<summary><h4>🐧 Instalação do OpenJDK 21 no Linux via apt</h4></summary>

Executar os seguintes comandos no terminal para instalar o OpenJDK 21 no Linux:

1. **Atualizar pacotes**

```bash
sudo apt update && sudo apt upgrade -y
```

2. **Instalar o OpenJDK 21**

```bash
sudo apt install -y openjdk-21-jdk
```

3. **Configurar variáveis de ambiente**

```bash
echo 'export JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64' >> ~/.bashrc
echo 'export PATH=$JAVA_HOME/bin:$PATH' >> ~/.bashrc
source ~/.bashrc
```

4. **Verificar a instalação**

```bash
java -version
```
5. **Confirmar a instalação**

```bash
openjdk version "21.0.2" 2024-01-16
OpenJDK Runtime Environment (build 21.0.2+13-58)
OpenJDK 64-Bit Server VM (build 21.0.2+13-58, mixed mode, sharing)
```

5. **Configuarar o OpenJDK 21 como padrão**

Esse passo é necessário apenas caso tenha várias versões do Java instaladas

```bash
sudo update-alternatives --config java
```

```bash
sudo update-alternatives --config javac
```

</details>

<details>
<summary><h4>🐧 Instalação manual do OpenJDK 21 no Linux</h4></summary>

Executar os seguintes comandos no terminal para instalar o OpenJDK 21 no Linux:

1. **Baixar o OpenJDK**

Baixar executando o comando abaixo no terminal ou fazer download da versão 21 em https://jdk.java.net/archive/

```bash
wget https://download.java.net/java/GA/jdk21.0.2/f2283984656d49d69e91c558476027ac/13/GPL/openjdk-21.0.2_linux-x64_bin.tar.gz
```

2. **Extrair o arquivo baixado e mova para o diretório /opt/**

```bash
tar -xvzf openjdk-21.0.2_linux-x64_bin.tar.gz
sudo mv jdk-21.0.2 /opt/
```

3. **Configurar variáveis de ambiente**

```bash
echo 'export JAVA_HOME=/opt/jdk-21.0.2' >> ~/.bashrc
echo 'export PATH=$JAVA_HOME/bin:$PATH' >> ~/.bashrc
source ~/.bashrc
```

4. **Verificar a instalação**

```bash
java -version
```

5. **Confirmar a instalação**

```bash
openjdk version "21.0.2" 2024-01-16
OpenJDK Runtime Environment (build 21.0.2+13-58)
OpenJDK 64-Bit Server VM (build 21.0.2+13-58, mixed mode, sharing)
```

6. **Configuarar o OpenJDK 21 como padrão**

Esse passo é necessário apenas caso tenha várias versões do Java instaladas

```bash
sudo update-alternatives --config java
```

```bash
sudo update-alternatives --config javac
```

</details>


<details>
<summary><h4>🐧 Instalação do OpenJDK 21 via SDKMAN</h4></summary>

O [SDKMAN!](https://sdkman.io/) é uma ferramenta que facilita a instalação e o gerenciamento de múltiplas versões do JDK no Linux e macOS. Com ele, você pode instalar, atualizar e alternar entre diferentes versões do Java facilmente.

1. **Instalar o SDKMAN!**

```bash
curl -s "https://get.sdkman.io" | bash
```

2. **Ativar o SDKMAN!**

```bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
```

3. **Verificar instalação**

```bash
sdk version
```

4. **Confirmar instalação**

```bash
SDKMAN 5.19.0
```

5. **Instalar o OpenJDK 21**

```bash
sdk install java 21.0.2-open
```

6. **Verificar a instalação do OpenJDK 21**

```bash
java -version
```

7. **Confirmar a instalação do OpenJDK 21**

```bash
openjdk version "21.0.2" 2024-01-16
OpenJDK Runtime Environment (build 21.0.2+13-58)
OpenJDK 64-Bit Server VM (build 21.0.2+13-58, mixed mode, sharing)
```

Comando úteis do SDKMAN!

```bash
sdk update

sdk list java

sdk current java
```

</details>


<details>

<summary><h4>📦 Instalar o VS Code via apt</h4></summary>

1. **Atualizar pacotes**

```bash
sudo apt update && sudo apt upgrade -y
```

2. **Baixar o VS Code e adicionar a chave do GPG da Microsoft**

```bash
wget -qO- https://packages.microsoft.com/keys/microsoft.asc | gpg --dearmor | sudo tee /usr/share/keyrings/packages.microsoft.gpg > /dev/null
```

3. **Adicionar o repositório do VS Code

```bash
echo "deb [arch=amd64 signed-by=/usr/share/keyrings/packages.microsoft.gpg] https://packages.microsoft.com/repos/code stable main" | sudo tee /etc/apt/sources.list.d/vscode.list
```

4. **Instalar o VS Code**

```bash
sudo apt update
sudo apt install -y code
```

5. **Verificar instalação**

```bash
code --version
```

6. **Confirmar instalação**

```bash
1.96.4
cd4ee3b1c348a13bafd8f9ad8060705f6d4b9cba
x64
```

</details>

<details>
<summary><h4>🖥️ Instalação manual do VS Code no Linux</h4></summary>

1. **Baixar o pacote .deb**

O pacote está disponível no link https://code.visualstudio.com/download

2. **Instalar o pacote**

```bash
sudo dpkg -i code_*.deb
```

3. **Verificar instalação**

```bash
code --version
```

4. **Confirmar instalação**

```bash
1.96.4
cd4ee3b1c348a13bafd8f9ad8060705f6d4b9cba
x64
```
</details>

<details>

<summary><h4>🐙 Instalação do Git</h4></summary>

1. Instalar o Git
```bash
sudo apt install git -y
```

2. Verificar instalação do git
```bash
git --version
```

</details>

<details>

<summary><h4>🔧 Instalação do Github Cli</h4></summary>

1. Instalar o Github Cli
```bash
sudo apt install gh
```

2. Verificar instalação do Github Cli
```bash
gh --version
```

3. Logar no Github
```bash
gh auth login
```

</details>


> 🎉 **Parabéns!** Você concluiu a configuração do ambiente com sucesso! Agora está pronto para começar a programar. 🚀
