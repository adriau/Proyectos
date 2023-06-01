# O xogo do blackjack... simple.
# Ao blackjack se xoga con baralla francesa: A,K,Q,J,10..2 un total de 52 cartas.
# As cartas se agrupan en mans e a puntuación da man se consegur sumando a puntuación de cada carta tendo en conta que:
# cada carta númerica vale o seu número
# as cartas K,Q,J valen 10
# O as pode valer 11 ou 1, dependendo do necesario.
# 
# A puntuación máis alta obxectivo é chegar 21. Se a man ten mais de 21 puntos se perde.
# Cada xogador ten unha man e se elixe ao gañador (se o hai) como o que ten a puntuación maior (sen pasarse do límite)

from random import randint

def func_primera_jugada():
    global baraja
    for i in range(2):
        a = randint(0, 3)
        b = randint(0 ,len(baraja[a])-1)
        carta_aux = baraja[a][b]
        cartas.append(baraja[a][b])
        eliminar_carta(a, b)
        crear_mano(a, carta_aux)
    return cartas

def crear_mano(a, carta):
    global cartas_mano
    if a == 0: cartas_mano.append(f"{carta} de picas")
    if a == 1: cartas_mano.append(f"{carta} de corazones")
    if a == 2: cartas_mano.append(f"{carta} de diamantes")
    if a == 3: cartas_mano.append(f"{carta} de trebol")

def mano(cartas_mano):
    for i in cartas_mano:
        if cartas_mano.index(i) == len(cartas_mano)-1:
            print(i)
        else:
            print(i, end=", ")
    print()

def func_puntuacion(cartas):
    puntuacion = 0
    puntuacion2 = 0
    for i in cartas:
        if(i=="J" or i=="Q" or i=="K"): 
            valor = 10
        elif(i=="A"):
            valor = 1
        else:
            valor = int(i)
        puntuacion += valor

        if(i=="J" or i=="Q" or i=="K"):
            valor = 10
        elif(i=="A"):
            valor = 11
        else:
            valor = int(i)
        puntuacion2 += valor

        if puntuacion == 21:
            puntuacion3 = puntuacion
        elif puntuacion2 == 21:
            puntuacion3 = puntuacion2
        elif puntuacion < puntuacion2:
            puntuacion3 = puntuacion
        elif puntuacion2 < puntuacion:
            puntuacion3 = puntuacion2
        else:
            puntuacion3 = puntuacion2
    return puntuacion3

def eliminar_carta(a, b):
    global baraja
    del baraja[a][b]

if __name__ == "__main__":
    cartas_mano = []
    diamante = ["A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"]
    trebol = ["A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"]
    corazon = ["A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"]
    picas = ["A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"]
    baraja = [picas, corazon, diamante, trebol]
    cartas = []

    puntuacion = 0
    puntuacion2 = 0
    puntuacion3 = 0
    valor = 0

    bandera = True

    while bandera:
        jugar = True
        
        cartas = func_primera_jugada()
        mano(cartas_mano)
        puntuacion3 = func_puntuacion(cartas)
        print(f"total: {puntuacion3}")
        while jugar:
            if puntuacion3 < 21:
                print("Otra carta (s/n)")
                respuesta = input()
                if(respuesta == "s"):
                    a = randint(0, 3)
                    b = randint(0 ,len(baraja[a])-1)
                    carta = baraja[a][b]
                    cartas.append(carta)
                    eliminar_carta(a, b)

                    crear_mano(a, carta)
                    mano(cartas_mano)

                    puntuacion3 = func_puntuacion(cartas)
                    print(f"total: {puntuacion3}")
                else: 
                    jugar = False
                    bandera = False
            elif puntuacion3 == 21:
                print("GANASTE")
                jugar = False
                bandera = False
            else:
                jugar = False
                bandera = False
                print("PERDISTE")