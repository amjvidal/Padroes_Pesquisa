# Padroes_Pesquisa

## Anotnio Mario Jesus Vidal Leite e Lucas Matheus Elias Silva Teixeira dos Santos

## Resposta da I.A.

Este tutorial foi elaborado para te ajudar a resolver a questão aplicando o padrão Strategy. Cada passo a seguir representa uma etapa lógica da implementação e deve corresponder a um commit individual no seu repositório, conforme exigido nas instruções da sua atividade.

Siga os passos, faça as alterações no seu código, e realize um commit para cada um deles. Na mensagem do commit, você deve documentar a interação com a IA (neste caso, a sugestão que estou te dando e qualquer ajuste que você fizer por conta própria).

Passo 1: Criar a Interface de Filtro (Strategy)
O primeiro passo é definir a "Estratégia" de filtragem. O modelo de busca não deve saber como as strings são filtradas, apenas que existe uma regra.

Abra o arquivo WebSearchModel.java.
Adicione uma nova interface chamada QueryFilter dentro da classe (ou como um novo arquivo, mas dentro da classe é mais simples).
Esta interface deve ter um único método que recebe a string da consulta e retorna um booleano.
Ação: Após fazer essa alteração, faça um commit. Sugestão de Mensagem do Commit: "passo 1 (IA): Criar interface QueryFilter para o padrão Strategy" Dica: Se você achar melhor criar a interface em um arquivo separado, faça isso e adicione um comentário explicando o motivo dessa sua adaptação (ex: "preferi separar para manter a classe menor").
Passo 2: Atualizar o Registro de Observadores
Agora precisamos modificar o modelo para que ele guarde não apenas o observador, mas também o filtro associado a ele.
Ação: Após fazer essa alteração, faça um commit. Sugestão de Mensagem do Commit: "passo 1 (IA): Criar interface QueryFilter para o padrão Strategy" Dica: Se você achar melhor criar a interface em um arquivo separado, faça isso e adicione um comentário explicando o motivo dessa sua adaptação (ex: "preferi separar para manter a classe menor").

Em WebSearchModel.java, crie uma classe interna privada para agrupar o observador e seu filtro.
Atualize a lista observers para usar essa nova classe.
Modifique o método addQueryObserver para receber também o QueryFilter.
Ação: Faça o segundo commit. Sugestão de Mensagem do Commit: "passo 2 (IA): Modificar registro de observadores para aceitar o QueryFilter"
Passo 3: Aplicar o Filtro Antes de Notificar
O modelo agora possui os filtros, mas precisamos usá-los! Antes de notificar um observador sobre uma nova linha do arquivo, o modelo deve checar se o filtro permite.

Em WebSearchModel.java, localize o método notifyAllObservers(String line).
Modifique o laço de repetição (loop) para verificar o filtro antes de chamar onQuery.

Ação: Faça o terceiro commit. Sugestão de Mensagem do Commit: "passo 3 (IA): Aplicar o filtro Strategy antes de notificar observador"

Passo 4: Atualizar o Cliente (Snooper) com as Estratégias
Agora que o nosso modelo já suporta filtros dinâmicos, vamos alterar o cliente Snooper.java para criar os observadores exigidos pela questão.

Abra Snooper.java. Remova o observador genérico que está no construtor.
Adicione o primeiro observador: Imprime "Oh Yes! " se a consulta tiver a palavra 'friend' (ignorando maiúsculas/minúsculas).
Adicione o segundo observador: Imprime "So long " se a consulta for maior que 60 caracteres.

Ação: Faça o quarto commit. Sugestão de Mensagem do Commit: "passo 4 (IA): Criar observadores no Snooper usando filtros específicos" Dica: Se você preferir usar Expressões Lambda (Java 8+) para deixar o código do Snooper mais limpo, faça isso! Esse seria um excelente ajuste seu sobre o código da IA, que você pode documentar na mensagem do commit.
