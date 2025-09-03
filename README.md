# 📚 Roadmap de Estudos – Prova de Threads e Concorrência

## 1. Fundamentos de Threads
- [ ] O que é uma **thread** e como se diferencia de um processo.  
- [ ] Ciclo de vida de uma thread (estados: New, Runnable, Running, Waiting/Blocked, Terminated).  
- [ ] Diferença entre **Runnable** e **Waiting**.  
- [ ] Diagrama de transições de estados.  

---

## 2. Concorrência vs Paralelismo
- [ ] Concorrência: execução intercalada de várias tarefas em um núcleo.  
- [ ] Paralelismo: execução simultânea de tarefas em múltiplos núcleos.  
- [ ] Diferença entre **Preemptivo** e **Cooperativo**:
  - Preemptivo: o SO pode retirar a CPU de uma thread.  
  - Cooperativo: a thread libera a CPU voluntariamente (`yield`).  
- [ ] Thread selfish: não usa **yield**, pode gerar **starvation**.  

---

## 3. Sincronização
- [ ] Conceito de **mutex** e exclusão mútua.  
- [ ] Palavra-chave `synchronized` (Java):  
  - Bloqueio em nível de objeto (monitor).  
  - Apenas **uma thread por vez** entra no bloco.  
- [ ] Diferença entre **lock**, **monitor** e **mutex**.  
- [ ] Problema de **starvation**: quando threads de baixa prioridade nunca recebem CPU.  

---

## 4. Métodos Importantes de Threads (Java)
- [ ] `Thread.start()` vs `run()`.  
- [ ] `Thread.yield()` – cooperativo.  
- [ ] `Thread.sleep(ms)` – pausa a execução atual (não libera lock).  
- [ ] `park()` e `unpark()` (classe `LockSupport`).  
- [ ] Diferença entre **blocked** e **waiting**.  

---

## 5. Escalonamento (Scheduler)
- [ ] Papel do **scheduler** do SO.  
- [ ] Critérios de escalonamento: prioridades, quantum, preempção.  
- [ ] O que significa **thread parked**.  
- [ ] Diferença entre escalonamento **preemptivo** e **cooperativo**.  

---

## 6. Leis de Speedup
- [ ] **Lei de Amdahl**:
  - Fórmula: `S(n) = 1 / (f + (1-f)/n)`  
  - Limite imposto pela parte **sequencial**.  
- [ ] **Lei de Gustafson**:
  - Considera que ao aumentar o problema, a parte paralela cresce.  
  - Mais otimista que Amdahl.  
- [ ] Diferença entre **speedup real**, **speedup ideal** e quando pode ser **negativo**.  

---

## 7. Questões de Código (Java)
- [ ] Revisar código `class Teste extends Thread`.  
- [ ] Saída é **indeterminada** devido ao escalonador.  
- [ ] Praticar exemplos com:
  - Threads imprimindo números.  
  - Uso de `sleep()`, `yield()`, `synchronized`.  
- [ ] Saber explicar porque a ordem é **não determinística**.  

---

## 8. Tópicos que mais caem (segundo professor)
- [ ] Leis de Amdahl e Gustafson.  
- [ ] Introdução a Threads.  
- [ ] Threads em Java (código).  
- [ ] Exercício de SpeedUp.  
- [ ] Concorrência vs Paralelismo.  
- [ ] Mutex e sincronização.  

---

## 9. Estratégia de Revisão
1. **Primeiro dia** → Teoria: Concorrência vs Paralelismo + Mutex/synchronized + Preemptivo/Cooperativo.  
2. **Segundo dia** → Speedup (Amdahl e Gustafson) + Exercícios resolvidos de prova anterior.  
3. **Terceiro dia** → Foco em código Java: praticar, rodar exemplos, revisar diagramas.  
4. **Véspera da prova** → Revisão geral rápida + refazer diagrama de estados da thread.  