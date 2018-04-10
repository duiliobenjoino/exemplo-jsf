# exemplo-jsf
Crud básico desenvolvido em JSF, Primefaces, Jpa e Mysql

Para testar esse projeto basta importá-lo em sua ide de preferência, se certificando apenas de que tenha um ambiente instalado (Java, Mysql e um container de aplicações - ex: Tomcat)

### Após importar o projeto, atente-se para configurar a conexão ao Mysql: ###
  - Criar uma base dados com o nome "jsf-exemplo"
  - src/main/resources/META-INF/persistence.xml -> defina os dados de conexão com banco

### Para utilizar essa estrutura em seu projeto, siga os seguintes passos: ###
  - Criar uma base dados no MySql com o nome de sua preferencia
  - Alterar o src/main/resources/META-INF/persistence.xml para constar os dados de conexão corretos
  - Deletar os arquivos da pasta src/main/java/cerveja/model/ e substituir pelos novos
  - Deletar a classe src/main/java/cerveja/CervejaRepository.java e criar novos
  - Deletar os arquivos da pasta src/main/java/cerveja/controller/ e criar novos
  - Deletar os arquivos *.xhtml em src/main/webapp/ e criar novos
  - Para customizar o layout base, altere o arquivo src/main/webapp/WEB-INF/template/LayoutPadrao.xhtml
  - Para customizar o visual, altere o arquivo src/main/webapp/resources/css/sistema.css
