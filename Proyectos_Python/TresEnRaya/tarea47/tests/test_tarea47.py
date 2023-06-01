from tarea47.tarea47 import ganador

def test_ganador():
    tablero = [["X", "|", "X", "|", "X"],["-", "", "-", "", "-"],["21", "|", "22", "|", "23"],["-", "", "-", "", "-"],["31", "|", "32", "|", "33"]]
    bandera = True
    assert ganador(tablero, 3, bandera) == False