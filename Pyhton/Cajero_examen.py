import datetime

d=True
saldo=1000.00
retiro=   300.00
lista=[]
def insert_pin ():
    d=0
    while d<3 :
        try:
            pin = int(input("Digite su numero de pin: "))
            t = str(pin)
            if pin == 1235:
                print("Hola Raul")
                break

            else:
                print("Contraseña incorrecta")
                d += 1
        except:
            print("No has introducido un numero entero")

    return d

def sub_menu():
    while True:
        try:
            print("Menu: 1")
            print("Finalizar:2")
            op = int(input("Inserte el numero de como desea continuar: "))
            if op == 1:
                print("Regresando al menu")
                d=True
                return d
            elif op == 2:
                d=False
                return d
            elif op<0:
                print("Ha introducido un numero negativo")
            else:
                print("No ha introducido un numero dentro de las opciones 1 y 2")
        except:
            print("No ha introducido un numero entero")


def consulta(saldo):
    print(f"Tu saldo actual es: {saldo}")

def retirar_sal(saldo):
    while True:
        try:
          ret=float(input("Digite la cantidad a retirar: "))
          if ret > saldo:
              print("No cuenta con saldo suficiente")
              mov=[]
              return mov

          elif ret<=0:
              print("No se pueden hacer retiros con numeros negativos o =0")


          else:
              print(f"Ha retirado: {ret}")
              hora=datetime.datetime.now()
              mov=[hora,ret]

              return mov
        except:
            print("Has introducido caracteres no numericos")

def historico(lista):
    if lista==[]:
        print("No se han realizado movimientos")
    else:
        for i in lista:
            print(f"Fecha: {i[0]} Retiro: {i[1]} Saldo anterior {i[2]}")

if insert_pin() < 3:
    while d==True:
        try:

            print("Menu:")
            print("Consultar de saldo: 1")
            print("Retirar saldo: 2")
            print("Histórico de movimientos: 3")
            print("Finalizar:4")
            op=int(input("Elija una opcion: "))

            if op==1:
                consulta(saldo)
                d=sub_menu()
            elif op==2:

                mov=retirar_sal(saldo)

                if mov!=[]:
                    saldo-=mov[1]

                    mov.append(saldo)

                    lista.append(mov)



                d=sub_menu()


            elif op==3:
                historico(lista)
                d=sub_menu()

            elif op==4:
                break
            else:
                print("Has introducido un numero fuera de las opciones")
        except:
            print("No has introducido un numero entero")
else:
    print("Ha sobre pasado el numero de intentos, la tarjeta ha sido bloqueada, pase a sucursal para su desbloqueo")