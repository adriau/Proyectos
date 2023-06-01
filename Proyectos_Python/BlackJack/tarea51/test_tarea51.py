from tarea51 import func_puntuacion, func_primera_jugada, mano

def test_func_puntuacion():
    assert func_puntuacion(["A", "J"]) == 21
    assert func_puntuacion(["3","4","J"]) == 17
    assert func_puntuacion(["A", "3", "Q", "7"]) == 21
