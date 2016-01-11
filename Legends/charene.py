#All characters in the game have these attributes
class Character(object):
    def __init__(self, name, hp, atk, defn, agi, lvl):
        self.name = name
        self.hp = hp
        self.atk = atk
        self.defn = defn
        self.agi = agi
        self.lvl = lvl
        

    def hit(self, amount):
        self.hp -= amount

    def callby(self,partname):
        namae = self.name.split()
        partname = partname - 1
        return(namae[partname])

#only affects the player character   
class Player(Character):
    def gender(self,gender):
        self.gender = gender
        
    def death(self):
        if self.hp <= 0:
            print("Game Over")

#Enemy classdata here
class Enemy(Character):
    pass
#individual enemy data


#Cool NPCs here
class Friend(Character):
    pass
#individual npc data            
    
