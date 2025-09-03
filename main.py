import numpy as np
import matplotlib.pyplot as plt

def amdahl_speedup(P, N):
    return 1 / ((1 - P) + (P / N))

def gustafson_speedup(P, N):
    return N - (1 - P) * (N - 1)

# Parâmetros
P_values = [0.5, 0.75, 0.95, 0.99]
N_values = np.arange(1, 65)

# Gráfico Lei de Amdahl
plt.figure(figsize=(8, 5))
for P in P_values:
    speedups = [amdahl_speedup(P, N) for N in N_values]
    plt.plot(N_values, speedups, label=f'P={P}')
plt.xlabel('Número de Processadores (N)')
plt.ylabel('Speedup')
plt.title('Aceleração pela Lei de Amdahl')
plt.legend()
plt.grid(True)
plt.savefig('grafico_amdahl.png')
plt.close()

# Gráfico Lei de Gustafson
plt.figure(figsize=(8, 5))
for P in P_values:
    speedups = [gustafson_speedup(P, N) for N in N_values]
    plt.plot(N_values, speedups, label=f'P={P}')
plt.xlabel('Número de Processadores (N)')
plt.ylabel('Speedup')
plt.title('Aceleração pela Lei de Gustafson')
plt.legend()
plt.grid(True)
plt.savefig('grafico_gustafson.png')
plt.close()

# Exemplo de prints para incluir no artigo
P = 0.95
N = 8
amdahl = amdahl_speedup(P, N)
gustafson = gustafson_speedup(P, N)
print(f"Speedup (Amdahl) para P={P}, N={N}: {amdahl:.2f}")
print(f"Speedup (Gustafson) para P={P}, N={N}: {gustafson:.2f}")