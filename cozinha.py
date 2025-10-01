import threading
import queue
import time

escorredor = queue.Queue()
pratosSecos = 0
Threadlock = threading.Lock()

def lavagem():
    for i in range(1, 100 + 1):
        time.sleep(0.1) # tempo para lavar cada prato
        print(f"Lavagem: prato {i} lavado -> escorredor")
        escorredor.put(i)
    for _ in range(2): # 2 processos de secagem
        escorredor.put(None)


def secagem(nome):
    global pratosSecos
    while True:
        prato = escorredor.get()
        if prato is None:
            break
        time.sleep(0.1)
        with lock:
            pratosSecos += 1
            print(f"{nome}: prato {prato} seco.")
            print(f"{nome}: total pratos secos: {pratosSecos}")


if __name__ == "__main__":
    threadLavagem = threading.Thread(target=lavagem)
    threadSecador1 = threading.Thread(target=secagem, args=("Secagem 1",))
    threadSecador2 = threading.Thread(target=secagem, args=("Secagem 2",))

    threadLavagem.start()
    threadSecador1.start()
    threadSecador2.start()

    threadLavagem.join()
    threadSecador1.join()
    threadSecador2.join()

    print("\n--- FIM ---")
    print(f"Fim pro processo de lavagem.")
