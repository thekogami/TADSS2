# 🧵 Threads e Concorrência – Roadmap de Estudos

## 📝 Flashcards – Threads e Concorrência

### Fundamentos de Threads
**Q:** Qual a diferença entre processo e thread?  
**A:** Processo é independente e tem seu próprio espaço de memória. Thread é uma unidade leve de execução dentro de um processo, compartilhando memória.  

**Q:** Quais são os estados básicos de uma thread?  
**A:** New, Runnable, Running, Waiting/Blocked, Terminated.  

**Q:** Diferença entre Runnable e Waiting?  
**A:** Runnable está pronto para executar, mas aguardando CPU. Waiting está suspenso até receber um sinal ou evento.  

---

### Concorrência vs Paralelismo
**Q:** O que é concorrência?  
**A:** Execução intercalada de várias tarefas em um núcleo.  

**Q:** O que é paralelismo?  
**A:** Execução simultânea de várias tarefas em múltiplos núcleos.  

**Q:** Diferença entre preemptivo e cooperativo?  
**A:** Preemptivo: SO pode tirar a CPU de uma thread.  
Cooperativo: thread decide liberar CPU (ex.: `yield`).  

**Q:** O que é uma thread selfish?  
**A:** Thread que não usa `yield`, podendo causar starvation.  

---

### Sincronização
**Q:** O que é mutex?  
**A:** Mecanismo de exclusão mútua que garante que apenas uma thread acesse um recurso por vez.  

**Q:** O que faz a palavra-chave `synchronized` em Java?  
**A:** Garante que apenas uma thread por vez execute o código protegido pelo monitor do objeto.  

**Q:** O que é starvation?  
**A:** Quando threads de baixa prioridade não conseguem tempo de CPU porque outras ocupam sempre o recurso.  

---

### Métodos Importantes de Threads (Java)
**Q:** Diferença entre `start()` e `run()`?  
**A:** `start()` cria uma nova thread. `run()` apenas executa o método no mesmo fluxo atual.  

**Q:** O que faz `yield()`?  
**A:** Sugere ao escalonador que a thread atual pode liberar a CPU para outra.  

**Q:** O que faz `sleep(ms)`?  
**A:** Suspende a thread atual por um tempo determinado, sem liberar locks.  

**Q:** Para que servem `park()` e `unpark()`?  
**A:** São usados para suspender (`park`) e retomar (`unpark`) uma thread, via `LockSupport`.  

---

### Escalonamento
**Q:** Qual o papel do scheduler?  
**A:** Decide qual thread em estado Runnable vai ser executada pela CPU.  

**Q:** Diferença entre blocked e waiting?  
**A:** Blocked: esperando um lock/liberação de recurso.  
Waiting: suspensa esperando sinal de outra thread.  

---

### Leis de Speedup
**Q:** O que diz a Lei de Amdahl?  
**A:** O speedup tem limite por causa da parte sequencial do programa.  

**Q:** Fórmula do Speedup de Amdahl?  
**A:** `S(n) = 1 / (f + (1-f)/n)`  

**Q:** O que diz a Lei de Gustafson?  
**A:** Considera que, ao aumentar o problema, a parte paralela também cresce, permitindo maior speedup.  

**Q:** O que é speedup negativo?  
**A:** Quando usar threads torna a execução mais lenta que o sequencial, por overhead de criação/sincronização.  

---

### Questões de Código
**Q:** O que acontece se executarmos `start()` em vez de `run()`?  
**A:** `start()` cria uma nova thread, enquanto `run()` roda no mesmo fluxo atual.  

**Q:** Saída de programas com múltiplas threads é determinística?  
**A:** Não. A ordem depende do escalonador do SO → **indeterminada**.  

**Q:** O que acontece se chamar `Thread.sleep(0)`?  
**A:** A thread cede a CPU imediatamente, mas pode ser reescalonada logo em seguida.  

---
### Diagrama de Ciclo de Vida de uma Thread

![Diagrama de Ciclo de Vida de uma Thread](diagrama%20thread.jpeg)