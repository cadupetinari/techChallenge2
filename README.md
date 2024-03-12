# TechChallenge

Considerando o desafio proposto para o TechChallenge, estamos diante de um case onde a expansão bem-sucedida de uma lanchonete de bairro enfrenta desafios de gerenciamento de pedidos e atendimento aos clientes devido à falta de um sistema de controle adequado. 

Esta ausência de sistema resulta em confusão entre os atendentes e a cozinha, levando a atrasos na preparação e entrega de pedidos, perda de pedidos e insatisfação dos clientes. E para resolver este problema, a lanchonete planeja implementar um sistema de autoatendimento de fast food, visando melhorar a eficiência do atendimento, gerenciamento de pedidos e estoques, e garantir uma experiência positiva para os clientes, crucial para manter o sucesso e a expansão do negócio.


## Arquitetura

Para este cenário, foi desenhada a seguinte proposta de arquitetura:

![FIAP - Tech Challenge-Modelo Negócios drawio-2](https://github.com/cadupetinari/techChallenge2/assets/93800409/66653e0c-d3b0-440c-8388-b82e95a3f572)

Para implementar tal solução foi desenvolvida uma API que fica responsável por gerenciar as principais entidades e seus casos de uso na solução:

- Usuário: Na qual permite a identificação do usuário e futuramente participação de ações de marketing;
- Categoria: Categorização dos itens disponibilizados;
- Produto: Todos os produtos que estão disponíveis para comercialização;
- Item de Pedido: Os produtos que foram selecionados para consolidar no pedido do usuário;
- Pedido: A consolidação final dos produtos escolhidos pelo usuário.

![FIAP - Tech Challenge-Arquitetura Solução drawio](https://github.com/cadupetinari/techChallenge2/assets/93800409/6a70274b-67cc-4a57-85b1-d6d03eb07e07)

E com os insumos que recebemos de negócio, foi sugerida uma arquitetura Kubernetes, na qual irá proporcionar ao nosso cliente uma solução escalável e robusta para a cadeia de fast-food, essencial em momentos picos de demanda. A escalabilidade horizontal dos pods facilita o gerenciamento do tráfego, enquanto a automação simplifica a gestão da infraestrutura. 

Com isto podemos garantir uma maior disponibilidade e confiabilidade da API, mesmo em momentos de alta movimentação. Além disso, o Kubernetes permite atualizações eficientes com rollbacks automáticos, e políticas de escalabilidade dinâmica, otimizando o custo operacional. Em resumo, sua adoção não só melhora a experiência do usuário, mas também prepara a base para a evolução futura do sistema.


## Coleções

Para um maior detalhamento da utilização destas APIs, dispomos do Swagger da API:
https://github.com/cadupetinari/techChallenge2/blob/3d2b9b9719ffd93d2130fdf298a80fbf3c33ab17/docs/FastFood%20API.yaml

E também dispomos de uma collection do Postman já configurada para utilização: https://github.com/cadupetinari/techChallenge2/blob/c2271823b16e05a4e5dac047e25f6ee7943ec4e7/docs/Collection%20FastFoodAP%20-%20Fase%202I.postman_collection.json.


## Apresentação

Também para um maior esclarecimento sobre o projeto, foi criado um pitch explicando as premissas essenciais desta solução: XXXX.

Grupo 65:
RM 353093 - Carlos Eduardo Coimbra
