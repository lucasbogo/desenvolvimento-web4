DesenvolvimentoWebIV
====================

Configuração do ambiente de desenvolvimento para as aulas de Web IV.
--------------------------------------------------------------------

----------------------------------------------------------------------------------------------------

#### Objetivo desse trabalho:

Além de aprender a instalar e configurar as ferramentas de desenvolvimento web, esse trabalho busca realizar o estudo sobre cada ferramenta, para, assim, compreender seu propósito dentro do desenvolvimento web e documentar cada passo realizado usando a padronização de sintaxe Markdown.

----------------------------------------------------------------------------------------------------


### Ferramentas a serem utilizadas nessa disciplina:

1. Spring Tool Suite
2. Java
3. MySQL
4. Git
5. Node.js
6. Postman
7. Httpie



## 1. Spring Tool Suite
[Site Oficial](https://spring.io/tools)

- Versão do software: *4.13.0-RELEASE*
- Sistema Operacional: *Linux Ubuntu 20.04 LTS*

### Descrição:

O software de desenvolvimento web, *Spring Tools 4*, é a nova geração de ferramenta Spring para seu favorito ambiente de desenvolvimento, seja-os: Eclipse, Visual Studio Code ou Theia IDE. Na sua maior parte, reconstrúido do zero, a ferramenta providencia suporte mundial para desenvolvimento de aplicativos baseado em Spring.



### INSTALAÇÃO

> **1° ETAPA:** Acesse o site oficial, selecione o sistema operacional Linux e baixe o arquivo .tar.gz



> **2° ETAPA:** Depois de baixar o tarball do STS, mova-o para o path do java para melhor compatibilidade



> **3° ETAPA:** Mude a permissão do Spring tarball usando o seguinte comando:

```chmod 777 spring-tool-suite-tarball.x86_64.tar.gz```


> **4° ETAPA:** Extraia o tarball 

```tar -xzvf spring-tool-suite-tarball.x86_64.tar.gz```


> **5° ETAPA:** Ache a pasta RELEASE e clique em "lauch" e pronto, STS poderá ser utilizado.

------------------------------------------------------------------------------------------------------

## 2. Java
[Site Oficial](https://www.java.com/en/)

- Versão do software: *17.0.1 2021-10-19 LTS*
- Sistema Operacional: *Linux Ubuntu 20.04 LTS*

#### Descrição:

**Java** é uma linguagem de programação e plataforma de computação lançada primeiramente pela *Sun Microsystems* em 1995. Essa linguagem de programação conseguiu evoluir do seu começo humilde a dominar a maior parte do mundo digital de hoje. Essa conquista foi atingida ao providenciar uma plataforma confiável pela qual inúmeros serviços e aplicações são construídos. Novos, inovativos produtos e serviços digitais concebidos para o futuro continuam a depender do Java.


**OpenJDK** e **Oracle JDK** são duas implementações do Java. Essas implementações são baseadas nas mesmas configurações. A diferença principal é o licenciamento. *OpenJDK* é uma implementação de código aberto do Java. Já para usar o *Oracle JDK* é necessário uma liçença comercial.

O *Java Runtime Environment* (**JRE**) é um pacote que contém o  Java Virtual Machine (**JVM**) que possibilita rodar aplicações Java. O *Java Development Kit* (**JDK**) é um pacote completo que inclui *JRE*, *debugging* e *development tools* (ferramentas de desenvolvimento) que possibilita construir e rodar aplicações Java.


#### Tutorial da instalação:

> **1° ETAPA:** inserir e executar comando para adicionar o *repositório OpenJDK*

```sudo add-apt-repository -y ppa:openjdk-r/ppa```


> **2° ETAPA:** inserir e executar comando para instalar *OpenJDK* 

```sudo apt install -y openjdk-17-jdk```


> **3° ETAPA:** inserir e executar comando para verificar a versão do java

```java --version```


>>O resultado deverá ser o seguinte:

```java 17.0.1 2021-10-19 LTS```

------------------------------------------------------------------------------------------------------


## 3. MySQL
[Site Oficial](https://www.mysql.com/)

- Versão do software: *8.0.27*
- Sistema Operacional: *Linux Ubuntu 20.04 LTS*

#### Descrição:

MySQL é um sistema com código-aberto referente a gestão de banco de dados relacional. O nome desse sistema é um conjunção de "My", o nome da filha do co-fundador Michael Widenius e "SQL", a abreviação de "Structured Query Language". 



#### Tutorial da instalação:

> **1° ETAPA:** inserir e executar comando para instalar o *MySQL-Server*

```$ sudo apt install mysql-server```


> **2° ETAPA:** inserir e executar comando para coonfigurar o *MySQL-Server*

```sudo mysql_secure_installation```

>>Será solicitado algumas questões de configuração. 


> **3° ETAPA:** inserir e executar comando para instalar **MySQL-WorkBench** 

```sudo apt install mysql-workbench```


> **4° ETAPA:** lançar (Launch) *MySQL* e *MySQL-WorkBench*

```mysql -u root -p```


```mysql-workbench```

------------------------------------------------------------------------------------------------------

## 4. Git
[Site Oficial](https://git-scm.com/)

- Versão do software: *2.25.1*
- Sistema Operacional: *Linux Ubuntu 20.04 LTS*

#### Descrição:

Git é um sistema de controle de versão usado no desenvolvimento moderno de software. Ele permite que vários desenvolvedores trabalhem no mesmo projeto enquanto rastreiam alterações, revisões e colaboradores.

O Git é um sistema de controle de versão distribuída de código aberto e gratuito projetado para lidar com tudo, desde projetos pequenos até grandes com velocidade e eficiência. 

Git é fácil de aprender e tem uma pequena pegada com desempenho rápido relâmpago. Ele supera ferramentas SCM como Subversão, CVS, Perforce e ClearCase com recursos como ramificações locais baratas, áreas de estadiamento convenientes e vários fluxos de trabalho.




#### Tutorial da instalação:

> **1° ETAPA:** inserir e executar comando para adicionar e instalar o *repositório Git*

```sudo apt-get install git```


> **2° ETAPA:** inserir e executar comando para verificar a *versão*

```git --version```

>>O resultado deverá ser o seguinte:

```git version 2.25.1```

------------------------------------------------------------------------------------------------------

## 5. Node.js
[Site Oficial](https://nodejs.org/en/)

- Versão do software: * 16.13.2*
- Sistema Operacional: *Linux Ubuntu 20.04 LTS*

#### Descrição:

Como um tempo de execução JavaScript assíncrono orientado por eventos, o Node.js foi projetado para criar aplicativos de rede escaláveis. *No seguinte exemplo de "Olá mundo"*, muitas conexões podem ser tratadas simultaneamente. A cada conexão, o retorno de chamada é disparado, mas se não houver trabalho a ser feito, Node.js dormirá.


```
const http = require('http');

const hostname = '127.0.0.1';
const port = 3000;

const server = http.createServer((req, res) => {
  res.statusCode = 200;
  res.setHeader('Content-Type', 'text/plain');
  res.end('Hello World');
});

server.listen(port, hostname, () => {
  console.log(`Server running at http://${hostname}:${port}/`);
});

```

Isso contrasta com o modelo de concorrência mais comum de hoje, no qual os segmentos de OS são empregados. A rede baseada em segmentos é relativamente ineficiente e muito difícil de usar. Além disso, os usuários do Node.js estão livres de preocupações de bloqueio de mortos no processo, já que não há bloqueios. Quase nenhuma função no Nó.js executa diretamente I/O, então o processo nunca bloqueia exceto quando a I/O é realizada usando métodos síncronas de Node.js biblioteca padrão. Como nada bloqueia, sistemas escaláveis são muito razoáveis para se desenvolver em Node.js.



#### Tutorial da instalação:

> **1° ETAPA:** inserir e executar comando para adicionar e instalar o *repositório Node.js*


```sudo apt install nodejs```


> **2° ETAPA:** inserir e executar comando para verificar a *versão*

```node --version```

>>O resultado deverá ser o seguinte:

```v16.13.2```



------------------------------------------------------------------------------------------------------

## 6. Postman
[Site Oficial](https://www.postman.com/downloads/)

- Versão do software: *9.04*
- Sistema Operacional: *Linux Ubuntu 20.04 LTS*

#### Descrição:

A ferramenta Postman é uma plataforma de API para construção e uso de APIs. O Postman simplifica cada etapa do ciclo de vida da API e agiliza a colaboração para que você possa criar melhores APIs — mais rapidamente.

#### Tutorial da instalação:

> **1° ETAPA:** inserir e executar comando para instalar o *Postman*

```sudo snap install postman```

>> Pronto, o PostMan está instalado em sua máquina. O processo é bem simples

> **2° ETAPA:** Basta inserir o seguinte comando no terminal para inciar o aplicativo:

```postman```

------------------------------------------------------------------------------------------------------

## 7. HTTPie
[Site Oficial](https://httpie.io/)

- Versão do software: *1.0.3* 
- Sistema Operacional: *Linux Ubuntu 20.04 LTS*

#### Descrição:

*HTTPie* é um cliente HTTP de linha de comando semelhante ao *cURL*. Mas ao contrário do *cURL*, o *HTTPie* foi projetado para facilitar o trabalho com APIs web modernas. A sintaxe do *HTTPie* é voltada para o trabalho com serviços web. Sua interface é construída para ser mais legível e fácil de usar do que *cURL*. Esses recursos fazem do *HTTPie* uma ótima ferramenta para testar, depurar ou trabalhar com serviços web da linha de comando.


#### Tutorial da instalação:

> **1° ETAPA:** inserir e executar comando para adicionar e instalar o *HttPie*

```sudo apt install httpie```


> **2° ETAPA:** inserir e executar comando para verificar a *versão*

```http --version```

>>O resultado deverá ser o seguinte:

```1.0.3```

------------------------------------------------------------------------------------------------------
