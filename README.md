⸻

📚 Roadmap de Estudos – Prova de Threads e Concorrência

1. Fundamentos de Threads
	•	O que é uma thread e como se diferencia de um processo.
	•	Ciclo de vida de uma thread (estados: New, Runnable, Running, Waiting/Blocked, Terminated).
	•	Diferença entre Runnable e Waiting (caiu no exercício do professor).
	•	Diagrama de transições (como o que está na lousa).

⸻

2. Concorrência vs Paralelismo
	•	Concorrência: várias tarefas competem pela CPU, executando de forma intercalada em um núcleo.
	•	Paralelismo: várias tarefas realmente executadas ao mesmo tempo em múltiplos núcleos.
	•	Diferença entre Preemptivo e Cooperativo:
	•	Preemptivo: o SO pode tirar a CPU de uma thread (uso de quantum).
	•	Cooperativo: a thread decide quando liberar a CPU (uso de yield).
	•	Thread selfish: não usa yield, pode gerar starvation.

⸻

3. Sincronização
	•	Conceito de mutex e exclusão mútua.
	•	Palavra-chave synchronized (Java):
	•	Bloqueio em nível de objeto (monitor).
	•	Apenas uma thread por vez entra no bloco.
	•	Diferença entre lock, monitor e mutex.
	•	Problema de starvation: quando threads de baixa prioridade nunca recebem CPU.

⸻

4. Métodos Importantes de Threads (Java)
	•	Thread.start() vs run().
	•	Thread.yield() – cooperativo.
	•	Thread.sleep(ms) – pausa a execução atual (mas não libera o lock).
	•	park() e unpark() (biblioteca LockSupport).
	•	Diferença entre blocked e waiting (I/O, locks, monitor).

⸻

5. Escalonamento (Scheduler)
	•	Papel do scheduler do SO.
	•	Critérios de escalonamento: prioridades, quantum, preempção.
	•	O que significa thread parked.
	•	Diferença entre escalonamento preemptivo e cooperativo (conectar com a lousa).

⸻

6. Leis de Speedup
	•	Lei de Amdahl:
	•	Fórmula: S(n) = \frac{1}{f + \frac{1-f}{n}}
	•	Limite imposto pela parte sequencial.
	•	Lei de Gustafson:
	•	Considera que ao aumentar o problema, a parte paralela cresce.
	•	Mais otimista que Amdahl.
	•	Diferença entre speedup real, speedup ideal e quando pode ser negativo.

⸻

7. Questões de Código (Java)
	•	Relembrar código da prova anterior: class Teste extends Thread.
	•	Revisar: saída é indeterminada porque o escalonador decide a ordem.
	•	Praticar com exemplos:
	•	Criar threads que imprimem números.
	•	Usar sleep(), yield(), synchronized.
	•	Saber explicar porque a ordem de execução é não determinística.

⸻

8. Tópicos que mais caem (segundo professor)
	•	Leis de Amdahl e Gustafson.
	•	Introdução a Threads.
	•	Threads em Java (código).
	•	Exercício de SpeedUp.
	•	Concorrência vs Paralelismo.
	•	Mutex e sincronização.

⸻

9. Estratégia de Revisão
	1.	Primeiro dia (hoje) → Teoria: Concorrência vs Paralelismo + Mutex/synchronized + Preemptivo/Cooperativo.
	2.	Segundo dia → Speedup (Amdahl e Gustafson) + Exercícios resolvidos de prova passada.
	3.	Terceiro dia → Foco em código Java: praticar, rodar exemplos, revisar diagramas.
	4.	Véspera da prova → Revisão geral rápida + refazer diagrama de memória dos estados da thread.

⸻

👉 Sugestão para o Notion:
	•	Criar checklist com cada tópico acima.
	•	Adicionar flashcards para: definições (ex: diferença entre yield e sleep).
	•	Adicionar um quadro com fórmulas (Speedup de Amdahl e Gustafson).

⸻
