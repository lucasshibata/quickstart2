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