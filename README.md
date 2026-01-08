                              Desafio Técnico Prático – Desenvolvedor(a) Back-End
Este desafio consiste no desenvolvimento de uma API REST robusta utilizando Java e o framework Spring Boot. O objetivo principal é gerenciar o controle de patrimônio do NERDS, permitindo operações completas de CRUD (Create, Read, Update, Delete).                              

Tecnologias Utilizadas

Java 21

Spring Boot

PostgreSQL (Banco de dados relacional)

Maven (Gerenciador de dependências)

Configuração do Banco de Dados

A aplicação utiliza o PostgreSQL. Para que o sistema funcione corretamente, siga os passos abaixo:

1 - Abra o seu pgAdmin (ou ferramenta de preferência).

2 - Crie um novo banco de dados chamado "patrimonios" (conforme requisito de conexão inicial).

3 - Certifique-se de que o serviço do Postgres está rodando.

Variáveis de Ambiente (.env)
Copie o arquivo igual ao utilizado no exemplo a seguir, que configura as variáveis de ambiente, configure as credenciais de acordo com a sua instalação local. Se necessário, corrija o arquivo .env com as seguintes propriedades:

DB_URL = "jdbc:postgresql://localhost:5432/patrimonios"

DB_USERNAME = "Seu Username do postgres"

DB_PASSWORD = "Seu Password do portgres"

OBS: A porta padrão é 5432. Se você configurou o seu PostgreSQL em uma porta diferente altere antes de rodar a aplicação.

IMPORTANTE: SÓ FUNCIONNARÁ SE CONFIGURAR O ARQUIVO ".env" COMO FOI EXPLICADO, POIS FOI CONFIGURADO PARA SER UTILIZADO AS VÁRIAVEIS CONFIGURADAS DESTE ARQUIVO

Documentação e Testes (Postman)

Você pode acessar e testar todos os endpoints da API através da nossa coleção pública no Postman:

https://caiorian246810-8166985.postman.co/workspace/f6812a7d-87dc-4cea-829d-1b1acce570e8/documentation/47577494-cf91148a-cc09-490b-95d1-07b7507fd943

Endpoints da API

Abaixo estão listadas as rotas disponíveis no PatrimonioController onde foi criado a rota /patrimonio:

1 - Método GET URL=localhost:8080/patrimonio 	ela retorna uma lista com todos os patrimônios cadastrados.

2 - Método GET	URL=localhost:8080/patrimonio/{id}	ela busca um patrimônio específico através do seu ID numérico.

3 - Método GET	URL=localhost:8080/patrimonio/nome/{nome}	ela busca um patrimônio através do nome informado na URL.

4 - Método POST	URL=localhost:8080/patrimonio	ela cria um novo registro de patrimônio no sistema. Este método precisa receber todas as informações via body em formato JSON: 

Ex: {
    "nome": "Mesa",
    "tipo": "Móvel",
    "numeroSerie": "13579"
    }
    
5 - Método PUT	URL=localhost:8080/patrimonio/{id} ela atualiza as informações de um patrimônio existente com base no ID e recebendo as informações via json semelhante ao POST.

Ex: {  URL=localhost:8080/patrimonio/10
    "nome": "Mesa",
    "tipo": "Móvel",
    "numeroSerie": "13579"
    }
O excemplo acima significa que o patrimônio de Id = 10 receberá as atualizações recebidas pelo body.
    
6 - Método DELETE	URL=localhost:8080/patrimonio/{id} ela remove permanentemente um patrimônio do banco de dados recebendo o Id pela URL.

Como executar

1 - Clone o repositório.

2 - Configure o banco de dados conforme as instruções acima.

3 - Importe o projeto em sua IDE (IntelliJ, Eclipse ou VS Code).

4 - Execute a classe principal PatrimoniosApplication.
