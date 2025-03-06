# Tarefa: Implementar e Testar um Método de Soma

Como desafio, os alunos devem implementar um método de soma na classe `App` do projeto e criar testes unitários para validar seu funcionamento usando JUnit 5.

---

## Passos da Tarefa

1. **Modificar a Classe App**
    - Adicione um método público chamado `somar` que receba dois inteiros e retorne a soma deles.
    - Exemplo:
      ```java
      public int somar(int a, int b) {
          return a + b;
      }
      ```

2. **Criar a Classe de Teste**
    - Na pasta de testes, crie uma classe de teste para a classe `App`, por exemplo, `AppTest.java`.
    - Utilize o JUnit 5 para escrever os testes unitários.

3. **Desenvolver Cenários de Teste**
    - **Teste a soma de dois números positivos.**
    - **Teste a soma de um número positivo com um negativo.**
    - **Teste a soma envolvendo o zero.**
    - *(Opcional)* Teste com números muito grandes para verificar se há algum problema de overflow.

4. **Utilizar as Asserções do JUnit 5**
    - Utilize métodos como `assertEquals(expected, result)` para confirmar se o resultado retornado pelo método está correto.

---

## Objetivos da Tarefa

- **Praticar o Uso do JUnit 5:**  
  Familiarizar os alunos com a criação e execução de testes unitários.

- **Entender a Importância dos Testes Unitários:**  
  Demonstrar como a modularização do código facilita a manutenção e evolução do projeto.

- **Aplicar Boas Práticas de Desenvolvimento:**  
  Incentivar a escrita de testes unitários desde o início, mesmo em projetos simples, reforçando a importância de isolar funcionalidades para melhorar a testabilidade do código.

---

# Tarefa de Teste Unitário: Validando o Método computeTotal

Nesta tarefa, os alunos devem criar testes unitários para validar o método `computeTotal` da classe `OrderProcessor`. Esse método é responsável por calcular o total bruto de um pedido, somando o valor de cada item (preço * quantidade).

---

## Passos da Tarefa

1. **Preparar o Ambiente de Teste:**
    - Certifique-se de que o Maven e o JUnit 5 estão configurados.
    - Os testes devem ser criados na pasta padrão.

2. **Criar a Classe de Teste:**
    - Crie uma classe de teste para `OrderProcessor`, por exemplo, `OrderProcessorTest.java`.

3. **Escrever o Teste Unitário para computeTotal:**
    - Instancie alguns objetos `OrderItem` com valores conhecidos.
    - Crie um objeto `Order` contendo esses itens.
    - Chame o método `computeTotal` da classe `OrderProcessor`.
    - Utilize uma asserção (por exemplo, `assertEquals(expected, actual)`) para comparar o valor retornado com a soma esperada dos itens.

---

# Tarefa de Teste Unitário: Validando o Método processPayment

Nesta tarefa, os alunos devem criar testes unitários para validar o método `processPayment` da classe `PaymentService`. Este método simula o processamento de pagamento e retorna `true` para indicar que o pagamento foi realizado com sucesso.

---

## Passos da Tarefa

1. **Preparar o Ambiente de Teste:**
   - Certifique-se de que o Maven e o JUnit 5 estão configurados corretamente.

2. **Criar a Classe de Teste:**
   - Crie uma nova classe de teste, por exemplo, `PaymentServiceTest.java`.

3. **Escrever os Testes Unitários:**
   - **Teste Básico:**
      - Crie um objeto `Order` com dados de teste (pode ser um pedido simples com um ou mais itens).
      - Instancie a classe `PaymentService`.
      - Chame o método `processPayment`, passando o objeto `Order` e um valor de pagamento.
      - Utilize a asserção `assertTrue` para verificar se o método retorna `true`.

   - **(Opcional)**:  
     Teste com diferentes valores de pagamento para reforçar que o método sempre retorna `true` e simula corretamente o processamento de pagamento.

4. **Utilizar as Asserções do JUnit 5:**
   - Use `assertTrue(result)` para confirmar que o pagamento foi processado com sucesso.

---

# Tarefa de Teste Unitário: Refatoração e Uso de Mockito para Testar o Fluxo Completo

Nesta tarefa, os alunos irão inicialmente tentar testar o método `process` da classe `OrderProcessor` sem utilizar Mockito, para constatar como o acoplamento dificulta o teste (especialmente porque os métodos `sendEmail` e `saveOrder` foram alterados para sempre retornar `false`). Em seguida, os alunos deverão refatorar a classe `OrderProcessor` para permitir a injeção de dependências e utilizar o Mockito para isolar os testes.

---

## Cenário Inicial: Testando sem Mockito

**Contexto:**
- Os métodos `sendEmail` (na classe `EmailService`) e `saveOrder` (na classe `OrderRepository`) foram modificados para sempre retornar `false`.
- Essa alteração simula falhas nos serviços e demonstra a dificuldade de testar o método `process` sem a capacidade de simular comportamentos diferentes.

### Passos:

1. **Criar um Teste para `OrderProcessor`:**
    - Crie a classe de teste `OrderProcessorTest.java` em `src/test/java/seu/grupo/`.
    - Escreva um teste que invoque o método `process` e observe que, devido aos métodos fixos que retornam `false`, o teste sempre falhará mesmo que os outros componentes estejam corretos.

2. **Reflexão:**
    - Discuta em sala as dificuldades encontradas ao tentar testar o fluxo completo sem mocks.
    - Identifique como o acoplamento forte e a ausência de injeção de dependências tornam impossível simular cenários de sucesso para etapas como a persistência ou envio de email.

---

## Parte 2: Refatoração para Injeção de Dependências e Uso de Mockito

### Passos para Refatoração e Teste:

1. **Refatorar a Classe OrderProcessor:**
    - Modifique a classe `OrderProcessor` para aceitar suas dependências via construtor (ou setters), permitindo a injeção de:
        - `DiscountService`
        - `InventoryService`
        - `PaymentService`
        - `OrderRepository`
        - `EmailService`
    - Essa refatoração torna possível substituir as implementações reais por mocks durante os testes.

2. **Configurar o Ambiente de Teste com Mockito:**
    - Adicione as dependências do Mockito ao seu projeto (via Maven, por exemplo).
    - No seu teste, utilize o Mockito para criar mocks para cada uma das dependências citadas.

3. **Criar a Classe de Teste com Mocks:**
    - Crie ou atualize a classe de teste `OrderProcessorTest.java`.
    - Utilize o `@BeforeEach` para inicializar os mocks e injetá-los em uma nova instância de `OrderProcessor`.

4. **Escrever Cenários de Teste:**
    - **Fluxo de Sucesso:**
        - Configure os mocks para simular sucesso em cada etapa (por exemplo, configure `saveOrder` e `sendEmail` para retornarem `true`).
        - Verifique se o método `process` retorna `true`.
    - **Fluxo de Falha:**
        - Configure os mocks para simular falhas específicas (por exemplo, `orderRepository.saveOrder` e `emailService.sendEmail` retornando `false`).
        - Verifique se o método `process` retorna `false` quando uma ou mais etapas falham.

---
