# EP2-COO
Exercício-Programa do Professor Coutinho, onde tivemos que aplicar conceitos de SOLID, Strategy e Decorators

# Participantes
```
Lucas Kledeglau Jahchan Alves - 13732182
Guilherme Campos Silva Lemes Prestes - 13720460
```

# Relatório
As principais mudanças feitas no trabalho foram a criação de enums para as variáveis referente a critério, filtro, formato e ordenação. Além disso, foram criados pacotes para auxiliar na organização e manutenção do código, portanto, foram criados os seguintes pacotes: src, Enum, Filtro, Formatacao, Ordenacao, Produto e Relatorio.

Quanto às melhorias do código, foi implementado os padrões Strategy e Decorator, assim como o padrão SOLID. Foram criadas interfaces, assim como classes para implementação do padrão Strategy e Decorator. Portanto, para cada filtro, formatação e ordenação, temos Classes responsáveis por cada opção disponível, deixando a manutenção e futuras implementações mais fáceis

No mais, foi implementada uma classe Main que é responsável por chamar a Classe GeradorDeRelatórios, assim como por tratar os argumentos passados por terminal quando está rodando o programa. Por fim, foi implementado novas opções para serem passadas no terminal referentes às novas funcionalidades de filtro, critério e ordenação.