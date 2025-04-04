# Jogo Simples de Criação de Personagem  

Este projeto é um exercício prático desenvolvido para a fixação de aprendizado em programação.  
A atividade foi sugerida em sala de aula pelo professor **Túlio Cearamicoli Vivaldini**.  

## Sobre o Jogo  
O jogo simula um personagem com atributos básicos, onde o jogador pode interagir realizando ações como caçar, comer e dormir. O objetivo é gerenciar os atributos do personagem e alcançar 10 pontos de experiência antes que sua energia se esgote ou seus níveis de fome e sono atinjam o limite(que são 10).  

## Regras do Jogo  

- O loop de repetição do jogo se encerra quando uma das seguintes condições for atingida:  
  - **Energia ≤ 0**  
  - **Fome = 10**  
  - **Sono = 10**  
  - **Experiência = 10** (o personagem sobe de nível)  

- Os atributos **energia, fome e sono** possuem valores limitados entre **0 e 10**.  

### Ações do Personagem  

- **Caçar:**  
  - Gasta **2 pontos de energia**.  
  - Aumenta **1 ponto de fome** e **1 ponto de sono**.  
  - Só pode ser realizada se o personagem tiver pelo menos **2 pontos de energia**.  

- **Comer:**  
  - Reduz **1 ponto de fome**.  
  - Aumenta **1 ponto de energia**.  
  - Só pode ser realizada se a fome for **maior ou igual a 1**.  

- **Dormir:**  
  - Reduz **1 ponto de sono**.  
  - Aumenta **1 ponto de energia**.  
  - Só pode ser realizada se o sono for **maior ou igual a 1**.  

### Experiência e Condição de Vitória  

- A cada **caça realizada**, o personagem ganha **1 ponto de experiência**.  
- Ao atingir **10 pontos de experiência**, o jogo termina com vitória, desde que o personagem não tenha ficado sem energia ou atingido os limites de fome e sono.  
