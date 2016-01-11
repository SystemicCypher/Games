'''
This game has been inspired by 
Earthbound - general gameplay
Undertale - morality system and some gameplay
~~~~~~~~~~~~
From Earthbound:
-humor
-health counter (soon)
From Undertale:
-morality system
-meaningful choice
-nonviolent options
'''
import random
import os
#key game classes
os.chdir("/Users/TEST/Documents/Adventure RPG prototype/")
from charene import *
from gamemaps import *
        
#response list
exiter = True
char = 0
currentroom = 1
#key functions
def statsset():
    char.hp = 100
    char.atk = 10
    char.defn = 10
    char.agi = 10

def perchance():
    x = random.randint(1,10)
    return(x)

def charcreator():
    global char
    char = Player(input('> '),100, perchance(),perchance(),perchance(), 1)

def checkstats():
    print("Your stats:")
    print("HP: ", str(char.hp))
    print("LV: ", str(char.lvl))
    print("ATK: ", str(char.atk))
    print("DEF: ", str(char.defn))
    print("AGI: ", str(char.agi))
    
def undrstnd():
    x = input("> ")
    x = x.split()
    return(x)

def gamedecision():
    x = input("> ")
    x = x.split()
    return(x)

def diceroll():
    x = random.randint(1,6)
    return(x)

def posorneg(num):
    x = random.randint(1,2)
    if x == 1:
        return(num)
    if x == 2:
        return(-1*num)

#menus
def mainmenu():
    print("Welcome to the most infuriating RPG ever! Because all your stats are based in random number generation!")
    print("What would you like to do?")
    print("Start    Settings    Quit")
    x = input("> ")
    x = x.split()
    if x[0] == "start":
        gamebegin()
    elif x[0] == "settings":
        settings()
    elif x[0] == "quit":
        print("Goodbye....I'm gonna miss ya... ;-;")
        global exiter
        exiter = False

def settings():
    print("HAHAHAHA! YOU THOUGHT YOU COULD CHANGE YOUR FATE?!")
    print("YOU ARE AS FOOLISH AS THE REST!")
    print("Debug mode activated")
    global exiter
    exiter = False

def menu():
    print("Welcome to a USELESS menu")

def dedchk():
    char.death()

def clr():
    print('\n'*3)

def continuity():
    clr()
    print("Do you want to continue?")
    x = input("> ")
    if x.lower() == "y":
        pass
    elif x.lower() == "n":
        global exiter
        exiter = False


#game itself
def gamebegin():
    print("First off, let's start with your name.")
    print("What is your name?")
    charcreator()
    print("So your name is "+ char.name+".")
    print("And are you M or F?")
    char.gender(input("> "))
    checkstats()
    clr()
    

def game():
    print("Soon")
    continuity()
    
    
          
#this is where the fun player interaction stuff happens
while exiter == True:
    mainmenu()
    game()
          

