# bank-core/capd-bff-boleto-rapido :rocket:

[![Quality Gate Status](https://sonarqube.bank.com.br:8443/sonarqubeenterprise/api/project_badges/measure?project=capd-bff-boleto-rapido&metric=alert_status)](https://sonarqube.bank.com.br:8443/sonarqubeenterprise/dashboard?branch=develop&id=br.com.bank.bank-core.capd-bff-boleto-rapido)
[![Bugs](https://sonarqube.bank.com.br:8443/sonarqubeenterprise/api/project_badges/measure?project=capd-bff-boleto-rapido&metric=bugs)](https://sonarqube.bank.com.br:8443/sonarqubeenterprise/project/issues?branch=develop&resolved=false&types=BUG&inNewCodePeriod=true&id=br.com.bank.bank-core.capd-boleto-rapido)
[![Code Smells](https://sonarqube.bank.com.br:8443/sonarqubeenterprise/api/project_badges/measure?project=capd-fed-boleto-rapido&metric=code_smells)](https://sonarqube.bank.com.br:8443/sonarqubeenterprise/project/issues?branch=develop&resolved=false&types=CODE_SMELL&inNewCodePeriod=true&id=br.com.bank.bank-core.capd-boleto-rapido)
[![Coverage](https://sonarqube.bank.com.br:8443/sonarqubeenterprise/api/project_badges/measure?project=capd-fed-boleto-rapido&metric=coverage)](https://sonarqube.bank.com.br:8443/sonarqubeenterprise/component_measures?id=br.com.bank.bank-core.capd-bff-boleto-rapido&metric=new_coverage&branch=develop&view=list)
<br /><br />

![Java](https://img.shields.io/badge/Java-17-green?style=plastic&logo=java)
![Spring Boot](https://img.shields.io/badge/SpringBoot-2.7.6-green?style=plastic&logo=spring)
![Spring Cloud](https://img.shields.io/badge/SpringCloud-2021.0.3-green?style=plastic&logo=spring)
![JUnit](https://img.shields.io/badge/JUnit-5-green?style=plastic&)
![Maven](https://img.shields.io/badge/Maven-green?style=plastic)
<br />

## Indice
* [Introdução](#introdução)
  * [Descrição do projeto](#descricao-projeto)
  * [Arquitetura do projeto](#arquitetura-projeto)
  * [Rotas do projeto](#rotas-do-projeto)
* [Acesso ao Projeto](#acesso-ao-projeto)
* [Montando ambiente localmente](#montagem-de-ambiente)
* [Cronograma do projeto](#status-do-Projeto)
* [Demonstração da aplicação](#demonstração-da-aplicação)
  * [Rodando localmente](#rodando-localmente)
  * [Rodando em TU/TH](#rodando-em-TU/TH)
* [Projetos coligados](#pessoas-contribuidoras)

<a name="principaisCaracteristicasResponsabilidade"></a>

# #Introdução
Este documento tem como objetivo principal auxiliar um desenvolvedor a entender como funciona o projeto do *capd-bff-boleto-rapido*, onde conseguir informações sobre esse projeto, como fazer para preparar seu ambiente, como realizar testes locais, onde fazer as solicitações de acesso e quais são os outros projetos da equipe.

## #Descrição do projeto
Essa jornada Possibilitar que o usuário do PDPJ possa emitir um boleto de aporte, sendo o beneficiário final o próprio emissor, para que ele possa depositar dinheiro em espécie na sua conta PJ.

## #Arquitetura do projeto

O pojeto em questão utiliza a arquitetura Hexagonal, para mais detalhe acesse [WK: Arquitetura Hexagonal](https://confluence.bank.com.br:8443/display/HBLESC/WK%3A+Arquitetura+Hexagonal)

## #Rotas do projeto

Para testes locais utilizando o Swagger, utilizamos esse link

```
http://localhost:8080/swagger-ui/index.html
```

# #`Acesso ao Projeto`

Nessa parte, iremos detalhar melhor como ter acesso a alguns documentos e tecnologias para conseguir ter acesso completo ao projeto. Primeiro deve se ir em [DevOpsAdmin - Licenciar Usuario](https://devopsadmin.bank.com.br:8443/devopsadm/#/licenciar-usuario). Nessa página pedir acesso as ferramentas *Bitbucket, Nexus e SonarQube*, *Confluence*, *Jira* e *GitHub*. Necessário esperar 7 minutos após as solicitações.

<p align="center">
 <img src=".github/imagensReadMe/acessoDevOps/acessosDevOps_1.png" alt="Texto Alternativo" width="300" height="200"><br />
 <img src=".github/imagensReadMe/acessoDevOps/acessosDevOps_2.png" alt="Texto Alternativo" width="300" height="200">
</p>

Após conseguir o acesso, faça o login no [DevOpsAdmin](https://devopsadmin.bank.com.br:8443/devopsadm/#/main) e ir no botão de Hamburguer no canto superior esquerdo e seguir esse caminho: **Solicitações -> GitHub -> Acessos**.  

<p align="center">
 <img src=".github/imagensReadMe/acessoDevOps/acessosDevOps_3.png" alt="Texto Alternativo" width="300" height="200"><br />
 <img src=".github/imagensReadMe/acessoDevOps/acessosDevOps_4.png" alt="Texto Alternativo" width="300" height="200"><br />
 <img src=".github/imagensReadMe/acessoDevOps/acessosDevOps_5.png" alt="Texto Alternativo" width="300" height="200">
</p>

Nessa parte, deve ir em `Selecione um projeto GitHub habilitado` e escrever no local do - *PDPJ - CASH MANAGEMENT | CASH PDPJ*. Na parte do `Selecione o time:` fazer a solicitação de acordo com sua função. Ou seja, *pdpj-gh-SUA_FUNÇÃO*, abaixo escrever um justificativa do motivo de acesso e aguardar a aprovação. 

<p align="center">
 <img src=".github/imagensReadMe/acessoDevOps/acessosDevOps_6.png" alt="Texto Alternativo" width="300" height="200">
</p>

É possível confirmar se seu acesso foi liberado [nesta página](https://devopsadmin.bank.com.br:8443/devopsadm/#/solicitacoes/acessos) do DevOpsAdmin, na aba *consultar*. (Caso necessario, as pessoas que aprovam a liberação de acesso se encontram nessa página: [Aprovadores](https://confluence.bank.com.br:8443/pages/viewpage.action?pageId=1702989672))

# #Montando ambiente localmente

Para a configuração do ambiente, é sugerido seguir o passo a passo desse guia de [Instalação e configurações - Java](https://confluence.bank.com.br:8443/pages/viewpage.action?pageId=1857260397). Nesse link tem instruções para instalação da JDK, Maven, instalação da IDE e o Git Bash.

Porém algumas considerações são necessárias. Sobre a JDK, é possível usar todas que sejam superior a 17 (Preferindo as versões estáveis do Java). Também sugerimos o uso da IDE IntelliJ community edition.

Em relação a configuração do *settings* na pasta .m2, usar esse conteudo para acesso ao projeto
```xml
<settings>
    <mirrors>
        <mirror>
            <id>central</id>
            <mirrorOf>central</mirrorOf>
            <name>Central Repository</name>
            <url>https://nexusrepository.bank.com.br:8443/repository/plataformadigitalpj-maven-central/</url>
        </mirror>
        <mirror>
            <id>central-no-ssl</id>
            <name>Central without ssl</name>
            <url>http://repo.maven.apache.org/maven2</url>
            <mirrorOf>central</mirrorOf>
        </mirror>
    </mirrors>
    <servers>
        <server>
            <id>central</id>
            <username>SEU_USUARIO(iXXXXXX)</username>
            <password>SUA_SENHA</password>
        </server>
        <server>
            <id>plataformadigitalpj</id>
            <username>SEU_USUARIO(iXXXXXX)</username>
            <password>SUA_SENHA</password>
            <configuration>
                <timeout>600000</timeout> <!-- 5 seconds -->
            </configuration>
        </server>
    </servers>
    <profiles>
        <profile>
            <id>properties</id>
            <activation>
            <activeByDefault>true</activeByDefault>
            </activation>
            <properties>
                <repository.base>https://nexusrepository.bank.com.br:8443/repository/</repository.base>
                <repository.maven.central>-maven-central/</repository.maven.central>
                <repository.maven.snapshot>-maven-snapshot/</repository.maven.snapshot>
                <repository.maven.release>-maven-release/</repository.maven.release>
                <repository_domain_name>plataformadigitalpj</repository_domain_name>
                <bamboo_inject_dominio>plataformadigitalpj</bamboo_inject_dominio>
            </properties>
        </profile>
    </profiles>
</settings>
```
Lembrando que é necessario alteração da senha sempre que ela for alterada no GIDE.

Após configurar todos os documento e ter clonado o [projeto](https://github.com/bank-Core/capd-bff-agendamento-pagamento), ir na pasta dele e rodar dentro dessa pasta os seguintes comandos, para instalação das dependências do projeto:
```bash
mvn clean install

Em seguida:
mvn clean compile
```
Por fim, será necessário a configuração do SonarQube. Vá no botão hamburguer no canto superior esquedo do IntelliJ. E siga a rota abaixo:

<p align="center">
 <img src=".github/imagensReadMe/intelliJSonar/Passo_1.png" alt="Texto Alternativo" width="300" height="200"><br />
 <img src=".github/imagensReadMe/intelliJSonar/Passo_2.png" alt="Texto Alternativo" width="300" height="200"><br />
 <img src=".github/imagensReadMe/intelliJSonar/Passo_3.png" alt="Texto Alternativo" width="300" height="200"><br />
 <img src=".github/imagensReadMe/intelliJSonar/Passo_4.png" alt="Texto Alternativo" width="300" height="200">
</p>

Ao ser instalado, aparecerá um novo ícone do lado esquedo da sua IDE, sendo a primeira, de cima pra baixo. 

<p align="center">
 <img src=".github/imagensReadMe/intelliJSonar/Passo_5.png" alt="Texto Alternativo" width="300" height="200">
</p>

Clique nesse ícone e na página que abrir, vá no simbolo das ferramentas. Na aba *Bind to SonarQube* ir em `configure the connection.`

<p align="center">
 <img src=".github/imagensReadMe/intelliJSonar/Passo_6.png" alt="Texto Alternativo" width="300" height="200"><br />
 <img src=".github/imagensReadMe/intelliJSonar/Passo_7.png" alt="Texto Alternativo" width="300" height="200">
</p>

Nessa nova Aba, ir no simbolo +, e selecionar o SonarQube Server, colocar o nome de referência do sonar (sugerimos sonar-bank) e colocar esse link para o acesso
```
https://sonarqube.bank.com.br:8443/sonarqubeenterprise/projects
```

<p align="center">
 <img src=".github/imagensReadMe/intelliJSonar/Passo_8.png" alt="Texto Alternativo" width="300" height="200"><br />
 <img src=".github/imagensReadMe/intelliJSonar/Passo_9.png" alt="Texto Alternativo" width="300" height="200"><br />
 <img src=".github/imagensReadMe/intelliJSonar/Passo_1.png" alt="Texto Alternativo" width="300" height="200">
</p>

Após configurar, pedir para criar o token e aceita-lo. Após isso, voltar a tela inicial do *bind to SonarQube* e selecionar a nova conexão criada e colocar o código do projeto que estamos utilizando: `br.com.bank.bank-core.capd-bff-boleto-rapido`. Por fim, ir na aba *Report* e clicar no ícone da pasta com prompt de comando e clicar em *Proceed*.

<p align="center">
 <img src=".github/imagensReadMe/intelliJSonar/Passo_10.png" alt="Texto Alternativo" width="300" height="200"><br />
 <img src=".github/imagensReadMe/intelliJSonar/Passo_11.png" alt="Texto Alternativo" width="300" height="200">
</p>

# #Cronograma do projeto
Para conseguir acompanhar a evolução e tasks do projeto, basta acessar o [Jira - Chui](https://jira.bank.com.br:8443/secure/RapidBoard.jspa?rapidView=110415&projectKey=PDPJ&sprint=186850&quickFilter=205540)

# #Demonstração da Aplicação

## #Rodando localmente

Para rodarmos localmente, iremos em *CurrentFile* e ir em `editar configurações.` Nesse página, clicar no icone + para criar uma nova configuração e escolher *application*.

<p align="center">
<img src=".github/imagensReadMe/testeLocal/testeLocal_1.png" alt="Texto Alternativo" width="300" height="200"><br />
<img src=".github/imagensReadMe/testeLocal/testeLocal_2.png" alt="Texto Alternativo" width="300" height="200"><br />
<img src=".github/imagensReadMe/testeLocal/testeLocal_3.png" alt="Texto Alternativo" width="300" height="200"><br />
<img src=".github/imagensReadMe/testeLocal/testeLocal_4.png" alt="Texto Alternativo" width="300" height="200">
</p>

No passo seguinte ir em *Modify options* e escolher *Add VM configurations*.

<p align="center">
 <img src=".github/imagensReadMe/testeLocal/testeLocal_5.png" alt="Texto Alternativo" width="300" height="200">
</p>

Irá colocar um nome de sua escolha. Colocar a JDK para a JDK 17(1). Dentro de VM options colocar(2)
```
-Dspring.profiles.active=local 
-Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true
```
Na main class, ir no ícone de "Folha de papel" no canto e escolher *application* (3)e colocar ok.

<p align="center">
 <img src=".github/imagensReadMe/testeLocal/testeLocal_6.png" alt="Texto Alternativo" width="300" height="200">
</p>

Seguindo esses passos, estará pronto para rodar o BFF localmente.

# #Projetos coligados

Para ver quais outros projetos estão sendo desenvolvidos, acesse o [Confluence](https://confluence.bank.com.br:8443/pages/viewpage.action?pageId=2169345792) da squad. Sendo possível ver quais são os membros da squad, e seus respectivos cargos, e também será possível ver outras Squads dentro do mesmo projeto.
