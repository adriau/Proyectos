# Imos a implementar o xogo do tres en raia. Para iso imos a ir por partes.
# Lembra que o tablero é de 3 x 3. Fara representalo quizais sexa o mellor 
# representalo cunha lista de listas.
# - Inicializa a estrutura a baleiro.
# - Imprime o taboleiro.
# - Podes facer que X represente unha ficha do xogador 1 e O a do xogador 2
# - Fai unha función que nos indique se temos un gañador ou non.
# - Utiliza test para comprobar os casos posibles, non teñen que ser todos, pero algúns si.
# - Implementa agora o proceso de xogo:
#   - Primeiro un xogador, comproba se hai gañador, logo outro.
#   - Paras cando un gaña ou xa non hai máis movementos.

def ganador(tablero_aux, contador, bandera):
    print()
    if(tablero_aux[0][0] == "X" and tablero_aux[0][2] == "X" and tablero_aux[0][4] == "X"): bandera = False; print("Gana el jugador X")
    elif(tablero_aux[2][0] == "X" and tablero_aux[2][2] == "X" and tablero_aux[2][4] == "X"): bandera = False; print("Gana el jugador X")
    elif(tablero_aux[4][0] == "X" and tablero_aux[4][2] == "X" and tablero_aux[4][4] == "X"): bandera = False; print("Gana el jugador X")
    elif(tablero_aux[0][0] == "X" and tablero_aux[2][0] == "X" and tablero_aux[4][0] == "X"): bandera = False; print("Gana el jugador X")
    elif(tablero_aux[0][2] == "X" and tablero_aux[2][2] == "X" and tablero_aux[4][2] == "X"): bandera = False; print("Gana el jugador X")
    elif(tablero_aux[0][4] == "X" and tablero_aux[2][4] == "X" and tablero_aux[4][4] == "X"): bandera = False; print("Gana el jugador X")
    elif(tablero_aux[0][0] == "X" and tablero_aux[2][2] == "X" and tablero_aux[4][4] == "X"): bandera = False; print("Gana el jugador X")
    elif(tablero_aux[0][4] == "X" and tablero_aux[2][2] == "X" and tablero_aux[4][0] == "X"): bandera = False; print("Gana el jugador X")
    elif(tablero_aux[0][0] == "O" and tablero_aux[0][2] == "O" and tablero_aux[0][4] == "O"): bandera = False; print("Gana el jugador O")
    elif(tablero_aux[2][0] == "O" and tablero_aux[2][2] == "O" and tablero_aux[2][4] == "O"): bandera = False; print("Gana el jugador O")
    elif(tablero_aux[4][0] == "O" and tablero_aux[4][2] == "O" and tablero_aux[4][4] == "O"): bandera = False; print("Gana el jugador O")
    elif(tablero_aux[0][0] == "O" and tablero_aux[2][0] == "O" and tablero_aux[4][0] == "O"): bandera = False; print("Gana el jugador O")
    elif(tablero_aux[0][2] == "O" and tablero_aux[2][2] == "O" and tablero_aux[4][2] == "O"): bandera = False; print("Gana el jugador O")
    elif(tablero_aux[0][4] == "O" and tablero_aux[2][4] == "O" and tablero_aux[4][4] == "O"): bandera = False; print("Gana el jugador O")
    elif(tablero_aux[0][0] == "O" and tablero_aux[2][2] == "O" and tablero_aux[4][4] == "O"): bandera = False; print("Gana el jugador O")
    elif(tablero_aux[0][4] == "O" and tablero_aux[2][2] == "O" and tablero_aux[4][0] == "O"): bandera = False; print("Gana el jugador O")
    elif contador == 8: bandera = False; print("Empante")

    return bandera

tablero = [["11", "|", "12", "|", "13"],["-", "", "-", "", "-"],["21", "|", "22", "|", "23"],["-", "", "-", "", "-"],["31", "|", "32", "|", "33"]]
bandera = True
bandera_contador = True
contador = 0

for a in tablero:
    for b in range(len(tablero)):
        print(a[b], end=" ")
    print()
print()

while bandera:
    if contador % 2 == 0: 
        pieza = "X"
    else: 
        pieza = "O"

    print(f"Indica posicion (11, 23, 31), le toca a {pieza}")
    posicion = input()
    
    tablero_aux = tablero.copy()
    
    for i in tablero_aux:
        try:
            posicion_y = i.index(posicion)
            if posicion_y != None:
                posicion_x = tablero_aux.index(i)
                break
        except:
            print(end="")

    if tablero_aux[posicion_x][posicion_y] != "X" and tablero_aux[posicion_x][posicion_y] != "O":
        tablero_aux[posicion_x].pop(posicion_y)
        tablero_aux[posicion_x].insert(posicion_y, pieza)
    else:
        print("Ya hay una pieza en esa posición")
        bandera_contador = False
        print()
    
    bandera = ganador(tablero_aux, contador, bandera)

    if bandera_contador == True: 
        contador += 1 
    else: 
        bandera_contador = True

    for a in tablero_aux:
        for b in range(len(tablero_aux)):
            print(a[b], end=" ")
        print()
    print()
