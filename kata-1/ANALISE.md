# Respostas - Kata 1 (Fila de Atendimento)

## 1. Qual estrutura de dados você escolheu para modelar a fila e por quê?

Utilizei uma `List<Patient>` como estrutura base e apliquei ordenação
com `Stream.sorted()` usando um `Comparator` composto.

Essa abordagem permite separar claramente as regras de prioridade da
estrutura de armazenamento dos dados, mantendo o código simples, legível
e extensível.

Como a ordenação depende de múltiplos critérios (nível de urgência,
idade e horário de chegada), utilizar um `Comparator` encadeado foi a
solução mais adequada para representar essas regras de negócio de forma
declarativa.

Caso fosse necessário manter a fila dinamicamente ordenada em tempo
real, uma alternativa seria utilizar uma `PriorityQueue`.

## 2. Qual a complexidade de tempo do seu algoritmo de ordenação? Seria diferente se a lista tivesse 1 milhão de pacientes?

A ordenação utiliza o método `sorted()` da Stream API do Java, que
internamente utiliza o algoritmo **TimSort**, com complexidade média de
**O(n log n)**.

Para uma lista com 1 milhão de pacientes, a complexidade assintótica
permaneceria a mesma (**O(n log n)**), porém o tempo absoluto de
execução aumentaria proporcionalmente ao tamanho da entrada.

Caso fosse necessário lidar com volumes muito maiores ou inserções
frequentes em tempo real, seria interessante considerar estruturas como
`PriorityQueue`, que permitem inserção ordenada incremental com melhor
eficiência operacional em cenários dinâmicos.

## 3. As regras 4 e 5 interagem entre si? Descreva o que acontece quando um paciente tem 15 anos e urgência MÉDIA.

Sim, as regras interagem.

Um paciente de 15 anos com urgência MÉDIA recebe aumento de prioridade
por ser menor de idade.

Como a urgência MÉDIA possui valor base 2 e a regra de menor adiciona +1
nível de prioridade, o paciente passa a ser tratado com prioridade
equivalente ao nível ALTA (3).

Portanto, ele será atendido antes de pacientes adultos com urgência
MÉDIA que chegaram depois dele.

## 4. Se a clínica adicionasse uma 6ª regra amanhã, como seu código lidaria com essa extensão?

O código foi estruturado de forma que as regras de priorização fiquem
centralizadas no método `calculatePriority`, facilitando a manutenção e
extensão.

Caso uma nova regra fosse adicionada, seria possível incluí-la nesse
método sem impacto na lógica de ordenação da fila.

Para cenários com maior crescimento no número de regras, uma possível
evolução seria aplicar o padrão **Strategy** ou **Chain of
Responsibility**, permitindo que cada regra de priorização fosse
encapsulada em uma classe independente, tornando o sistema mais modular
e extensível.